package com.spring.modules.checkout.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.core.response.EResponse;
import com.spring.modules.authentication.config.AuthenticationSystem;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.facades.imps.CategoryFacade;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.category.service.CategoryService;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.facades.imps.OrderFacade;
import com.spring.modules.checkout.facades.imps.OrderProductFacade;
import com.spring.modules.checkout.models.OrderModel;
import com.spring.modules.checkout.models.OrderProductModel;
import com.spring.modules.checkout.services.OrderProductService;
import com.spring.modules.checkout.services.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrderController extends ATypeManagementRestController<OrderDTO, OrderModel, OrderService, OrderFacade> {

    private final CustomerFacade customerFacade;
    private final OrderProductFacade orderProductFacade;
    private final CategoryFacade categoryFacade;
    private final CategoryService categoryService;
    private final OrderProductService orderProductService;

    @Autowired
    protected OrderController(final OrderFacade facade, final CustomerFacade customerFacade, final OrderProductFacade orderProductFacade, final CategoryFacade categoryFacade, final CategoryService categoryService, final OrderProductService orderProductService) {
        super(facade);
        this.customerFacade = customerFacade;
        this.orderProductFacade = orderProductFacade;
        this.categoryFacade = categoryFacade;
        this.categoryService = categoryService;
        this.orderProductService = orderProductService;
    }

    @GetMapping(value = "/add-to-cart")
    @ResponseBody
    public int home(Model model, @RequestParam String code) {
        model.addAttribute("isLog", AuthenticationSystem.isLogged());
        String username = AuthenticationSystem.getUsernameCurrent();

        CustomerDTO customerDTO = getCustomerFacade().getByUsername(username);
        if(Objects.nonNull(customerDTO)) {
            model.addAttribute("dto", customerDTO);
        }

        return AuthenticationSystem.isLogged() ? EResponse.SUCCESS : EResponse.FAILED;
    }

    @PostMapping(value = "/check-out")
    @ResponseBody
    public ResponseEntity<OrderDTO> checkoutSubmit(@RequestBody String data) {
        JSONParser parser = new JSONParser();
        long id = 0;
        try {
            List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
            JSONObject json = (JSONObject) parser.parse(data);
            JSONObject one = (JSONObject) json.get("step_one");
            JSONArray two = (JSONArray) json.get("step_two");
            JSONObject three = (JSONObject) json.get("step_three");

            String firstname = one.get("firstname").toString();
            String email = one.get("email").toString();
            String lastname = one.get("lastname").toString();
            String phone = one.get("phone").toString();
            String residence = one.get("residence").toString();
            String district = one.get("district").toString();
            String city = one.get("city").toString();

            OrderDTO orderDTOCreate = new OrderDTO(firstname + " " + lastname, email, phone, residence + " " + district + " " + city,
                    0, EResponse.day.format(EResponse.localDate), 0);

            int totalQuantity = ((Long) three.get("quantity")).intValue();
            int totalPrice = ((Long) three.get("total")).intValue();
            orderDTOCreate.setQuantity(totalQuantity);
            orderDTOCreate.setTotal(totalPrice);
            orderDTOCreate.setStatus(false);
            if(StringUtils.isBlank(orderDTOCreate.getCode())) {
                String code = getFacade().generatorCode(OrderModel.MODEL_NAME);
                orderDTOCreate.setCode(code);
            }
            OrderDTO orderDTOCreated = getFacade().create(orderDTOCreate);
            id = orderDTOCreated.getId();
            for(int i=0; i<two.size(); i++) {
                JSONObject jsonObject = (JSONObject) two.get(i);
                String code = jsonObject.get("code").toString();
                int quantity = ((Long) jsonObject.get("quantity")).intValue();
                int total = ((Long) jsonObject.get("totalPrice")).intValue();
                int cid = Integer.parseInt(jsonObject.get("cid").toString());
                OrderProductModel orderProduct = new OrderProductModel(code, quantity, total);
                CategoryModel category = getCategoryFacade().getDto2model().convert(getCategoryFacade().getById((long) cid));
                orderProduct.setCategory(category);
                orderProduct.setOrders(getFacade().getDto2model().convert(orderDTOCreated));
                orderProductService.create(orderProduct);
            }

            return ResponseEntity.ok(orderDTOCreated);
        } catch (Exception e) {
            e.printStackTrace();
            getFacade().deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public OrderProductFacade getOrderProductFacade() {
        return orderProductFacade;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public OrderProductService getOrderProductService() {
        return orderProductService;
    }
}
