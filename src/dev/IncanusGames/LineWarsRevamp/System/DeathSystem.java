package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Death;
import dev.IncanusGames.LineWarsRevamp.Component.Health;

public class DeathSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public DeathSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Death.class);
		for (Integer entity : l ) {
				if(game.entityManager.getComponent(entity, Health.class).getHP() <= 0) {
					game.entityManager.getComponent(entity, Health.class).setAlive(false);
				}
		}
	}
}
