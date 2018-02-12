package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.rangeSensor;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;
import dev.IncanusGames.LineWarsRevamp.UI.UIBehaviour;

public class CommandSystem implements SubSystem{
	private List<Integer> l;
	boolean deleted = false;
	private static Game game;
	
	public CommandSystem(Game g) {
		this.game = g;
	}
	
	public synchronized void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(CommandList.class);
		for (Integer entity : l ) {
			deleted = false;
			for(Commands c : game.getEntityManager().getComponent(entity, CommandList.class).getL()){
				switch(game.entityManager.getComponent(entity, Input.class).getInputType()){
				
				
				case UNIT:{ //UNIT_ATTACK, UNIT_DEFEND, UNIT_IDLE, UNIT_DEATH, UNIT_MOVE
					switch(c){
					case ACTIVATE:{
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
						}
							break;
						case UNIT_MOVE:{
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
					}
						break;
					case ATTACK:
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UNIT_ATTACK);
							game.getEntityManager().getComponent(entity, Movement.class).setMoving(false);
							game.getEntityManager().getComponent(entity, Attack.class).setAttacking(true);
							game.getEntityManager().getComponent(entity, Animation.class).setAnimationFrame(0);
							System.out.println("Command attack to idle");
						}
							break;
						case UNIT_MOVE:{
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UNIT_ATTACK);
							game.getEntityManager().getComponent(entity, Movement.class).setMoving(false);
							game.getEntityManager().getComponent(entity, Attack.class).setAttacking(true);
							game.getEntityManager().getComponent(entity, Animation.class).setAnimationFrame(0);
							System.out.println("Command attack to Moving");
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
						break;
					case DEACTIVATE:
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
						}
							break;
						case UNIT_MOVE:{
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
						break;
					case DEATH:
						game.getEntityManager().removeEntity(entity);
						deleted=true;
						break;
					case DISPLAY:
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UNIT_MOVE);
							game.getEntityManager().getComponent(entity, Movement.class).setMoving(true);
							game.getEntityManager().getComponent(entity, rangeSensor.class).setSensing(true);
							game.getEntityManager().getComponent(entity, Animation.class).setAnimationFrame(0);
						}
							break;
						case UNIT_MOVE:{
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UNIT_IDLE);
							game.getEntityManager().getComponent(entity, Movement.class).setMoving(false);
							game.getEntityManager().getComponent(entity, rangeSensor.class).setSensing(true);
							game.getEntityManager().getComponent(entity, Animation.class).setAnimationFrame(0);
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
						break;
					case MOVE:
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
						}
							break;
						case UNIT_MOVE:{
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
						break;
					case STOP:
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UNIT_IDLE:{
						}
							break;
						case UNIT_MOVE:{
						}
						case UNIT_DEFEND:{ 
						} 
							break;
							
						case UNIT_ATTACK:{ 
						}
							break;
						case UNIT_DEATH:{ 
						}
							break;
						default:
							System.out.println("Invalid command for UNIT entity" + entity + "command Type" + c.toString());
							break;
						}
						break;
					default:
						break;
					}
				}
					break;
					
					
				case BUILDING:{
					switch(c){
					case ACTIVATE:
						break;
					case ATTACK:
						break;
					case DEACTIVATE:
						break;
					case MOVE:
						break;
					case STOP:
						break;
					default:
						break;
					}
				}
					break;
					
					
				case BUTTON:{
					switch(c){
					case ACTIVATE:
						break;
					case ATTACK:
						break;
					case DEACTIVATE:
						break;
					case MOVE:
						break;
					case STOP:
						break;
					default:
						break;
					}
				}
					break;
					
					
				case TOOLTIP:{
					switch(c){
					case ACTIVATE:
						break;
					case ATTACK:
						break;
					case DEACTIVATE:
						break;
					case MOVE:
						break;
					case STOP:
						break;
					default:
						break;
					}
				}
					break;
					
					
				case UI:{
					switch(c){
					case ACTIVATE:{
						switch(game.getEntityManager().getComponent(entity, ObjectState.class).getState()) {
						case UI_ACTIVE:{
							//do whatever it does on activation
							game.getEntityManager().getComponent(entity, UIBehaviour.class).setTriggered(false);
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UI_NULL);
						}
							break;
						case UI_DISPLAY:{
							game.getEntityManager().getComponent(entity, UIBehaviour.class).setTriggered(true);
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UI_NULL);
						}
						case UI_NULL:{ //if it is a UI indicating a passive behavior this is the state of non-activation
							game.getEntityManager().getComponent(entity, UIBehaviour.class).setTriggered(true);
							game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UI_NULL);
						} 
							break;
							
						case UI_OFFCOOLDOWN:{ //UI with active behavior that is available
							game.getEntityManager().getComponent(entity, UIBehaviour.class).setTriggered(true);
							//Execute it's behavior by setting triggered to true, trigger overlay that shows cooldown, play some sound
						}
							break;
						case UI_ONCOOLDOWN:{ //UI with active behavior that is Un-available
							//Can't activate, perform some sound indicator, 
						}
							break;
						case UI_PRESSED:{
							//Display Pressed info
						}
							break;
						default:
							System.out.println("Invalid command for UI entity" + entity + "command Type" + c);
							break;
						
						}
					}
						break;
						
					case DEACTIVATE:{
						
					}
						break;
					case DISPLAY:{
						game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UI_DISPLAY);
					}
						break;
						
					case STOP:{
						game.getEntityManager().getComponent(entity, ObjectState.class).setState(ObjectStates.UI_NULL);
					}
						break;
						
					default: 
						System.out.println("invalid command for UI");
						break;
					}
				}
					break;
					
					
					
					
				default:
					break; 
				
				}
			}
			if(!deleted)game.getEntityManager().getComponent(entity, CommandList.class).getL().clear();
		}
	}
}
