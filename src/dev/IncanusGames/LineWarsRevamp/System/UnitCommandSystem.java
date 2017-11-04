package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.UI.PlayerControlled.UnitCommandBehavior;

// Translates the on screen input for selected units into commands;
public class UnitCommandSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public UnitCommandSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
	l = game.entityManager.getAllEntititiesWithComponentType(UnitCommandBehavior.class);
	for (Integer entity : l ) {
			if(game.getEntityManager().getComponent(entity, UnitCommandBehavior.class).isplayerSelected() ) {
				if (game.mouseManager.pressed && game.mouseManager.rightClick) {
					game.getEntityManager().getComponent(entity, Movement.class).setDestX(game.mouseManager.position.x);
					game.getEntityManager().getComponent(entity, Movement.class).setDestY(game.mouseManager.position.y);
					game.getEntityManager().getComponent(entity, Movement.class).setMovement(true);
					System.out.println(game.getEntityManager().getComponent(entity, Movement.class).getDestX());
					System.out.println(game.getEntityManager().getComponent(entity, Movement.class).getDestY());
				}
				if (game.mouseManager.pressed && game.mouseManager.leftClick) {
					game.getEntityManager().getComponent(entity, UnitCommandBehavior.class).setplayerSelected(false);
				}
			}
		}
	
}
}