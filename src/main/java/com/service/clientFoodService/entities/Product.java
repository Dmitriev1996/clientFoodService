package com.service.clientFoodService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_TYPE_ID")
    private ProductType productType;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRODUCT_INGRIDIENTS",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "INGRIDIENT_ID", referencedColumnName = "ID")}
    )
    private List<Ingridient> ingridients;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Product() {}
}
