package com.spring.core.controller.rest;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.core.model.AItemModel;
import com.spring.core.response.EResponse;
import com.spring.core.service.ATypeManagementService;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public DTO create(@Parameter(in = ParameterIn.DEFAULT,required = true) @RequestBody DTO entity) {
        if(Objects.nonNull(entity)) {
            if(StringUtils.isBlank(entity.getCode())) {
                String code = getFacade().generatorCode(MODEL.MODEL_NAME);
                entity.setCode(code);
            }

            DTO dtoCreated = getFacade().create(entity);

            return dtoCreated;
        }

        return null;
    }

    @Operation(
            summary = "Get all entity.",
            description = "Get all list entity in the backend"
    )
    @GetMapping
    public List<DTO> getAll() {
        try {
            if(CollectionUtils.isEmpty(getFacade().getAll())) {
                return Collections.emptyList();
            } else {
                return getFacade().getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public ResponseEntity<OrderDTO> deleteById(@RequestParam final long id) {
        try{
            getFacade().deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
    public DTO getById(@RequestParam(required = true) String id) {
        try {
            long idL = Long.parseLong(id);

            return getFacade().getById(idL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    public DTO getByCode(@RequestParam(required = true) final String code) {
        try {
            return getFacade().getByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public FACADE getFacade() {
        return facade;
    }
}
