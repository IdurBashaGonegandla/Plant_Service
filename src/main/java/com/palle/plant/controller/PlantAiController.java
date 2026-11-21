package com.palle.plant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palle.plant.constant.Constant;
import com.palle.plant.service.PlantAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(Constant.PLANTAI)
@Slf4j
@RequiredArgsConstructor
public class PlantAiController {
	
//	@NonNull (it is also used for Constructor Injection ) 
	
	private final PlantAiService plantAiService;
	
	@GetMapping("/ask")
	public String getAnswer(@RequestParam String message) {
		log.info("Requested message: {}", message);

		String response = plantAiService.getAnswer(message);

		log.info("Response from Ai Service :{}", response);
		return response;

	}

}
