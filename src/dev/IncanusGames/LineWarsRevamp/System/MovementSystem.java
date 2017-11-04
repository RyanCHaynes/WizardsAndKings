package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;


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
			if(game.entityManager.getComponent(entity, Movement.class).isMovement()) {
				vectorMag = getMag(game.getEntityManager().getComponent(entity, ColisionCenter.class).getX(),
						game.getEntityManager().getComponent(entity, ColisionCenter.class).getY(),
						game.getEntityManager().getComponent(entity, Movement.class).getDestX(),
						game.getEntityManager().getComponent(entity, Movement.class).getDestY());
				Xnorm = (game.getEntityManager().getComponent(entity, Movement.class).getDestX()-game.getEntityManager().getComponent(entity, ColisionCenter.class).getX())/vectorMag;
				Ynorm = (game.getEntityManager().getComponent(entity, Movement.class).getDestY()-game.getEntityManager().getComponent(entity, ColisionCenter.class).getY())/vectorMag;
				game.getEntityManager().getComponent(entity, Movement.class).setXnorm(Xnorm);
				game.getEntityManager().getComponent(entity, Movement.class).setYnorm(Ynorm);
				
				game.getEntityManager().getComponent(entity, Movement.class).setTimeReq
				(vectorMag/(game.getEntityManager().getComponent(entity, Movement.class).getSpeed()));
				game.entityManager.getComponent(entity, Movement.class).setMovement(false);
			}
			else if(game.entityManager.getComponent(entity, Movement.class).getTimeReq()<= 0) {//estimate the time it should take to get to the point, if exceeding that time stop movement.
				game.getEntityManager().getComponent(entity, Movement.class).setXnorm(0);
				game.getEntityManager().getComponent(entity, Movement.class).setYnorm(0);
			}
			else game.entityManager.getComponent(entity, Movement.class).setTimeReq(game.entityManager.getComponent(entity, Movement.class).getTimeReq()-1);
		}
	}
	
	private float getMag(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
	}
}
