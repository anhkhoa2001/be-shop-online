package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import com.spring.modules.product.facades.impls.ProductFacade;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.services.ProductService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController extends ATypeManagementRestController<ProductDTO, ProductModel, ProductService, ProductFacade> {

    private final LaptopFacade laptopFacade;
    private final PhoneTabFacade phoneTabFacade;

    @Autowired
    protected ProductRestController(final ProductFacade facade, final LaptopFacade laptopFacade, final PhoneTabFacade phoneTabFacade) {
        super(facade);
        this.laptopFacade = laptopFacade;
        this.phoneTabFacade = phoneTabFacade;
    }

    @PutMapping(value = "/view-cart")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> homeCart(@RequestBody String data) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray json = (JSONArray) parser.parse(data);
            for(int i=0; i<json.size(); i++) {
                JSONObject jsonObject = (JSONObject) json.get(i);
                codes.add(jsonObject.get("key").toString());
            }
            List<LaptopDTO> laptopDTOS = getLaptopFacade().getAll();
            for(int j=0; j<codes.size(); j++) {
                for(int i=0; i<laptopDTOS.size(); i++) {
                    if(codes.get(j).equals(laptopDTOS.get(i).getCode())) {
                        productDTOS.add((ProductDTO) laptopDTOS.get(i));
                    }
                }
            }

            List<PhoneTabDTO> phoneTabDTOS = getPhoneTabFacade().getAll();
            for(int j=0; j<codes.size(); j++) {
                for(int i=0; i<phoneTabDTOS.size(); i++) {
                    if(codes.get(j).equals(phoneTabDTOS.get(i).getCode())) {
                        productDTOS.add((ProductDTO) phoneTabDTOS.get(i));
                    }
                }
            }

            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ProductDTO> deleteByCode(@RequestParam final String code) {
        try {
            getFacade().deleteByCode(code);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public LaptopFacade getLaptopFacade() {
        return laptopFacade;
    }

    public PhoneTabFacade getPhoneTabFacade() {
        return phoneTabFacade;
    }
}
