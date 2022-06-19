package com.spring.modules.product.facades.impls;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductFacade extends ATypeManagementFacade<ProductDTO, ProductModel, ProductService> {

    @Autowired
    public ProductFacade(final ProductService service,
                         final ADTO2ModelConverter<ProductDTO, ProductModel> dto2model,
                         final AModel2DTOConverter<ProductModel, ProductDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public String uploadFile(MultipartFile file) {
        try {
            return getService().uploadFile(file);
        } catch (Exception e) {
            System.out.println("loi tao file");
        }
        return null;
    }

    public void deleteByCode(final String code) {
        try {
            getService().deleteByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
