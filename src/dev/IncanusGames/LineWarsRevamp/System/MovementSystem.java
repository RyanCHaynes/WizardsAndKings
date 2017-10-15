package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Vector2d;

public class MovementSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public MovementSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Movement.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Movement.class).isMovement()) {
				game.entityManager.getComponent(entity, Position.class).setX(game.entityManager.getComponent(entity, Vector2d.class).getX() + 
						game.entityManager.getComponent(entity, Position.class).getX());
				game.entityManager.getComponent(entity, Position.class).setY(game.entityManager.getComponent(entity, Vector2d.class).getY() + 
						game.entityManager.getComponent(entity, Position.class).getY());
			}
		}
	}
}
