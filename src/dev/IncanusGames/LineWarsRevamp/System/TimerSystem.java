package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Timer;

public class TimerSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public TimerSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Timer.class);
		for (Integer entity : l ) {
				if(game.entityManager.getComponent(entity, Timer.class).isReady()) {
					//do nothing
				}
				else if (game.entityManager.getComponent(entity, Timer.class).getCurrentCoolDown()
						>= game.entityManager.getComponent(entity, Timer.class).getCoolDown()) {
					game.entityManager.getComponent(entity, Timer.class).setCurrentCoolDown(0);
					game.entityManager.getComponent(entity, Timer.class).setReady(true);
				}
				else {//increment timer
					game.entityManager.getComponent(entity, Timer.class).setCurrentCoolDown
					(game.entityManager.getComponent(entity, Timer.class).getCurrentCoolDown() + 1);
				}
			}
		}
}
