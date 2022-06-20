package com.spring.modules.authentication.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.ERole;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.authentication.models.CustomerModel;
import com.spring.modules.authentication.services.CustomerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerRestController extends ATypeManagementRestController<CustomerDTO, CustomerModel, CustomerService, CustomerFacade> {

    protected CustomerRestController(final CustomerFacade facade) {
        super(facade);
    }

    @Override
    public ResponseEntity<CustomerDTO> create(@Parameter(in = ParameterIn.DEFAULT,required = true) @RequestBody CustomerDTO entity) {
        if(Objects.nonNull(entity)) {
            if(StringUtils.isBlank(entity.getCode())) {
                entity.setCode(getFacade().generatorCode(CustomerModel.MODEL_NAME));
            }

            entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
            entity.setCreatedDay(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
            entity.setEnabled(true);
            entity.setRole(ERole.CUSTOMER.toString());

            CustomerDTO dtoCreated = getFacade().create(entity);

            return new ResponseEntity<>(dtoCreated, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-logged")
    public ResponseEntity<CustomerDTO> getLogged(Model model) {
        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();

        if(Objects.nonNull(getFacade().getByUsername(username))) {
            return ResponseEntity.ok(getFacade().getByUsername(username));
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<CustomerDTO> apiManageContactDelete(@RequestParam final String username) {
        try {
            getFacade().deleteByUsername(username);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

