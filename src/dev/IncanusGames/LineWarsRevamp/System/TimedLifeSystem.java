package dev.IncanusGames.LineWarsRevamp.System;

import java.util.ArrayList;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.TimedLife;


//
public class TimedLifeSystem {
	private List<Integer> l;
	private List<Integer> remove;
	private static Game game;
	
	public TimedLifeSystem(Game g) {
		this.game = g;
		remove = new ArrayList<Integer>();
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(TimedLife.class);
		
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, TimedLife.class).getExperationTime() <= 
					game.entityManager.getComponent(entity, TimedLife.class).getCurrentTimeAlive()) {
				remove.add(l.indexOf(entity));
			}
			else game.entityManager.getComponent(entity, TimedLife.class).setCurrentTimeAlive(
				game.entityManager.getComponent(entity, TimedLife.class).getCurrentTimeAlive()+1);
		}
		
		for(Integer i : remove) {
			l.remove(i);
			System.out.println(l.remove(i));
		}
	
}
}

