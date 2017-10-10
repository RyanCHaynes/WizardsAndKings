package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Health;

public class HealthSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public HealthSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Health.class);
		for (Integer entity : l ) {
				if(game.entityManager.getComponent(entity, Health.class).getHP() <= 0) {
					game.entityManager.getComponent(entity, Health.class).setAlive(false);
				}
		}
	}
}
