package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Graphics;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;

//Problems
//Order of rendering to screen matters, this system does not account for that. 
//Smooth rendering yet implemented (drawing at scaled positions)

//Purpose
//Render every element with the -Render- Component
public class RenderSystem implements SubSystem{
	private List<Integer> l;
	private Game game;
	
	public RenderSystem(Game g) {
		this.game = g;
	}
	
	public void Update(Graphics g, double DeltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Renderable.class);
		for(Integer entity : l) {
			if(game.entityManager.hasComponentType(entity, Movement.class)) {
				if(game.entityManager.getComponent(entity, Movement.class).getFacing() == 1) {
					g.drawImage(SpriteSheetManager.AnimationMap.get(game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType())
							.get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getAnimationName()).get(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()),
							(int)game.entityManager.getComponent(entity, Position.class).getX(), 
							(int)game.entityManager.getComponent(entity, Position.class).getY(),
							null);
				} else if (game.entityManager.getComponent(entity, Movement.class).getFacing() == -1) {
					g.drawImage(SpriteSheetManager.AntiAnimationMap.get(game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType())
							.get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getAnimationName()).get(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()),
							(int)game.entityManager.getComponent(entity, Position.class).getX(), 
							(int)game.entityManager.getComponent(entity, Position.class).getY(),
							null);
				}
			
			}
			else {
				g.drawImage(SpriteSheetManager.AnimationMap.get(game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType())
						.get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getAnimationName()).get(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()),
						(int)game.entityManager.getComponent(entity, Position.class).getX(), 
						(int)game.entityManager.getComponent(entity, Position.class).getY(),
						null);
			}
			
		}
	}
}


 