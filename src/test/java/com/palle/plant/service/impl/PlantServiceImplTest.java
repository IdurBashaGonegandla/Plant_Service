package com.palle.plant.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.palle.plant.pojo.Plant;
import com.palle.plant.repository.PlantRepository;
import com.palle.plant.serviceImpl.PlantServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class PlantServiceImplTest {

	@InjectMocks
	private PlantServiceImpl plantService;
	@Mock
	private PlantRepository plantRepository;

	@Test
	void testSavePlant() {
		log.info("started Testing ...");

		Plant plant = getPlant();

		when(plantRepository.save(any(Plant.class))).thenReturn(plant);

		Plant result = plantService.savePlant(plant);

		assertNotNull(result);
		assertEquals("Mango", result.getName());
		assertEquals(new BigDecimal("250.00"), result.getPrice());
		assertEquals("Fruit", result.getCategory());

		verify(plantRepository, times(1)).save(any(Plant.class));

		log.info("Test method is executed ");
	}

//	reUsable plant for testing
	private Plant getPlant() {
		Plant plant = new Plant();
		plant.setName("Mango");
		plant.setDescription("Mango fruit plant");
		plant.setPrice(new BigDecimal("250.00"));
		plant.setCategory("Fruit");
		plant.setSunlightRequirement("Full Sunlight");
		plant.setWaterRequirement("Moderate");
		plant.setSoilType("Red Soil");
		plant.setStock(50);
		plant.setImageUrl("https://example.com/mango.jpg");

		return plant;
	}

}
