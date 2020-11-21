package com.service.clientFoodService.services.impl;

import com.service.clientFoodService.daos.ProductTypeDAO;
import com.service.clientFoodService.entities.ProductType;
import com.service.clientFoodService.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 04.04.2020.
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeDAO.findAll();
    }
}
