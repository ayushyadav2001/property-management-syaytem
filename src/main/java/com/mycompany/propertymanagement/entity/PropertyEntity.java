package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE") // if we did not give any name then it will create table of PropertyEntity name of class
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE",nullable = false)
    private  String title;
    @Column(name = "PROPERTY_DESCRIPTION",nullable = false)
    private String description;
    @Column(name = "PROPERTY_OWNER_NAME",nullable = false)
    private String ownerName;
    @Column(name = "PROPERTY_OWNER_EMAIL",nullable = false) // If we did not give this then ownerEmail name column will be  created
    private String ownerEmail;
    @Column(name = "PROPERTY_PRICE",nullable = false)
    private Double price;
    @Column(name = "PROPERTY_ADDRESS",nullable = false)
    private String address;
}
