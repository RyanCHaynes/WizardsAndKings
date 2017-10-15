package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class VisionSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public VisionSystem(Game g) {
		this.game = g;
	}
	
	public void Update(){
		l = game.entityManager.getAllEntititiesWithComponentType(Vision.class);
		for (Integer entity : l) {
			for(Integer entity2 : l) {
				if (entity != entity2) {
					if(game.entityManager.getComponent(entity, Vision.class).isFacingForward())//e is facing right {
						if((game.entityManager.getComponent(entity, Position.class).getX() //x position
							+ game.entityManager.getComponent(entity, Vision.class).getRange() //+ range
							>= game.entityManager.getComponent(entity2, Position.class).getX() //greater than  e2 x pos
							&& game.entityManager.getComponent(entity2, Vision.class).isVisible()//& e2 is visible
							&& game.entityManager.getComponent(entity, Position.class).getX() < //& e2 is not behind e1
							game.entityManager.getComponent(entity2, Position.class).getX()
							))
							{if(!game.entityManager.getComponent(entity, Vision.class).getInRange().contains(entity2)) 
					{
						game.entityManager.getComponent(entity, Vision.class).setTarget(true); //e1 has target
						game.entityManager.getComponent(entity, Vision.class).getInRange().add(entity2);
					} }else {
						game.entityManager.getComponent(entity, Vision.class).setTarget(false); //else e1 has no targets
					}
					if(!game.entityManager.getComponent(entity, Vision.class).isFacingForward())//e is facing left 
						if((game.entityManager.getComponent(entity, Position.class).getX() //x position
								- game.entityManager.getComponent(entity, Vision.class).getRange() //- range
								<= game.entityManager.getComponent(entity2, Position.class).getX() //less than  e2 x pos
								&& game.entityManager.getComponent(entity2, Vision.class).isVisible()//& e2 is visible
								&& game.entityManager.getComponent(entity, Position.class).getX() > //& e2 is not behind e1
								game.entityManager.getComponent(entity2, Position.class).getX()
								)) 
							{if(!game.entityManager.getComponent(entity, Vision.class).getInRange().contains(entity2)){
							game.entityManager.getComponent(entity, Vision.class).setTarget(true); //e1 has target
							game.entityManager.getComponent(entity, Vision.class).getInRange().add(entity2);
						} }else {
							game.entityManager.getComponent(entity, Vision.class).setTarget(false); //else e1 has no targets
						}
							
					}
				}
				}
			}
		}
