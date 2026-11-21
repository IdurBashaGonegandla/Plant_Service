package com.palle.plant.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.palle.plant.pojo.Plant;
import com.palle.plant.repository.PlantRepository;
import com.palle.plant.service.PlantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

	private final PlantRepository repository;

	@Override
	public Plant savePlant(Plant plant) {

		return repository.save(plant);

	}

	@Override
	public List<Plant> getAllPlants() {

		List<Plant> plantAll = repository.findAll();
		return plantAll;

	}

	@Override
	public Optional<Plant> getPlantById(int id) {

		return repository.findById(id);

	}

	@Override
	public List<Plant> getPlantByCategory(String category) {

		List<Plant> plants = repository.findByCategory(category);

		return plants;
	}

	@Override
	public Plant updatePlant(Plant plant, long id) {
		Optional<Plant> byId = repository.findById(id);

		Plant existingPlant = byId.get();

//		existingPlant`.setId(plant.getId());
		existingPlant.setName(plant.getName());
		existingPlant.setCategory(plant.getCategory());
		existingPlant.setDescription(plant.getDescription());
		existingPlant.setPrice(plant.getPrice());
		existingPlant.setSoilType(plant.getSoilType());
		existingPlant.setStock(plant.getStock());
		existingPlant.setSunlightRequirement(plant.getSunlightRequirement());
		existingPlant.setWaterRequirement(plant.getWaterRequirement());

		return repository.save(existingPlant);
	}

	@Override
	public Plant partialUpdatePlant(Plant plant, long id) {

		Plant existingPlant = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Plant not found with id " + id));

		if (plant.getName() != null)
			existingPlant.setName(plant.getName());
		if (plant.getDescription() != null)
			existingPlant.setDescription(plant.getDescription());
		if (plant.getPrice() != null)
			existingPlant.setPrice(plant.getPrice());
		if (plant.getCategory() != null)
			existingPlant.setCategory(plant.getCategory());
		if (plant.getSunlightRequirement() != null)
			existingPlant.setSunlightRequirement(plant.getSunlightRequirement());
		if (plant.getWaterRequirement() != null)
			existingPlant.setWaterRequirement(plant.getWaterRequirement());
		if (plant.getSoilType() != null)
			existingPlant.setSoilType(plant.getSoilType());
		if (plant.getStock() != null)
			existingPlant.setStock(plant.getStock());

		return repository.save(existingPlant);
	}

}
