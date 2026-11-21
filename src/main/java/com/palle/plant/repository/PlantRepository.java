package com.palle.plant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palle.plant.pojo.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{


	List<Plant> findByCategory(String category);

	Optional<Plant> findById(long id);


}
