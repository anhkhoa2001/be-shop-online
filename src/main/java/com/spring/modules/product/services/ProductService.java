package com.spring.modules.product.services;

import com.spring.core.response.EResponse;
import com.spring.core.service.ATypeManagementService;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService extends ATypeManagementService<ProductModel> {

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        super(productRepository);
    }

    public List<ProductModel> getByCID(final long cID) {
        try {
            if(CollectionUtils.isEmpty(getAll())) {
                return Collections.emptyList();
            } else {
                List<ProductModel> products = new ArrayList<>();
                getAll().forEach(e -> {
                    if(e.getCategory().getId() == cID) {
                        products.add(e);
                    }
                });
                return products;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public String uploadFile(MultipartFile file) {
        String fileName = null, name = null;
        try {
            byte[] bytes = file.getBytes();
            String rootPath = EResponse.FILE_PATH_UPLOAD_IMAGE;
            File dir = new File(rootPath + File.separator + "uploads");

            if(!dir.exists()) {
                dir.mkdir();
            }

            name = file.getOriginalFilename();

            File saveFile  = new File(dir.getAbsoluteFile() + File.separator + name);

            if(!saveFile.exists()) {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                stream.write(bytes);
                stream.close();

            }
            fileName = EResponse.FILE_PATH_LOCAL_IMAGE + name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public void deleteByCode(final String code) {
        List<ProductModel> products = getAll();
        products.forEach(e -> {
            if(e.getCode().equals(code)) {
                getR().deleteById(e.getId());
            }
        });
    }

}
