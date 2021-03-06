package com.spring.modules.checkout.controllers.rest;

import com.spring.core.constain.FixedValue;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.ERole;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;
import com.spring.modules.checkout.controllers.dtos.OrderProductDTO;
import com.spring.modules.checkout.facades.imps.OrderFacade;
import com.spring.modules.checkout.facades.imps.OrderProductFacade;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.facades.impls.LaptopFacade;
import com.spring.modules.product.facades.impls.PhoneTabFacade;
import org.apache.logging.log4j.util.Strings;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

@RestController
public class ManagementRestController {

    private final OrderFacade orderFacade;
    private final OrderProductFacade orderProductFacade;
    private final LaptopFacade laptopFacade;
    private final PhoneTabFacade phoneTabFacade;
    private final CustomerFacade customerFacade;

    @Autowired
    public ManagementRestController(final OrderFacade orderFacade, final OrderProductFacade orderProductFacade, final LaptopFacade laptopFacade, final PhoneTabFacade phoneTabFacade, final CustomerFacade customerFacade) {
        this.orderFacade = orderFacade;
        this.orderProductFacade = orderProductFacade;
        this.laptopFacade = laptopFacade;
        this.phoneTabFacade = phoneTabFacade;
        this.customerFacade = customerFacade;
    }


    @GetMapping(value = "/manage/chart", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Integer> apiManageChartOne(HttpServletRequest request, Model model, @RequestParam String number) {
        List<Integer> integers = new ArrayList<>();
        try {
            if(number.equals("one")) {
                List<OrderDTO> orderDTOS = getOrderFacade().getAll();

                for(int i=1; i<=12; i++) {
                    String month = String.format("%02d", i) + "-2022";
                    int count = 0;
                    for(OrderDTO o : orderDTOS) {
                        if(o.getCreated().contains(month)) {
                            count++;
                        }
                    }
                    integers.add(count);
                }

                return integers;
            } else {
                List<OrderProductDTO> orderProductDTOS = getOrderProductFacade().getAll();
                for(int i=1; i<=3; i++) {
                    int count = 0;
                    for(OrderProductDTO op : orderProductDTOS) {
                        if(op.getCategoryDTO().getProductLineDTO().getId() == i) {
                            count += op.getQuantity();
                        }
                    }
                    integers.add(count);
                }
                return integers;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/manage/table/one", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String apiManageTabletOne() {
        try {
            JSONArray jsonArray = new JSONArray();
            List<OrderProductDTO> orderProductDTOS = getOrderProductFacade().getAll();
            for(int i=1; i<=3; i++) {
                JSONObject jsonObject = new JSONObject();
                String device = "";
                int count = 0, total = 0;
                for(OrderProductDTO op : orderProductDTOS) {
                    if(op.getCategoryDTO().getProductLineDTO().getId() == i) {
                        count += op.getQuantity();
                        device = op.getCategoryDTO().getProductLineDTO().getLine();
                        total += op.getTotal();
                    }
                }
                jsonObject.put("device", device);
                jsonObject.put("quantity", count);
                jsonObject.put("total", total);
                jsonObject.put("avg", total/count);
                jsonArray.add(jsonObject);
            }
            return jsonArray.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/manage/table/two", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<OrderDTO> apiManageTabletTwo() {
        try {
            return getOrderFacade().getOrderLimit(FixedValue.COUNT_TOP_CUSTOMER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    @SuppressWarnings("unchecked")
    @GetMapping(value = "/manage/table/three", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String apiManageTabletThree() {
        try {
            Map<String, Integer> map = getOrderProductFacade().getOrderProductLimit(FixedValue.COUNT_TOP_CUSTOMER);
            JSONArray jsonArray = new JSONArray();

            Set<Entry<String, Integer>> set = map.entrySet();
            List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            list = list.subList(0, FixedValue.COUNT_TOP_CUSTOMER);

            for(Entry<String, Integer> entry : list) {
                String code = entry.getKey();
                ProductDTO product = null;
                List<LaptopDTO> laptopDTOS = getLaptopFacade().getAll();
                for(int i=0; i<laptopDTOS.size(); i++) {
                    if(code.equals(laptopDTOS.get(i).getCode())) {
                        product = (ProductDTO) laptopDTOS.get(i);
                    }
                }

                List<PhoneTabDTO> phoneTabDTOS = getPhoneTabFacade().getAll();
                for(int i=0; i<phoneTabDTOS.size(); i++) {
                    if(code.equals(phoneTabDTOS.get(i).getCode())) {
                        product = (ProductDTO) phoneTabDTOS.get(i);
                    }
                }
                int quantity = entry.getValue();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", code);
                jsonObject.put("quantity", quantity);
                jsonObject.put("name", product.getName());
                jsonObject.put("image", product.getImage());
                jsonObject.put("price", product.getPrice());
                jsonArray.add(jsonObject);
            }

            return jsonArray.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Strings.EMPTY;
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/manage/product", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String apiManageProduct(@RequestParam int end, @RequestParam int start, @RequestParam String search) {
        try {
            List<ProductDTO> productDTOS = new ArrayList<>();
            productDTOS.addAll((List<ProductDTO>) (List<?>) getLaptopFacade().getAll());
            productDTOS.addAll((List<ProductDTO>) (List<?>) getPhoneTabFacade().getAll());
/*        for(int i=0; i<laptopDTOS.size(); i++) {
            ProductDTO productDTO = (ProductDTO) laptopDTOS.get(i);
            productDTOS.add(productDTO);
        }*/

            if(!search.equals("")) {
                List<ProductDTO> productDTOStwo = new ArrayList<>();
                for(ProductDTO product : productDTOS) {
                    if(product.getName().toLowerCase().contains(search.toLowerCase())) {
                        productDTOStwo.add(product);
                    }
                }
                productDTOS = productDTOStwo;
            }

            int countPage = productDTOS.size()% FixedValue.SIZE_TABLE_MANAGE == 0 ?
                    productDTOS.size()/ FixedValue.SIZE_TABLE_MANAGE : productDTOS.size()/ FixedValue.SIZE_TABLE_MANAGE + 1;
            List<ProductDTO> productDTOStwo = new ArrayList<>();
            end = (end >= productDTOS.size()) ? productDTOS.size() - 1 : end;
            for(int i=start; i<=end; i++) {
                productDTOStwo.add(productDTOS.get(i));
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("countPage", countPage);
            JSONArray jsonArray = new JSONArray();
            for(int i=0; i<productDTOStwo.size(); i++) {
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("code", productDTOStwo.get(i).getCode());
                jsonObject2.put("image", productDTOStwo.get(i).getImage());
                jsonObject2.put("name", productDTOStwo.get(i).getName());
                jsonObject2.put("line", productDTOStwo.get(i).getCategoryDTO().getLine());
                jsonObject2.put("lineCatemenu", productDTOStwo.get(i).getCategoryDTO().getProductLineDTO().getLine().toLowerCase());
                jsonObject2.put("quantity", productDTOStwo.get(i).getQuantityStock());
                jsonObject2.put("price", productDTOStwo.get(i).getPrice());
                jsonArray.add(jsonObject2);
            }
            jsonObject.put("data", jsonArray);

            return jsonObject.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Strings.EMPTY;
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/manage/orders", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String apiManageOrder(@RequestParam int end, @RequestParam int start) {
        try {
            List<OrderDTO> orderDTOS = getOrderFacade().getAll();
            int countPage = orderDTOS.size()% FixedValue.SIZE_TABLE_MANAGE == 0 ?
                    orderDTOS.size()/ FixedValue.SIZE_TABLE_MANAGE : orderDTOS.size()/ FixedValue.SIZE_TABLE_MANAGE + 1;
            List<OrderDTO> orderDTOS2 = new ArrayList<>();
            end = (end >= orderDTOS.size()) ? orderDTOS.size() - 1 : end;
            orderDTOS2 = orderDTOS.subList(start, end+1);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("countPage", countPage);
            JSONArray jsonArray = new JSONArray();
            for(int i=0; i<orderDTOS2.size(); i++) {
                JSONObject jsonObject2 = new JSONObject();
                jsonObject2.put("ordinal", orderDTOS2.get(i).getId());
                jsonObject2.put("name", orderDTOS2.get(i).getName());
                jsonObject2.put("email", orderDTOS2.get(i).getEmail());
                jsonObject2.put("quantity", orderDTOS2.get(i).getQuantity());
                jsonObject2.put("created", orderDTOS2.get(i).getCreated());
                jsonObject2.put("price", orderDTOS2.get(i).getTotal());
                jsonArray.add(jsonObject2);
            }

            jsonObject.put("data", jsonArray);
            return jsonObject.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Strings.EMPTY;
    }


    @GetMapping(value = "/manage/orders/view", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<OrderProductDTO> apiManageOrderPut(@RequestParam int id) {
        try {
            List<OrderProductDTO> orderProductDTOSByOrderID = getOrderProductFacade().getByOrderID(id);
            for(OrderProductDTO orderProduct : orderProductDTOSByOrderID) {
                String name = getOrderProductFacade().convertCodeToString(orderProduct.getCode(), laptopFacade, phoneTabFacade);
                orderProduct.setCode(name);
            }

            return orderProductDTOSByOrderID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/manage/account", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String apiManageAccount(@RequestParam int end, @RequestParam int start) {
        List<CustomerDTO> customerDTOS = getCustomerFacade().getAll();
        List<CustomerDTO> customerDTOSByRole = new ArrayList<>();
        for(CustomerDTO customerDTO : customerDTOS) {
            if(!customerDTO.getRole().equals(ERole.ADMIN.toString())) {
                customerDTOSByRole.add(customerDTO);
            }
        }

        int countPage = customerDTOSByRole.size()% FixedValue.SIZE_TABLE_MANAGE == 0 ?
                customerDTOSByRole.size()/ FixedValue.SIZE_TABLE_MANAGE : customerDTOSByRole.size()/ FixedValue.SIZE_TABLE_MANAGE + 1;

        List<CustomerDTO> customerDTOSByEndAndStart = new ArrayList<>();
        end = (end >= customerDTOS.size()) ? customerDTOS.size() - 1 : end;
        for(int i=start; i<=end; i++) {
            customerDTOSByEndAndStart.add(customerDTOS.get(i));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("countPage", countPage);
        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<customerDTOSByEndAndStart.size(); i++) {
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("ordinal", customerDTOSByEndAndStart.get(i).getId());
            jsonObject2.put("username", customerDTOSByEndAndStart.get(i).getUsername());
            jsonObject2.put("name", customerDTOSByEndAndStart.get(i).getName());
            jsonObject2.put("email", customerDTOSByEndAndStart.get(i).getEmail());
            jsonObject2.put("password", customerDTOSByEndAndStart.get(i).getPassword());
            jsonObject2.put("created", customerDTOSByEndAndStart.get(i).getCreatedDay());
            jsonObject2.put("address", customerDTOSByEndAndStart.get(i).getAddress());
            jsonObject2.put("phone", customerDTOSByEndAndStart.get(i).getPhone());
            jsonObject2.put("role", customerDTOSByEndAndStart.get(i).getRole());
            jsonArray.add(jsonObject2);
        }

        jsonObject.put("data", jsonArray);
        return jsonObject.toJSONString();
    }


    @GetMapping(value = "/manage/notification")
    @ResponseBody
    public List<OrderDTO> apiManageNotification(HttpServletRequest request) {
        try {
            List<OrderDTO> newOrders = new ArrayList<>();
            List<OrderDTO> orderDTOs = getOrderFacade().getAll();
            for(OrderDTO o:orderDTOs) {
                if(!o.isStatus()) {
                    newOrders.add(o);
                }
            }

            for(OrderDTO o:newOrders) {
                getOrderFacade().updateStatusById(o.getId());
            }

            return newOrders;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @PutMapping(value = "/manage/cart")
    @ResponseBody
    public List<ProductDTO> apiCart(HttpServletRequest request, Model model, @RequestBody String data) {
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
                        ProductDTO productDTO = (ProductDTO) phoneTabDTOS.get(i);
                        productDTOS.add(productDTO);
                    }
                }
            }

            return productDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @GetMapping("/image/upload/{photo}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        try {
            Path path = Paths.get(FixedValue.FILE_PATH_UPLOAD_IMAGE + "/uploads", photo);
            byte[] buffer = Files.readAllBytes(path);
            ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length).contentType(MediaType.parseMediaType("image/png"))
                    .body(byteArrayResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public OrderProductFacade getOrderProductFacade() {
        return orderProductFacade;
    }

    public LaptopFacade getLaptopFacade() {
        return laptopFacade;
    }

    public PhoneTabFacade getPhoneTabFacade() {
        return phoneTabFacade;
    }

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }
}
