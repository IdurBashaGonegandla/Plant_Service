package com.palle.plant.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	  @Bean
	    ChatMemory chatMemory() {
	        return MessageWindowChatMemory.builder()
	                .maxMessages(20)
	                .build();
	    }

	    @Bean
	    ChatClient chatClient(ChatClient.Builder chatClientBuilder,
	                         ChatMemory chatMemory) {

	        return chatClientBuilder
	                .defaultAdvisors(
	                        MessageChatMemoryAdvisor.builder(chatMemory).build()
	                )
	                .build();
	    }

}
