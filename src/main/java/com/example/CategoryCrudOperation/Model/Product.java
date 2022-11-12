package com.example.CategoryCrudOperation.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private int productid;

    @Column(name = "product_name")
    private String productname;

    @Column(name = "product_type")
    private String producttype;

    @Column(name = "page")
    private String page;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryid;
}
