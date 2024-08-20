package com.Lakkam.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class RestaurantDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "images", length = 1000)
    private List<String> images;

    private String description;
}
