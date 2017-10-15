package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Graphics;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.EntityManager.EntityManager;

//Problems
//Order of rendering to screen matters, this system does not account for that. 
//Smooth rendering yet implemented (drawing at scaled positions)

public class RenderSystem implements SubSystem{
	private List<Integer> l;
	private Graphics g;
	private Game game;
	
	public RenderSystem(Game g) {
		this.game = g;
	}
	
	public void Update(Graphics g) {
		l = game.entityManager.getAllEntititiesWithComponentType(Renderable.class);
		for(Integer i : l) {
			if (game.entityManager.getComponent(i, Renderable.class).getMaxframe() == 1)
			{
				g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()), 		
				game.entityManager.getComponent(i, Position.class).getX(),
				game.entityManager.getComponent(i, Position.class).getY(), null);
			}
			else {
				game.entityManager.getComponent(i, Renderable.class).setCurrentDealyTimer(
						(game.entityManager.getComponent(i, Renderable.class).getCurrentDealyTimer() + 1)); //increment delay timer 
				if(game.entityManager.getComponent(i, Renderable.class).getTransitionDelay()  //see it delay timer is greater than T-delay
						== game.entityManager.getComponent(i, Renderable.class).getCurrentDealyTimer()) { //set next frame to current frame + 1 % maxframe-1 
					game.entityManager.getComponent(i, Renderable.class).setFrame(
							(game.entityManager.getComponent(i, Renderable.class).getFrame() + 1) 
							% (game.entityManager.getComponent(i, Renderable.class).getMaxframe()));
					game.entityManager.getComponent(i, Renderable.class).setCurrentDealyTimer(0);
				}
				
				g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()), 		
				game.entityManager.getComponent(i, Position.class).getX(),
				game.entityManager.getComponent(i, Position.class).getY(), null);
			}
		}
	}

}
