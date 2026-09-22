package com.datajpa.demo.jpa.mappings;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime createat;


    public Address(Integer id, String name, String address, String city, String state, String zip, LocalDateTime createat) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.createat = LocalDateTime.now();
    }

    public Address() {

    }

    public LocalDateTime getCreateat() {
        return createat;
    }

    public void setCreateat(LocalDateTime createdate) {
        this.createat = createdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    //TODO [Reverse Engineering] generate columns from DB
}