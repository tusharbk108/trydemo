package com.example.CategoryCrudOperation.Model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryid;

    @Column(name = "category_name")
    private String categoryname;

    @Column(name = "category_type")
    private String categorytype;

    @Column(name = "page")
    private String page;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Product> product;

}
