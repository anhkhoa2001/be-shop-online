package com.spring.core.facedes.converter.model2dto;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.model.AItemModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class AModel2DTOConverter<SOURCE extends AItemModel, TARGET extends AItemDTO> {
    private TARGET target;

    public TARGET convert(SOURCE source) {
        if(!StringUtils.isBlank(source.getCode())) {
            target.setCode(source.getCode());
        }
        target.setId(source.getId());

        return target;
    }

    public List<TARGET> convertAll(List<SOURCE> sourceList) {
        List<TARGET> targetList = new ArrayList<>(Collections.emptyList());
        try {
            if (!CollectionUtils.isEmpty(sourceList)) {
                sourceList.forEach(e -> {
                    targetList.add(this.convert(e));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return targetList;
    }

    public Set<TARGET> convertList2Set(List<SOURCE> sourceList) {
        List<TARGET> targetList = this.convertAll(sourceList);
        Set<TARGET> targetSet = new HashSet(targetList);
        return targetSet;
    }

    public List<TARGET> convertSet2List(Set<SOURCE> sourceSet) {
        List<SOURCE> sourceList = new ArrayList(sourceSet);
        List<TARGET> targetList = this.convertAll(sourceList);
        return targetList;
    }

}
