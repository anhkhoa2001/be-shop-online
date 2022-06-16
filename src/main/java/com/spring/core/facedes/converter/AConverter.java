package com.spring.core.facedes.converter;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AConverter<SOURCE, TARGET> {

    private TARGET target;

    public AConverter(final TARGET target) {
        this.target = target;
    }

    public TARGET getTarget() {
        return target;
    }

    public void setTarget(final TARGET target) {
        this.target = target;
    }

    public TARGET convert(SOURCE source) {
        synchronized (source) {
            System.out.println(source.toString());
            return null;
        }
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
