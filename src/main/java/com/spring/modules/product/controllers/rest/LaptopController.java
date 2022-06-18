package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
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
    @GetMapping("/item/get-by")
    @ResponseBody
    public List<LaptopDTO> getByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return getFacade().getByCountAndType(count, type, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @PutMapping(value = "/item/size")
    @ResponseBody
    public int sizeLaptop(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);

            return getFacade().filterLaptop(json).size();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @PutMapping(value = "/item")
    @ResponseBody
    public List<LaptopDTO> homePutLaptop(HttpServletRequest request, @RequestBody String data, Model model) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<LaptopDTO> laptops = getFacade().filterLaptop(json);
            int count = ((Long) json.get("count")).intValue();

            return laptops.size() > count ? laptops.subList(0, count) : laptops;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
