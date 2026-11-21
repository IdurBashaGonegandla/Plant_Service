package com.palle.plant.pojo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String category;

    private String sunlightRequirement;

    private String waterRequirement;

    private String soilType;

    @PositiveOrZero
    private Integer stock;

    private String imageUrl;

}