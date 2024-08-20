package com.Lakkam.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    private long id;
    private  String name;
    private String description;
    private long price;
    @ManyToOne
    private Category foodCategory;

    @ElementCollection
    @Column(length = 1000)
    private List<String> image;
    private boolean available;

    @ManyToOne
    private Restaurant restaurant;
    private boolean isVegetarian;
    private boolean isSeasonal;

    @ManyToMany
    private List<IngredientsItem> ingredientsItems;
    private Date creationDate;
}
