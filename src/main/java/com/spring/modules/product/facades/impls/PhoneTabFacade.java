package com.spring.modules.product.facades.impls;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.core.response.EResponse;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.services.PhoneTabService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Component
public class PhoneTabFacade extends ATypeManagementFacade<PhoneTabDTO, PhoneTabModel, PhoneTabService> {

    @Autowired
    public PhoneTabFacade(final PhoneTabService service,
                         final ADTO2ModelConverter<PhoneTabDTO, PhoneTabModel> dto2model,
                         final AModel2DTOConverter<PhoneTabModel, PhoneTabDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public List<PhoneTabDTO> getByCmID(final int cmID) {
        try {
            if(CollectionUtils.isEmpty(getService().getByCmID(cmID))) {
                return Collections.emptyList();
            } else {
                return getModel2dto().convertAll(getService().getByCmID(cmID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<PhoneTabDTO> getByCID(final int cID) {
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

    public List<PhoneTabDTO> getByCountAndType(int count, String type, Model model) {
        List<PhoneTabModel> phoneTabsInDB = getService().getAll();
        List<PhoneTabModel> phoneTabs = new ArrayList<>();
        for(PhoneTabModel p:phoneTabsInDB) {
            if(p.getCategory().getProductLine().getId() == 1) {
                phoneTabs.add(p);
            }
        }

        if(type.equals("desc")) {
            Collections.sort(phoneTabs, new Comparator<PhoneTabModel>() {
                @Override
                public int compare(PhoneTabModel p1, PhoneTabModel p2) {
                    return Long.compare(p2.getPrice(), p1.getPrice());
                }
            });
        } else {
            Collections.sort(phoneTabs, new Comparator<PhoneTabModel>() {
                @Override
                public int compare(PhoneTabModel p1, PhoneTabModel p2) {
                    return Long.compare(p1.getPrice(), p2.getPrice());
                }
            });
        }

        phoneTabs = phoneTabs.subList(0, count);

        if(phoneTabs.size() > EResponse.COUNT_PRODUCT_LOAD) {
            return getModel2dto().convertAll(phoneTabs.subList(0, EResponse.COUNT_PRODUCT_LOAD));
        } else {
            return getModel2dto().convertAll(phoneTabs);
        }
    }

    public List<PhoneTabDTO> filterPhoneTab(JSONObject json, int cmID) {
        List<PhoneTabDTO> list = new ArrayList<>();
        JSONArray ids = (JSONArray) json.get("id");
        int top = ((Long) json.get("top")).intValue();
        int bot = ((Long) json.get("bot")).intValue();
        JSONObject sort = (JSONObject) json.get("sort");
        String type = sort.get("type").toString();
        String value = sort.get("value").toString();

        if (Objects.nonNull(ids)) {
            if(ids.size() == 0) {
                List<PhoneTabDTO> list2 = getByCmID(cmID);
                list.addAll(list2);
            } else {
                for (Object o : ids) {
                    List<PhoneTabDTO> list2 = getByCID((int) o);
                    list.addAll(list2);
                }
            }
        }

        List<PhoneTabDTO> list2 = new ArrayList<>();
        if(top == 0 || (top == 0 && bot == 0)) {
            list2 = list;
        } else {
            for(PhoneTabDTO p : list) {
                if(p.getPrice()/22 >= bot && p.getPrice()/22 <= top) {
                    list2.add(p);
                }
            }
        }

        return sortPhoneTabByType(type, value, list2);
    }

    public List<PhoneTabDTO> sortPhoneTabByType(String type, String value, List<PhoneTabDTO> oldList) {
        if(type.equals("default")) {

        } else if(type.equals("price")) {
            if(value.equals("top")) {
                Collections.sort(oldList, new Comparator<PhoneTabDTO>() {
                    @Override
                    public int compare(PhoneTabDTO p1, PhoneTabDTO p2) {
                        return Long.compare(p2.getPrice(), p1.getPrice());
                    }
                });
            } else {
                Collections.sort(oldList, new Comparator<PhoneTabDTO>() {
                    @Override
                    public int compare(PhoneTabDTO p1, PhoneTabDTO p2) {
                        return Long.compare(p1.getPrice(), p2.getPrice());
                    }
                });
            }
        } else {
            if(value.equals("az")) {
                Collections.sort(oldList, new Comparator<PhoneTabDTO>() {
                    @Override
                    public int compare(PhoneTabDTO p1, PhoneTabDTO p2) {
                        return p1.getCode().compareTo(p2.getCode());
                    }
                });
            } else {
                Collections.sort(oldList, new Comparator<PhoneTabDTO>() {
                    @Override
                    public int compare(PhoneTabDTO p1, PhoneTabDTO p2) {
                        return p2.getCode().compareTo(p1.getCode());
                    }
                });
            }
        }

        return oldList;
    }
}
