package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.core.response.EResponse;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.controllers.dto.ProductDTO;
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
public class PhoneTabController extends ATypeManagementRestController<PhoneTabDTO, PhoneTabModel, PhoneTabService, PhoneTabFacade> {

    private final ProductFacade productFacade;
    private final CategoryFacade categoryFacade;

    @Autowired
    protected PhoneTabController(final PhoneTabFacade facade, final ProductFacade productFacade, final CategoryFacade categoryFacade) {
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
            if(categoryDTO.getProductLineDTO().getId() != EResponse.CMID_LAPTOP) {
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
            if(categoryDTO.getProductLineDTO().getId() != EResponse.CMID_LAPTOP) {
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
                phoneTabDTO.setPrice((long) price *EResponse.DOLA);
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
    public List<PhoneTabDTO> getPhoneByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return getFacade().getByCountAndTypeAndCmID(count, type, EResponse.CMID_PHONE, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Operation(
            summary = "Get list tablet by count and type.",
            description = "Get list tablet by count and type in the backend"
    )
    @GetMapping("/tablet/get-by")
    public List<PhoneTabDTO> getTabletByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return getFacade().getByCountAndTypeAndCmID(count, type, EResponse.CMID_TABLET, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Operation(
            summary = "Get list phone by attribute in request body.",
            description = "Get list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/phone")
    @ResponseBody
    public List<PhoneTabDTO> homePutPhoneTab(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, 1);
            int count = ((Long) json.get("count")).intValue();
            if(list3.size() > count) {
                List<PhoneTabDTO> list4 = new ArrayList<>();
                for(int i=0; i<count; i++) {
                    list4.add(list3.get(i));
                }
                return list4;
            } else {
                return list3;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Operation(
            summary = "Get size list phone by attribute in request body.",
            description = "Get size list phone by attribute in request body in the backend"
    )
    @PutMapping(value = "/phone/size")
    @ResponseBody
    public int sizePhone(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, EResponse.CMID_PHONE);

            return list3.size();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Operation(
            summary = "Get list tablet by attribute in request body.",
            description = "Get list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/tablet")
    @ResponseBody
    public List<PhoneTabDTO> homePutTablet(HttpServletRequest request, @RequestBody String data, Model model) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, EResponse.CMID_TABLET);
            int count = ((Long) json.get("count")).intValue();
            if(list3.size() > count) {
                model.addAttribute("loadmore", true);
                List<PhoneTabDTO> list4 = new ArrayList<>();
                for(int i=0; i<count; i++) {
                    list4.add(list3.get(i));
                }
                return list4;
            } else {
                return list3;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Operation(
            summary = "Get size list tablet by attribute in request body.",
            description = "Get size list tablet by attribute in request body in the backend"
    )
    @PutMapping(value = "/tablet/size")
    @ResponseBody
    public int sizeTablet(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, EResponse.CMID_TABLET);

            return list3.size();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }
}
