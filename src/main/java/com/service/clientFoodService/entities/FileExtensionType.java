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

/**
 * Created by Admin on 14.12.2019.
 */
@Entity
@Table(name = "FILE_EXTENSIONS")
@Getter
@Setter
public class FileExtensionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EXTENSION_FILE")
    private String extensionFile;

    public FileExtensionType() {}
}
