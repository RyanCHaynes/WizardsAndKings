package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Behavior;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class BehaviorSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public BehaviorSystem(Game g) {
		this.game = g;
		l = game.entityManager.getAllEntititiesWithComponentType(Behavior.class);
	}
	
	public void Update(){
		for (Integer entity : l) {
			switch(game.entityManager.getComponent(entity, Behavior.class).getBehaviorTree()) {
			case "skeleton":
				game.entityManager.getComponent(entity, Movement.class).setMovement(true);
				if(game.entityManager.getComponent(entity, Vision.class).isTarget()) {
					game.entityManager.getComponent(entity, Movement.class).setMovement(false);
				}
				break;
			case"spawner": 
				break;
			}
		}
	}
}
