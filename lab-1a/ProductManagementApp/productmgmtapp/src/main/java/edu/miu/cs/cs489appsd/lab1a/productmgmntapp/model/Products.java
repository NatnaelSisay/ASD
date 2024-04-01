package edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
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
