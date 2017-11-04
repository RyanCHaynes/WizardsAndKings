package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UI;

public class UISystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public UISystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(UI.class);
		for (Integer entity : l ) {
				if(game.getEntityManager().getComponent(entity, Clickable.class).isSelected() ) {
					game.getEntityManager().getComponent(entity, Clickable.class).setSelected(false);
					game.getEntityManager().getComponent(entity, UI.class).setTriggerAction(true);
				} else game.getEntityManager().getComponent(entity, UI.class).setTriggerAction(false);
			}
	}
}