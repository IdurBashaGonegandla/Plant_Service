package com.palle.plant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palle.plant.constant.Constant;
import com.palle.plant.pojo.Plant;
import com.palle.plant.service.PlantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Constant.PLANT)
@RequiredArgsConstructor
@Slf4j
public class PlantController {

	private final PlantService plantService;

	@PostMapping
	public Plant savePlant(@Valid @RequestBody Plant plant) {

		log.info("Creating a new plant |" + " plant :{}", plant);

		Plant response = plantService.savePlant(plant);
		log.info("plant response:{} ", response);

		return response;
	}

	@GetMapping
	public List<Plant> getAllPlantsDetails() {

		log.info("Getting plants Details :");

		List<Plant> allPlants = plantService.getAllPlants();
		log.info("allPlants:{}", allPlants);

		return allPlants;
	}

	@GetMapping("{id}")
	public Optional<Plant> getPlantById(@PathVariable int id) {
		log.info("getting Plant id:{}", id);

		Optional<Plant> plantById = plantService.getPlantById(id);
		log.info("plant details plantById:{}", plantById);

		return plantById;
	}

	@GetMapping("/category")
	public List<Plant> getPlantByCategory(@RequestParam String category) {
		log.info("getting Plants by  category:{}", category);

		List<Plant> plantByCategory = plantService.getPlantByCategory(category);
		log.info("plant details plantByCategory:{}", plantByCategory);

		return plantByCategory;
	}

	@PutMapping("/{id}")
	public Plant updatePlant(@RequestBody Plant plant, @PathVariable long id) {
		log.info("updating plant by id:{} | plant:{}", id, plant);

		Plant updatePlant = plantService.updatePlant(plant, id);
		log.info("updated plant details by id:{} | plant:{}", id, plant);

		return updatePlant;

	}

	@PatchMapping("/{id}")
	public Plant updatePartialPlant(@RequestBody Plant plant, @PathVariable long id) {
		log.info("updatingPartially plant by id:{} | plant:{}", id, plant);

		Plant updatePlant = plantService.partialUpdatePlant(plant, id);
		log.info("updated PartialPlant details by id:{} | plant:{}", id, plant);

		return updatePlant;

	}

}
