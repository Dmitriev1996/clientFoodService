package com.service.clientFoodService.rest;

import com.service.clientFoodService.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 04.04.2020.
 */
@RestController
@RequestMapping("api/productTypes")
public class ProductTypeResource {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public ResponseEntity<?> getAllProductTypes() {
        try {
            return ResponseEntity.ok(productTypeService.getAllProductTypes());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
