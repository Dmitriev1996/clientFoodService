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

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "DOCUMENT")
@Getter
@Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LINK")
    private String link;

    @OneToOne
    @JoinColumn(name = "FILE_EXTENSION_TYPE_ID")
    private FileExtensionType fileExtensionType;
}
