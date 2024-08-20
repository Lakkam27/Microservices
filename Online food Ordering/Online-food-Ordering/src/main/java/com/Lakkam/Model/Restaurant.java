package com.Lakkam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User owner;
    private String name;
    private String description;
    @OneToOne
    private Address address;
    private String cuisineType;

    @Embedded
    private ContantInformation contantInformation;
    private String openingHours;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;
    @Column(length = 1000)
    @ElementCollection
    private List<String> images;
    private LocalDateTime registrationDate;
    private boolean open;
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Food> foods=new ArrayList<>();
}
