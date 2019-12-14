package com.service.clientFoodService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_ORDER")
    private Date dateOrder;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_DELIVERY")
    private Date dateDelivery;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_PHONE_NUMBER")
    private String clientPhoneNumber;

    @OneToOne
    @JoinColumn(name = "QUITTANCE_ID")
    private Quittance quittance;

    @OneToOne
    @JoinColumn(name = "CHECK_ID")
    private Check check;

    public Order(){}
}
