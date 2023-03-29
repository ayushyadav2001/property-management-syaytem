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
    @Column(name = "PROPERTY_PRICE",nullable = false)
    private Double price;
    @Column(name = "PROPERTY_ADDRESS",nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY) //it will not fetch the user
    // data while fetching the property by default it is EAGER and when we need to fetchn the user data then we use EAGER
    @JoinColumn(name = "USER_ID" ,nullable = false)
    private UserEntity userEntity;
}
