package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.Component.Info;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.Position;


//Every entity with a (true)movement has a destination, this formula calculates the destination of entities by normalizing the 
//unit vector between the units current position and it's destination and then multiplying it by deltatime and it's speed
//after that it sets the movement bool to false until a new move command is received;

public class MovementSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public MovementSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTime) {
		float vectorMag, Xnorm, Ynorm;
		l = game.entityManager.getAllEntititiesWithComponentType(Movement.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, ObjectState.class).getState() == ObjectStates.UNIT_MOVE) {
				game.entityManager.getComponent(entity, Position.class).setX(
				game.entityManager.getComponent(entity, Position.class).getX() + 
				(game.entityManager.getComponent(entity, Movement.class).getFacing()*
				game.USM.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getSPEED()));
			}
		}
	}
	
	private float getMag(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
	}
}
