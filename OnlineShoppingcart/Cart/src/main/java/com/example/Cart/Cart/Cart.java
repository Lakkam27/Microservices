package com.example.Cart.Cart;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id ")
    private long cartId;
    @Column(name = "user_id ")
    private long userId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cart_product_quantities", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Long, Integer> productQuantities = new HashMap<>();

    public Cart() {}

    public Cart(long userId) {
        this.userId = userId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public void addProduct(Long productId, Integer quantity) {
        this.productQuantities.put(productId, this.productQuantities.getOrDefault(productId, 0) + quantity);
    }
}