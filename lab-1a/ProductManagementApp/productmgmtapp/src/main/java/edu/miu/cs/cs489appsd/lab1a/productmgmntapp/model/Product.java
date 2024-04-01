package edu.miu.cs.cs489appsd.lab1a.productmgmntapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Data
public class Product {
    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private BigDecimal unitPrice;

    public Product() {
    }

    public Product(long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public Product(long productId, String name, int quantityInStock) {
        this.productId = productId;
        this.name = name;
        this.quantityInStock = quantityInStock;
    }

    public Product(long productId, String name, LocalDate dateSupplied, int quantityInStock, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public String toCsv() {
        return String.format("%s, %s, %s, %s, %s", productId, name, dateSupplied.toString(), quantityInStock, unitPrice);
    }

}
