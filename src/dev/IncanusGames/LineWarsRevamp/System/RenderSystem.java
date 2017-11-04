package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Graphics;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.PlayerControlled.UnitCommandBehavior;

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
	
	public void Update(Graphics g, double DeltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Renderable.class);
		for(Integer i : l) {
			
			if (game.entityManager.getComponent(i, Renderable.class).getMaxframe() == 1)
			{
				g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()), 		
						(int)game.entityManager.getComponent(i, Position.class).getX(),
						(int)game.entityManager.getComponent(i, Position.class).getY(), null);
			}
			else {
				game.entityManager.getComponent(i, Renderable.class).setCurrentDealyTimer(
						(game.entityManager.getComponent(i, Renderable.class).getCurrentDealyTimer() + 1)); //increment delay timer 
				if(game.entityManager.getComponent(i, Renderable.class).getframesPerSecond()  //see it delay timer is greater than T-delay
						== game.entityManager.getComponent(i, Renderable.class).getCurrentDealyTimer()) { //set next frame to current frame + 1 % maxframe-1 
					game.entityManager.getComponent(i, Renderable.class).setFrame(
							(game.entityManager.getComponent(i, Renderable.class).getFrame() + 1) 
							% (game.entityManager.getComponent(i, Renderable.class).getMaxframe()));
					game.entityManager.getComponent(i, Renderable.class).setCurrentDealyTimer(0);
				}
				
				g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()), 		
				(int)game.entityManager.getComponent(i, Position.class).getX(),
				(int)game.entityManager.getComponent(i, Position.class).getY(), null);
					
				}
			
			
			
				//extrenous code for development purposes
				if(game.entityManager.hasComponentType(i, Health.class) && game.entityManager.hasComponentType(i, UnitCommandBehavior.class)) {
					 if(game.entityManager.getComponent(i, UnitCommandBehavior.class).isplayerSelected()) {
						 g.drawRect((int)game.entityManager.getComponent(i, Position.class).getX(),
								 (int)game.entityManager.getComponent(i, Position.class).getY(),
								 SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()).getWidth()
								 , -10);
						 g.drawOval(
								 (int)game.entityManager.getComponent(i, ColisionCenter.class).getX(), 
								 (int)game.entityManager.getComponent(i, ColisionCenter.class).getY(),
								 10,
								 10);
					 }
				 }
			}
		} 
	}


 