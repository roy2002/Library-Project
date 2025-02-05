package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int addressId;
    String address;
    long pinCode;
}


