package com.Lakkam.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCategory {
    @Id
    private int id;
    private String name;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    // Correct the mappedBy attribute to point to the correct field in the Category class
    @JsonIgnore
    @OneToMany(mappedBy = "ingredientCategory", cascade = CascadeType.ALL)
    private List<Category> ingredientCategoryList;  // Assuming Category is the correct class
}
