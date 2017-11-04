package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;
import java.util.Random;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Timer;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UI;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UIBehaviour;

public class UIBehaviorSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	private Random R;
	
	public UIBehaviorSystem(Game g) {
		this.game = g;
		R = new Random();
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(UIBehaviour.class);
		for (Integer entity : l ) {
				if(game.getEntityManager().getComponent(entity, UI.class).isTriggerAction() ) {
					game.getEntityManager().getComponent(entity, UI.class).setTriggerAction(false);
					switch(game.getEntityManager().getComponent(entity, UIBehaviour.class).getUIBehaviour())
					{
					case "spawnKnight":
						if (game.getEntityManager().getComponent(entity, Timer.class).isReady()) {
							game.UA.createHumanMountedKnight(220 , 540 , true);
							game.getEntityManager().getComponent(entity, Timer.class).setReady(false);
						}
						else System.out.println("spawn Knight UI on cooldown for" +game.getEntityManager().getComponent(entity, Timer.class).getCurrentCoolDown());
						break;
					case "":
						break;
					}
				} 
			}
	}
}