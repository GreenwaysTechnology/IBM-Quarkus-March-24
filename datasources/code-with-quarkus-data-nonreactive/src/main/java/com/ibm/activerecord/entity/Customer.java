package com.ibm.activerecord.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Customer extends PanacheEntity {
  //variables - maps against columns
    @Column(name="name")
    public String name;
    @Column(name="city")
    public String city;
}
