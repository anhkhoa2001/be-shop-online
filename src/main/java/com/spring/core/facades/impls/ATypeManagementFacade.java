package com.spring.core.facades.impls;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.model.AItemModel;
import com.spring.core.response.EResponse;
import com.spring.core.service.ATypeManagementService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class ATypeManagementFacade<DTO extends AItemDTO, MODEL extends AItemModel,
        MS extends ATypeManagementService<MODEL>> {

    private static final int LENGTH_CODE = 4;

    private MS service;

    private ADTO2ModelConverter<DTO, MODEL> dto2model;

    private AModel2DTOConverter<MODEL, DTO> model2dto;

    public ATypeManagementFacade(final MS service,
                                 final ADTO2ModelConverter<DTO, MODEL> dto2model,
                                 final AModel2DTOConverter<MODEL, DTO> model2dto) {
        this.service = service;
        this.dto2model = dto2model;
        this.model2dto = model2dto;
    }

    public DTO create(DTO dtoWillBeCreate) {
        try {
            MODEL modelWillBeCreate = getDto2model().convert(dtoWillBeCreate);
            if(Objects.nonNull(modelWillBeCreate)) {
                getService().create(modelWillBeCreate);
                MODEL modelCreated = getService().findByCode(modelWillBeCreate.getCode());
                return getModel2dto().convert(modelCreated);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DTO update(DTO dtoWillBeCreate) {
        try {
            MODEL modelWillBeCreate = getDto2model().convert(dtoWillBeCreate);
            if(Objects.nonNull(modelWillBeCreate)) {
                getService().update(modelWillBeCreate);
                return getModel2dto().convert(getService().getById(modelWillBeCreate.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<DTO> getAll() {
        try {
            List<MODEL> modelCreateds = getService().getAll();
            if(!CollectionUtils.isEmpty(modelCreateds)) {
                List<DTO> dtoCreateds = new ArrayList<>();
                modelCreateds.forEach(e -> {
                    dtoCreateds.add(getModel2dto().convert(e));
                });

                return dtoCreateds;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int deleteById(long id) {
        try {
            getService().deleteById(id);
            return EResponse.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return EResponse.FAILED;
        }
    }

    public DTO getById(long id) {
        try {
            MODEL modelGeted = getService().getById(id);
            if(Objects.nonNull(modelGeted)) {
                return getModel2dto().convert(modelGeted);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public DTO getByCode(String code) {
        try {
            MODEL modelGeted = getService().findByCode(code);
            if(Objects.nonNull(modelGeted)) {
                return getModel2dto().convert(modelGeted);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String generatorCode(String className) {
        return className + "-" + new String(Base64.getEncoder().encode(
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).getBytes()));
    }


    public MS getService() {
        return service;
    }

    public ADTO2ModelConverter<DTO, MODEL> getDto2model() {
        return dto2model;
    }

    public AModel2DTOConverter<MODEL, DTO> getModel2dto() {
        return model2dto;
    }
}
