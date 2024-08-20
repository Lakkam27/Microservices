package com.Lakkam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    // Add a reference back to IngredientCategory if necessary
    @ManyToOne
    private IngredientCategory ingredientCategory;
}
