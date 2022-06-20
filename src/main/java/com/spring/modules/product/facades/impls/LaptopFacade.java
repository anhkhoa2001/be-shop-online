package com.spring.modules.product.facades.impls;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.core.constain.FixedValue;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.services.LaptopService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class LaptopFacade extends ATypeManagementFacade<LaptopDTO, LaptopModel, LaptopService> {

    @Autowired
    public LaptopFacade(final LaptopService service,
                        final ADTO2ModelConverter<LaptopDTO, LaptopModel> dto2model,
                        final AModel2DTOConverter<LaptopModel, LaptopDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public List<LaptopDTO> getByCountAndType(int count, String type, Model model) {
        List<LaptopModel> laptops = getService().getAll();

        if(count > 0) {
            if(type.equals("desc")) {
                Collections.sort(laptops, new Comparator<LaptopModel>() {
                    @Override
                    public int compare(LaptopModel p1, LaptopModel p2) {
                        return Long.compare(p2.getPrice(), p1.getPrice());
                    }
                });
            } else {
                Collections.sort(laptops, new Comparator<LaptopModel>() {
                    @Override
                    public int compare(LaptopModel p1, LaptopModel p2) {
                        return Long.compare(p1.getPrice(), p2.getPrice());
                    }
                });
            }

            return getModel2dto().convertAll(laptops.subList(0, count));
        } else {
            if(laptops.size() > FixedValue.COUNT_PRODUCT_LOAD) {
                model.addAttribute("loadmore", true);
                return getModel2dto().convertAll(laptops.subList(0, FixedValue.COUNT_PRODUCT_LOAD));
            } else {
                return getModel2dto().convertAll(laptops);
            }
        }
    }

    public List<LaptopDTO> getByCID(final long cID) {
        try {
            if(CollectionUtils.isEmpty(getService().getByCID(cID))) {
                return Collections.emptyList();
            } else {
                return getModel2dto().convertAll(getService().getByCID(cID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<LaptopDTO> filterLaptop(JSONObject json) {
        List<LaptopDTO> list = new ArrayList<>();
        JSONArray ids = (JSONArray) json.get("id");
        int top = ((Long) json.get("top")).intValue();
        int bot = ((Long) json.get("bot")).intValue();
        JSONObject sort = (JSONObject) json.get("sort");
        String type = sort.get("type").toString();
        String value = sort.get("value").toString();
        if (ids != null) {
            if(ids.size() == 0) {
                list.addAll(getAll());
            } else {
                for (Object o : ids) {;
                    list.addAll(getByCID((long) o));
                }
            }
        } else {
            System.out.println("error");
        }

        List<LaptopDTO> list2 = new ArrayList<>();
        if(top == 0 || (top == 0 && bot == 0)) {
            list2 = list;
        } else {
            for(LaptopDTO p : list) {
                if(p.getPrice() >= bot && p.getPrice() <= top) {
                    list2.add(p);
                }
            }
        }
        return sortLaptopByType(type, value, list2);
    }

    public List<LaptopDTO> sortLaptopByType(String type, String value, List<LaptopDTO> oldList) {
        if(type.equals("default")) {

        } else if(type.equals("price")) {
            if(value.equals("top")) {
                Collections.sort(oldList, new Comparator<LaptopDTO>() {
                    @Override
                    public int compare(LaptopDTO p1, LaptopDTO p2) {
                        return Long.compare(p2.getPrice(), p1.getPrice());
                    }
                });
            } else {
                Collections.sort(oldList, new Comparator<LaptopDTO>() {
                    @Override
                    public int compare(LaptopDTO p1, LaptopDTO p2) {
                        return Long.compare(p1.getPrice(), p2.getPrice());
                    }
                });
            }
        } else {
            if(value.equals("az")) {
                Collections.sort(oldList, new Comparator<LaptopDTO>() {
                    @Override
                    public int compare(LaptopDTO p1, LaptopDTO p2) {
                        return p1.getCode().compareTo(p2.getCode());
                    }
                });
            } else {
                Collections.sort(oldList, new Comparator<LaptopDTO>() {
                    @Override
                    public int compare(LaptopDTO p1, LaptopDTO p2) {
                        return p2.getCode().compareTo(p1.getCode());
                    }
                });
            }
        }
        return oldList;
    }
}
