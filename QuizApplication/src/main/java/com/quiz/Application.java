package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // includes @Configuration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	
//	@Bean 
//	public ModelMapper modelMapper() {
//		System.out.println("in model mapper creation");
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration()				
//				.setMatchingStrategy(MatchingStrategies.STRICT)				
//				.setPropertyCondition(Conditions.isNotNull());
//		return mapper;
//
//	}

}
