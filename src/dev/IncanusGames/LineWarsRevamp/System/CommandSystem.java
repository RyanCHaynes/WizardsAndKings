package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.*;

public class CommandSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public CommandSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTime) {
		l = game.entityManager.getAllEntititiesWithComponentType(CommandList.class);
		for (Integer entity : l ) {
			for(Commands c : game.getEntityManager().getComponent(entity, CommandList.class).getL()){
				switch(game.entityManager.getComponent(entity, Input.class).getInputType()){
				case UNIT:{
					switch(c){
					
					}
				}
					break;
				case BUILDING:{
					
				}
					break;
				case BUTTON:{
					
				}
					break;
				case TOOLTIP:{
					
				}
					break;
				case UI:{
					
				}
					break;
				default:
					break; 
				
				}
			}
		}
	}
}
