package com.Lakkam.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Food food;

    @ManyToOne
    private Order order;  // This field matches the mappedBy attribute in Order

    private int quantity;

    private long totalPrice;

    @ElementCollection
    private List<String> ingredients;
}
