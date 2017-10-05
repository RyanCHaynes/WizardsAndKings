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


public class RenderSystem implements SubSystem{
	private List<Integer> l;
	private Graphics g;
	private Game game;
	
	public RenderSystem(Game g) {
		this.game = g;
		l = game.entityManager.getAllEntititiesWithComponentType(Renderable.class);
	}
	public void Update(Graphics g) {
		for(Integer i : l) {
			g.drawImage(SpriteSheetManager.AnimationMap.get(game.entityManager.getComponent(i, Renderable.class).getAnimationName()).get(game.entityManager.getComponent(i, Renderable.class).getFrame()), 		
			game.entityManager.getComponent(i, Position.class).getX(),
			game.entityManager.getComponent(i, Position.class).getY(), null);
		}
	}

}
