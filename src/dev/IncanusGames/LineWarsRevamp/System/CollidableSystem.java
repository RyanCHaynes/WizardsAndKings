package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Physics.Collidable;
import dev.IncanusGames.LineWarsRevamp.Component.Physics.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UI;

public class CollidableSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public CollidableSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Collidable.class);
		for (Integer entity : l ) {
				switch(game.entityManager.getComponent(entity, Collidable.class).getBehavior()) {
				case "Rectangle2D":
						
					break;
				case "ovalShape":
					break;
				}
				
			}
	}
	
}
