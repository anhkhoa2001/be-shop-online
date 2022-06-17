package com.spring.core.facades.converter.dto2model;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.model.AItemModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class ADTO2ModelConverter<SOURCE extends AItemDTO, TARGET extends AItemModel> {

    TARGET target;

    public ADTO2ModelConverter(final TARGET target) {
        this.target = target;
    }

    public TARGET convert(SOURCE source) {
        TARGET target = this.target;
        try {
            if(!StringUtils.isBlank(source.getCode())) {
                target.setCode(source.getCode());
            }
            target.setId(source.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }

    public List<TARGET> convertAll(List<SOURCE> sourceList) {
        try {
            if (!CollectionUtils.isEmpty(sourceList)) {
                List<TARGET> targetList = (List<TARGET>)sourceList.parallelStream().map(this::convert).collect(Collectors.toList());

                return targetList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
