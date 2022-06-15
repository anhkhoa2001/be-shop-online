package com.spring.core.facedes.converter.dto2model;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.model.AItemModel;
import com.spring.core.repository.ITypeManagementJpaRepository;
import com.spring.core.service.ITypeManagementService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public abstract class ADTO2ModelConverter<SOURCE extends AItemDTO, TARGET extends AItemModel> {

    private ITypeManagementService<TARGET, ITypeManagementJpaRepository<TARGET>> service;

    public TARGET convert(SOURCE source) {
        TARGET target = null;
        try {
            if(Objects.nonNull(source) && !StringUtils.isBlank(source.getCode())) {
                target = this.getService().findByCode(source.getCode());
            }
            target.setId(source.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public ITypeManagementService<TARGET, ITypeManagementJpaRepository<TARGET>> getService() {
        return service;
    }
}
