package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.core.response.EResponse;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.facades.impls.ProductFacade;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.util.Strings;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController extends ATypeManagementRestController<LaptopDTO, LaptopModel, LaptopService, LaptopFacade> {

    private final ProductFacade productFacade;
    private final CategoryFacade categoryFacade;

    protected LaptopController(final LaptopFacade facade, final ProductFacade productFacade, final CategoryFacade categoryFacade) {
        super(facade);
        this.productFacade = productFacade;
        this.categoryFacade = categoryFacade;
    }

    @Operation(
            summary = "create laptop by form on frontend.",
            description = "create laptop by form on frontend into backend"
    )
    @PostMapping(
            value = "/create"
    )
    public ResponseEntity<LaptopDTO> createLaptop(HttpServletRequest request,
                                                      @RequestParam(value = "image", required = false) MultipartFile file) {
        try {
            final String code = request.getParameter("code");
            final CategoryDTO categoryDTO = getCategoryFacade().findByCategoryCode(code);
            if(categoryDTO.getProductLineDTO().getId() == EResponse.CMID_LAPTOP) {
                final String name = request.getParameter("name");
                final int quantity = Integer.parseInt(request.getParameter("quantity"));
                final int price = Integer.parseInt(request.getParameter("price"));
                final String display = request.getParameter("display");
                final String card = request.getParameter("card");
                final String ram = request.getParameter("ram");
                final String cpu = request.getParameter("cpu");
                final float weight = Float.parseFloat(request.getParameter("weight"));
                final String size = request.getParameter("size");
                final String memory = request.getParameter("memory");
                final String image = getProductFacade().uploadFile(file);
                final LaptopDTO entity = new LaptopDTO(code, name, price, quantity, image, display, memory, cpu, ram, card, weight, size);
                entity.setCategoryDTO(categoryDTO);

                return ResponseEntity.ok(getFacade().create(entity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
        //409 loi du lieu
    }

    @Operation(
            summary = "update laptop by form on frontend.",
            description = "update laptop by form on frontend into backend"
    )
    @PostMapping(
            value = "/update"
    )
    public ResponseEntity<LaptopDTO> updateLaptop(HttpServletRequest request,
                                                    @RequestParam(value = "image", required = false) MultipartFile file) {
        String image = getProductFacade().uploadFile(file);

        try {
            final String code = request.getParameter("code");
            final CategoryDTO categoryDTO = getCategoryFacade().findByCategoryCode(code);
            if(categoryDTO.getProductLineDTO().getId() == EResponse.CMID_LAPTOP) {
                LaptopDTO laptopDTO = getFacade().getByCode(code);
                final String name = request.getParameter("name");
                final int quantity = Integer.parseInt(request.getParameter("quantity"));
                final int price = Integer.parseInt(request.getParameter("price"));
                final String display = request.getParameter("display");
                final String card = request.getParameter("cardlap");
                final String ram = request.getParameter("ram");
                final String cpu = request.getParameter("cpu");
                final float weight = Float.parseFloat(request.getParameter("weight"));
                final String size = request.getParameter("size");
                final String memory = request.getParameter("memory");
                laptopDTO.setName(name);
                laptopDTO.setQuantityStock(quantity);
                laptopDTO.setPrice((long) price *EResponse.DOLA);
                laptopDTO.setDisplay(display);
                laptopDTO.setWeight(weight);
                laptopDTO.setSize(size);
                laptopDTO.setRam(ram);
                laptopDTO.setCpu(cpu);
                laptopDTO.setCard(card);
                laptopDTO.setMemory(memory);
                laptopDTO.setCategoryDTO(categoryDTO);
                laptopDTO.setImage(!Strings.isBlank(image) ? image : laptopDTO.getImage());
                System.out.println(image);
                System.out.println(laptopDTO.getImage());

                return ResponseEntity.ok(getFacade().update(laptopDTO));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
        //409 loi du lieu
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

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }
}
