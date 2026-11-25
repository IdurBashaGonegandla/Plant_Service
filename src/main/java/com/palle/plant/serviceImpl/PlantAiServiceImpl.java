package com.palle.plant.serviceImpl;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import com.palle.plant.service.PlantAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantAiServiceImpl implements PlantAiService{
	
	private final ChatClient chatClient;

	@Override
	public String getAnswer(String message) {
		log.info("Requested message from Service | message: {} ",message);
		
		ChatResponse chatResponse = chatClient.prompt(message)
				                   .system("You are an analyst. which just retunrs 1 line summary of the message")
								   .call()
								   .chatResponse();
		
		log.info("Ollama model : {}" ,chatResponse.getMetadata().getModel());
		
		String response = chatResponse.getResult()
									  .getOutput()
									  .getText();
		
		log.info("Ai model response from Ollama :{})",response);
		return response;
	}

}
