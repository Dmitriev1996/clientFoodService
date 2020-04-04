package com.service.clientFoodService.daos;

import com.service.clientFoodService.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Admin on 04.04.2020.
 */
public interface ProductTypeDAO extends JpaRepository<ProductType, Long> {
}
