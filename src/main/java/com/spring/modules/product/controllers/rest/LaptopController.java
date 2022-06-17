package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController extends ATypeManagementRestController<LaptopDTO, LaptopModel, LaptopService, LaptopFacade> {

    protected LaptopController(final LaptopFacade facade) {
        super(facade);
    }

    @Operation(
            summary = "Get list laptop by count and type.",
            description = "Get list laptop by count and type in the backend"
    )
    @GetMapping("/get-by")
    public List<LaptopDTO> getByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return getFacade().getByCountAndType(count, type, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
