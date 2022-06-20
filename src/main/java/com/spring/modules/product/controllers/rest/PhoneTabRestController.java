package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.core.constain.FixedValue;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import com.spring.modules.product.facades.impls.ProductFacade;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.services.PhoneTabService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.logging.log4j.util.Strings;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/phone-tab")
public class PhoneTabRestController extends ATypeManagementRestController<PhoneTabDTO, PhoneTabModel, PhoneTabService, PhoneTabFacade> {

    private final ProductFacade productFacade;
    private final CategoryFacade categoryFacade;

    @Autowired
    protected PhoneTabRestController(final PhoneTabFacade facade, final ProductFacade productFacade, final CategoryFacade categoryFacade) {
        super(facade);
        this.productFacade = productFacade;
        this.categoryFacade = categoryFacade;
    }


    @PostMapping(
            value = "/create"
    )
    public ResponseEntity<PhoneTabDTO> createPhoneTab(HttpServletRequest request, HttpServletResponse response,
                                                      @RequestParam(value = "image", required = false) MultipartFile file) {
        try {
            final String code = request.getParameter("code");
            final CategoryDTO categoryDTO = getCategoryFacade().findByCategoryCode(code);
            if(categoryDTO.getProductLineDTO().getId() != FixedValue.CMID_LAPTOP) {
                final String name = request.getParameter("name");
                final int quantity = Integer.parseInt(request.getParameter("quantity"));
                final int price = Integer.parseInt(request.getParameter("price"));
                String display = request.getParameter("screen");
                String chip = request.getParameter("chip");
                String ram = request.getParameter("ram");
                String fc = request.getParameter("fc");
                String bc = request.getParameter("bc");
                String memory = request.getParameter("memory");
                final String image = getProductFacade().uploadFile(file);
                final PhoneTabDTO entity = new PhoneTabDTO(code, name, price, quantity, image, display, fc, bc, chip, memory, ram);
                entity.setCategoryDTO(categoryDTO);

                return ResponseEntity.ok(getFacade().create(entity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Operation(
            summary = "update phone and tablet by form on frontend.",
            description = "update phone and tablet by form on frontend into backend"
    )
    @PostMapping(
            value = "/update"
    )
    public ResponseEntity<PhoneTabDTO> updateLaptop(HttpServletRequest request,
                                                  @RequestParam(value = "image", required = false) MultipartFile file) {
        String image = getProductFacade().uploadFile(file);

        try {
            final String code = request.getParameter("code");
            final CategoryDTO categoryDTO = getCategoryFacade().findByCategoryCode(code);
            if(categoryDTO.getProductLineDTO().getId() != FixedValue.CMID_LAPTOP) {
                PhoneTabDTO phoneTabDTO = getFacade().getByCode(code);
                final String name = request.getParameter("name");
                final int quantity = Integer.parseInt(request.getParameter("quantity"));
                final int price = Integer.parseInt(request.getParameter("price"));
                final String display = request.getParameter("display");
                final String chip = request.getParameter("chip");
                final String ram = request.getParameter("ram");
                final String front = request.getParameter("fc");
                final String back = request.getParameter("bc");
                final String memory = request.getParameter("memory");
                phoneTabDTO.setName(name);
                phoneTabDTO.setQuantityStock(quantity);
                phoneTabDTO.setPrice((long) price);
                phoneTabDTO.setDisplay(display);
                phoneTabDTO.setChip(chip);
                phoneTabDTO.setRam(ram);
                phoneTabDTO.setFrontCamera(front);
                phoneTabDTO.setBackCamera(back);
                phoneTabDTO.setMemory(memory);
                phoneTabDTO.setCategoryDTO(categoryDTO);
                phoneTabDTO.setImage(!Strings.isBlank(image) ? image : phoneTabDTO.getImage());
                System.out.println(phoneTabDTO.toString());
                return ResponseEntity.ok(getFacade().update(phoneTabDTO));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
        //409 loi du lieu
    }

    @Operation(
            summary = "Get list phone by count and type.",
            description = "Get list phone by count and type in the backend"
    )
    @GetMapping("/phone/get-by")
    public ResponseEntity<List<PhoneTabDTO>> getPhoneByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return new ResponseEntity<>(getFacade().getByCountAndTypeAndCmID(count, type, FixedValue.CMID_PHONE, model), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get list tablet by count and type.",
            description = "Get list tablet by count and type in the backend"
    )
    @GetMapping("/tablet/get-by")
    public ResponseEntity<List<PhoneTabDTO>> getTabletByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return new ResponseEntity<>(getFacade().getByCountAndTypeAndCmID(count, type, FixedValue.CMID_TABLET, model), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get list phone by attribute in request body.",
            description = "Get list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/phone")
    @ResponseBody
    public ResponseEntity<List<PhoneTabDTO>> homePutPhoneTab(@RequestBody String data, Model model) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            final List<PhoneTabDTO> phoneTabDTOS = getFacade().filterPhoneTab(json, 1);
            int count = ((Long) json.get("count")).intValue();
            List<PhoneTabDTO> phoneResp = new ArrayList<>();
            if(phoneTabDTOS.size() > count) {
                model.addAttribute("loadmore", true);
                phoneResp = phoneTabDTOS.subList(0, count);
            } else {
                phoneResp = phoneTabDTOS;
            }

            return new ResponseEntity<>(phoneResp, HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get size list phone by attribute in request body.",
            description = "Get size list phone by attribute in request body in the backend"
    )
    @PutMapping(value = "/phone/size")
    @ResponseBody
    public ResponseEntity<Integer> sizePhone(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> phoneTabDTOS = getFacade().filterPhoneTab(json, FixedValue.CMID_PHONE);

            return new ResponseEntity<>(phoneTabDTOS.size(), HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get list tablet by attribute in request body.",
            description = "Get list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/tablet")
    @ResponseBody
    public ResponseEntity<List<PhoneTabDTO>> homePutTablet(HttpServletRequest request, @RequestBody String data, Model model) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> tabletDTOS = getFacade().filterPhoneTab(json, FixedValue.CMID_TABLET);
            int count = ((Long) json.get("count")).intValue();
            List<PhoneTabDTO> tabletResp = new ArrayList<>();
            if(tabletDTOS.size() > count) {
                model.addAttribute("loadmore", true);
                tabletResp = tabletDTOS.subList(0, count);
            } else {
                tabletResp = tabletDTOS;
            }

            return new ResponseEntity<>(tabletResp, HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Get size list tablet by attribute in request body.",
            description = "Get size list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/tablet/size")
    @ResponseBody
    public ResponseEntity<Integer> sizeTablet(@RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> tabletDTOS = getFacade().filterPhoneTab(json, FixedValue.CMID_TABLET);

            return new ResponseEntity<>(tabletDTOS.size(), HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }
}
