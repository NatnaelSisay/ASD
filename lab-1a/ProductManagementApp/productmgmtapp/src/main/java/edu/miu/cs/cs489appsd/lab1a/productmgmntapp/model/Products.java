package edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Products {
    List<Product> products;

    public Products() {
    }

    public Products(List<Product> products) {
        this.products = products;
    }
}
