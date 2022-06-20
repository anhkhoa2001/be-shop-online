package com.spring.core.controller.rest;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.core.model.AItemModel;
import com.spring.core.service.ATypeManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


public abstract class ATypeManagementRestController<DTO extends AItemDTO, MODEL extends AItemModel,
                                                    MS extends ATypeManagementService<MODEL>,
                                                    FACADE extends ATypeManagementFacade<DTO, MODEL, MS>> {

    private final FACADE facade;

    protected ATypeManagementRestController(final FACADE facade) {
        this.facade = facade;
    }

    @Operation(
            summary = "Create the entity.",
            description = "Create a new entity in the backend"
    )
    @PostMapping(
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public ResponseEntity<DTO> create(@Parameter(in = ParameterIn.DEFAULT,required = true) @RequestBody DTO entity) {
        if(Objects.nonNull(entity)) {
            if(StringUtils.isBlank(entity.getCode())) {
                String code = getFacade().generatorCode(MODEL.MODEL_NAME);
                entity.setCode(code);
            }

            DTO dtoCreated = getFacade().create(entity);

            return new ResponseEntity<>(dtoCreated, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get all entity.",
            description = "Get all list entity in the backend"
    )
    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        try {
            return new ResponseEntity<>(getFacade().getAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Delete the entity by id.",
            description = "Delete entity by id in the backend",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Entity successfully deleted."
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Cannot deleted the entity."
            )}
    )
    @DeleteMapping
    public ResponseEntity<DTO> deleteById(@RequestParam final long id) {
        try{
            getFacade().deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get the entity by id.",
            description = "Get entity by id in the backend",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Entity successfully geted."
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Cannot geted the entity."
            )}
    )
    @GetMapping("/get-by-id")
    public ResponseEntity<DTO> getById(@RequestParam(required = true) long id) {
        try {
            return new ResponseEntity<DTO>(getFacade().getById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get the entity by code.",
            description = "Get entity by code in the backend",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Entity successfully geted."
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Cannot geted the entity."
            )}
    )
    @GetMapping("/get-by-code")
    public ResponseEntity<DTO> getByCode(@RequestParam(required = true) final String code) {
        try {
            return new ResponseEntity<DTO>(getFacade().getByCode(code), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public FACADE getFacade() {
        return facade;
    }
}
