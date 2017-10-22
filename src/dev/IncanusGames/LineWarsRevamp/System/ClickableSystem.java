package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Point;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Rectangle2D;
import dev.IncanusGames.LineWarsRevamp.Component.Physics.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;

public class ClickableSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public ClickableSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Clickable.class);
		for (Integer entity : l ) {
				if(game.mouseManager.pressed && inBounds( game.entityManager.getComponent(entity, RectangleHitbox.class), game.mouseManager.position)) {
					game.entityManager.getComponent(entity, Clickable.class).setClicked(true);
				}
				else if (game.entityManager.getComponent(entity, Clickable.class).isClicked() && !game.mouseManager.pressed 
						&& inBounds( game.entityManager.getComponent(entity, RectangleHitbox.class), game.mouseManager.position)){
					game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
					game.entityManager.getComponent(entity, Clickable.class).setSelected(true);
					System.out.println("Clicked:" + entity);
				}
				else if (game.mouseManager.pressed){
					game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
					game.entityManager.getComponent(entity, Clickable.class).setSelected(false);
				}
				
			}
	}
	
	
	
	private boolean inBounds(RectangleHitbox R, Point P1){
		return (P1.getX() >= R.getX() && P1.getX() <= R.getWidth() && P1.getY() >= R.getY() && P1.getY() <= R.getHeight());
	}
}
