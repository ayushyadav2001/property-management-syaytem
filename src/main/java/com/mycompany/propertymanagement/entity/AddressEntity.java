package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_TABLE") // if we did not give any name then it will create table of PropertyEntity name of class
@Getter
@Setter
@NoArgsConstructor

public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "HOUSE_NO",nullable = false)
    private String houseNo;
    @Column(name = "STREET",nullable = false) // If we did not give this then ownerEmail name column will be  created
    private String street;
    @Column(name = "CITY",nullable = false)
    private String city;
    @Column(name = "POSTAL_CODE",nullable = false)
    private String postalCode;
    @Column(name = "STATE",nullable = false)
    private String state;
    private String country;

    @OneToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private UserEntity userEntity;


}
