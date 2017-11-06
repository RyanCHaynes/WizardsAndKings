package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Graphics;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
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
	private Graphics g;
	private Game game;
	
	public RenderSystem(Game g) {
		this.game = g;
	}
	
	public void Update(Graphics g, double DeltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Renderable.class);
		for(Integer entity : l) {
			g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(entity, ClassType.class).getClassType() + "_" +
					game.entityManager.getComponent(entity, ObjectState.class).getState()).
					get(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()),
					(int)game.entityManager.getComponent(entity, Position.class).getX(), 
					(int)game.entityManager.getComponent(entity, Position.class).getY(),
					null);
		}
	}
}


 