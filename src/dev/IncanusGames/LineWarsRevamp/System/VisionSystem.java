package dev.IncanusGames.LineWarsRevamp.System;

import java.util.ArrayList;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class VisionSystem implements SubSystem{
	private List<Integer> l;
	private List<Integer> inRange;
	private static Game game;
	
	public VisionSystem(Game g) {
		this.game = g;
		l = game.entityManager.getAllEntititiesWithComponentType(Vision.class);
		inRange = new ArrayList<Integer>();
	}
	
	public void Update(){
		for (Integer entity : l) {
			for(Integer entity2 : l) {
				if(game.entityManager.getComponent(entity, Vision.class).isFacingForward()) {
					if((game.entityManager.getComponent(entity, Position.class).getX() + game.entityManager.getComponent(entity, Vision.class).getRange() 
							>= game.entityManager.getComponent(entity2, Position.class).getX()
							&& entity != entity2 
							&& game.entityManager.getComponent(entity2, Vision.class).isVisible())){
						game.entityManager.getComponent(entity, Vision.class).setTarget(true);
						inRange.add(entity2);
					}
					game.entityManager.getComponent(entity, Vision.class).setInRange(inRange);
				}
				else {
					
					game.entityManager.getComponent(entity, Vision.class).setTarget(false);
				}
			}
		}
	}
}
