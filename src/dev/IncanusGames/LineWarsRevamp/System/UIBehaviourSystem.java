package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Graphics;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.UI.UIBehaviour;

//Problems
//Order of rendering to screen matters, this system does not account for that. 
//Smooth rendering yet implemented (drawing at scaled positions)

//Purpose
//Render every element with the -Render- Component
public class UIBehaviourSystem implements SubSystem{
	private List<Integer> l;
	private Graphics g;
	private Game game;
	
	public UIBehaviourSystem(Game g) {
		this.game = g;
	}
	
	public void Update(Graphics g, double DeltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(UIBehaviour.class);
		for(Integer entity : l) {
			if(game.entityManager.getComponent(entity, UIBehaviour.class).isTriggered()) {
				switch(game.entityManager.getComponent(entity, UIBehaviour.class).getBehaviour()) {
				case SPAWN_0:
					break;
				case SPAWN_1:
					break;
				case SPAWN_2:
					break;
				case SPAWN_3:
					break;
				case USE_0:
					break;
				case USE_1:
					break;
				case USE_2:
					break;
				case USE_3:
					break;
				default:
					break;
				}
			}
		}
	}
}

