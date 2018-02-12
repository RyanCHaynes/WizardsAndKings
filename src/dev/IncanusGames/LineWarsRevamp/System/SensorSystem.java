package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.FacingDirections;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Info;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.rangeSensor;

public class SensorSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public SensorSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(rangeSensor.class);
		
		for (Integer entity : l ) {
			System.out.println(entity);
			
			if(game.entityManager.getComponent(entity, rangeSensor.class).isSensing()) {
				switch(game.entityManager.getComponent(entity, rangeSensor.class).getBehavior()) {
				
				case SENSE_FOR_ENEMIES_TO_ATTACK:
				{
					for(Integer unit : game.entityManager.getAllEntitiesOnTeam(2)) {
						if(game.entityManager.getComponent(entity, rangeSensor.class).getDirection() == FacingDirections.RIGHT) {
							if(game.entityManager.getComponent(entity, Position.class).getX()
							+ game.USM.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getHalfHitboxX()
							+ game.USM.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getRANGE() >
							
							game.entityManager.getComponent(unit, Position.class).getX() 
							+ game.USM.StatsData.get(game.entityManager.getComponent(unit, Info.class).getFaction()).get(game.entityManager.getComponent(unit, Info.class).getUnitType()).getHalfHitboxX()
							) {
								
								game.entityManager.getComponent(entity, CommandList.class).getL().add(Commands.ATTACK);
								game.entityManager.getComponent(entity, rangeSensor.class).setTarget(unit);
								game.entityManager.getComponent(entity, rangeSensor.class).setSensing(false);
							}
						}
					}
					
					for(Integer unit : game.entityManager.getAllEntitiesOnTeam(1)) {
						if(game.entityManager.getComponent(entity, rangeSensor.class).getDirection() == FacingDirections.LEFT) {
							if(game.entityManager.getComponent(entity, Position.class).getX()
							+ game.USM.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getHalfHitboxX()
							- game.USM.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getRANGE() <
							
							game.entityManager.getComponent(unit, Position.class).getX() 
							+ game.USM.StatsData.get(game.entityManager.getComponent(unit, Info.class).getFaction()).get(game.entityManager.getComponent(unit, Info.class).getUnitType()).getHalfHitboxX()
							) {
								game.entityManager.getComponent(entity, CommandList.class).getL().add(Commands.ATTACK);
								game.entityManager.getComponent(entity, rangeSensor.class).setTarget(unit);
								game.entityManager.getComponent(entity, rangeSensor.class).setSensing(false);
							}
						}
					}
				}
					break;
				default:
					break;
				
				}
			}
		}
	}
	
	private float getMag(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
	}
}
