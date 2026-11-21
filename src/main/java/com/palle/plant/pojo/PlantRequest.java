package com.palle.plant.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PlantRequest {

	private String name;

	private String description;

	private BigDecimal price;

	private String category;

	private String sunlightRequirement;

	private String waterRequirement;

	private String soilType;

	private Integer stock;

//	    private String imageUrl;

}
