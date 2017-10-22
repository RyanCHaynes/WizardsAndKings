package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.Behavior;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Target;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;

public class BehaviorSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	private static int count = 0;
	public BehaviorSystem(Game g) {
		this.game = g;
	}
	
	public void Update(){
		
		l = game.entityManager.getAllEntititiesWithComponentType(Behavior.class);
		for (Integer entity : l) {
			switch(game.entityManager.getComponent(entity, Behavior.class).getBehaviorTree()) {
			case "skeleton":
				break;
			case"Castle":
				break;
			}
		}
	}
}  
