package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.FacingDirections;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.HumanUnits;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.OrcUnits;
import dev.IncanusGames.LineWarsRevamp.State.GameState;
import dev.IncanusGames.LineWarsRevamp.UI.UIBehaviour;

//Problems
//Order of rendering to screen matters, this system does not account for that. 
//Smooth rendering yet implemented (drawing at scaled positions)

//Purpose
//Render every element with the -Render- Component
public class UIBehaviourSystem implements SubSystem{
	private List<Integer> l, P1, P2;
	private Game game;
	
	public UIBehaviourSystem(Game g) {
		this.game = g;
		this.P1 = P1;
		this.P2 = P2;
	}
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(UIBehaviour.class);
		for(Integer entity : l) {
			if(game.entityManager.getComponent(entity, UIBehaviour.class).isTriggered()) {
				switch(game.entityManager.getComponent(entity, UIBehaviour.class).getBehaviour()) {
				case SPAWN_0:
					game.EA.createUnit((int)GameState.SpawnA.getX(), (int)GameState.SpawnA.getY(), Factions.HUMAN, HumanUnits.FOOT_KNIGHT.ordinal(), 1,FacingDirections.RIGHT, 1);
					game.entityManager.getComponent(entity, UIBehaviour.class).setTriggered(false);
					break;
				case SPAWN_1:
					game.EA.createUnit((int)GameState.SpawnB.getX(), (int)GameState.SpawnB.getY(), Factions.ORC, OrcUnits.WOLF.ordinal(), -1, FacingDirections.LEFT, 2);
					game.entityManager.getComponent(entity, UIBehaviour.class).setTriggered(false);
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

