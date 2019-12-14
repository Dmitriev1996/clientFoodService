package com.service.clientFoodService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "INGRIDIENTS")
@Getter
@Setter
public class Ingridient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "INGRIDIENT_NAME")
    private String ingridientName;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "COUNT")
    private int count;

    public Ingridient(){}
}
