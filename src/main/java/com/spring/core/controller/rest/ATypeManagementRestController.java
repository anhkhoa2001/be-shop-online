package com.spring.core.controller.rest;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.facedes.impls.ATypeManagementFacade;
import com.spring.core.model.AItemModel;
import com.spring.core.response.EResponse;
import com.spring.core.service.ATypeManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
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
            description = "Create a new entity in the backend",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Entity successfully created."
            ), @ApiResponse(
                    responseCode = "409",
                    description = "Cannot create the entity."
            )}
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
            description = "Get all list entity in the backend",
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "List entity successfully return."
            ), @ApiResponse(
                    responseCode = "409",
                    description = "Cannot get list entity."
            )}
    )
    @GetMapping
    public List<DTO> getAll() {
        try {
            return getFacade().getAll();
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
    public int deleteById(@Parameter(in = ParameterIn.DEFAULT,required = true) @RequestBody String id) {
        try {
            long idL = Long.parseLong(id);

            return getFacade().deleteById(idL);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return EResponse.ERROR_EX;
        }
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
    public DTO getByCode(@RequestParam(required = true) String code) {
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
