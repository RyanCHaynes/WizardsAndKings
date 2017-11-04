package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;

public class PositionSystem implements SubSystem{
		private List<Integer> l;
		private static Game game;
		
		public PositionSystem(Game g) {
			this.game = g;
		}
		
		public void Update(double deltaTime) {
			l = game.entityManager.getAllEntititiesWithComponentType(Position.class);
			for (Integer entity : l ) { 
				if(game.entityManager.hasComponentType(entity, Movement.class)) {//new pos = CurrrentPos + (Speed)(deltaTime)(UnitVector) 
					game.entityManager.getComponent(entity, Position.class).setX(
					(float)(game.entityManager.getComponent(entity, Position.class).getX() + game.entityManager.getComponent(entity, Movement.class).getSpeed()*
					game.entityManager.getComponent(entity, Movement.class).getXnorm()*deltaTime));
					game.entityManager.getComponent(entity, Position.class).setY(
					(float)(game.entityManager.getComponent(entity, Position.class).getY() + game.entityManager.getComponent(entity, Movement.class).getSpeed()*
					game.entityManager.getComponent(entity, Movement.class).getYnorm()*deltaTime));
					if(game.entityManager.hasComponentType(entity, ColisionCenter.class)){//change the pos of the units stand(collisionCenter)
						
						game.entityManager.getComponent(entity, ColisionCenter.class).setX(
								(float)(game.entityManager.getComponent(entity, ColisionCenter.class).getX() + game.entityManager.getComponent(entity, Movement.class).getSpeed()*
								game.entityManager.getComponent(entity, Movement.class).getXnorm()*deltaTime));
						
						game.entityManager.getComponent(entity, ColisionCenter.class).setY(
								(float)(game.entityManager.getComponent(entity, ColisionCenter.class).getY() + game.entityManager.getComponent(entity, Movement.class).getSpeed()*
								game.entityManager.getComponent(entity, Movement.class).getYnorm()*deltaTime));
						System.out.println(game.entityManager.getComponent(entity, ColisionCenter.class).getX());
					}
				}//else it's not moving
			}
		}
		
	}
