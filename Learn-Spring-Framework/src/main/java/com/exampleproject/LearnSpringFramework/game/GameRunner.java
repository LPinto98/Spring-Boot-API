package com.exampleproject.LearnSpringFramework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	public void runGame() {
		game.up();
		game.down();
		game.right();
		game.left();
		game.down();
	}
}
