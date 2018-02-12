package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;

public class HealthSystem implements SubSystem {
	private List<Integer> l;
	private static Game game;
	
	public HealthSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Health.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Health.class).getHP() <= 0) {
				game.entityManager.getComponent(entity, Health.class).setAlive(false);
				game.entityManager.getComponent(entity, CommandList.class).getL().add(Commands.DEATH);
			}
		}
	}
	
	
	
}
