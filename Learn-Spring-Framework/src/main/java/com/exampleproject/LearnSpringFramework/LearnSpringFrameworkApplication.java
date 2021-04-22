package com.exampleproject.LearnSpringFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.exampleproject.LearnSpringFramework.game.GameRunner;
import com.exampleproject.LearnSpringFramework.game.MarioGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args); 
		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		// MarioGame game = new MarioGame();
		GameRunner runner = context.getBean(GameRunner.class);
		runner.runGame();
	}

}
