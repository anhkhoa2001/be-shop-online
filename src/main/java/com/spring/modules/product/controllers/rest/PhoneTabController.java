package com.spring.modules.product.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.core.response.EResponse;
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


}
