package com.palle.plant.service;

import java.util.List;
import java.util.Optional;

import com.palle.plant.pojo.Plant;
import com.palle.plant.pojo.PlantRequest;


public interface PlantService {

	Plant savePlant(Plant plant);

	List<Plant> getAllPlants();

	Optional<Plant> getPlantById(int id);

	List<Plant> getPlantByCategory(String category);

	 Plant updatePlant(Plant plant, long id);

	 Plant partialUpdatePlant(Plant plant, long id);
	

}
