package com.lakkam.Prodouct.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Product_id")
    private Long productId;

    @Column(name = "Product_name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private double price;

    @Column(name = "Stock")
    private long stock;

    // Constructors
    public Product() {
    }

    public Product(Long productId, String name, String description, double price, long stock) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
