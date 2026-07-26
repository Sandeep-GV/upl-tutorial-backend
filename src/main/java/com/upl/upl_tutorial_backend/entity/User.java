package com.upl.upl_tutorial_backend.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "user_master")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;


    @Column(name = "status")
    private String status;

}