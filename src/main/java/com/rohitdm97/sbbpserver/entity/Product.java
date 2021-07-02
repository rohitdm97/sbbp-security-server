package com.rohitdm97.sbbpserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

}
