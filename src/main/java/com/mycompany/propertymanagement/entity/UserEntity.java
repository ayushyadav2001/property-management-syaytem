package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE") // if we did not give any name then it will create table of PropertyEntity name of class
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(name = "PROPERTY_OWNER_NAME",nullable = false)
    private String ownerName;
    @Column(name = "EMAIL",nullable = false) // If we did not give this then ownerEmail name column will be  created
    private String ownerEmail;
    private String phone;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
}
