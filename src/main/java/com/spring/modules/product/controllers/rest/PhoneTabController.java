package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.services.PhoneTabService;
import io.swagger.v3.oas.annotations.Operation;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/phone-tab")
public class PhoneTabController extends ATypeManagementRestController<PhoneTabDTO, PhoneTabModel, PhoneTabService, PhoneTabFacade> {

    protected PhoneTabController(final PhoneTabFacade facade) {
        super(facade);
    }

    @Operation(
            summary = "Get list phonetab by count and type.",
            description = "Get list phonetab by count and type in the backend"
    )
    @GetMapping("/get-by")
    public List<PhoneTabDTO> getByCountAndType(@RequestParam int count, @RequestParam String type, Model model) {
        try {
            return getFacade().getByCountAndType(count, type, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

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

    @PutMapping(value = "/phone/size")
    @ResponseBody
    public int sizePhone(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, 1);

            return list3.size();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @PutMapping(value = "/tablet")
    @ResponseBody
    public List<PhoneTabDTO> homePutTablet(HttpServletRequest request, @RequestBody String data, Model model) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, 2);
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

    @RequestMapping(value = "/tablet/size", method = RequestMethod.PUT)
    @ResponseBody
    public int sizeTablet(HttpServletRequest request, @RequestBody String data) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(data);
            List<PhoneTabDTO> list3 = getFacade().filterPhoneTab(json, 2);
            return list3.size();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
