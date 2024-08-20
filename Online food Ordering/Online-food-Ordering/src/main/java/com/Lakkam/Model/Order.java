package com.Lakkam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer_order")  // Renaming the table to avoid conflicts with SQL keywords
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private long totalAmount;

    private String orderStatus;

    private Date createdAt;

    @ManyToOne
    private Address deliveryAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  // Ensure the relationship is properly mapped
    private List<OrderItem> itemList;

    // Assuming you plan to add Payment entity later
    // @OneToOne(cascade = CascadeType.ALL)
    // private Payment payment;

    private int totalItems;

    private int totalPrice;
}
