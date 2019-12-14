package com.service.clientFoodService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "ADDRESSES")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NUMBER")
    private int houseNumber;

    @Column(name = "APPARTAMENT_NUMBER")
    private int appartamentNumber;

    public Address() {}
}
