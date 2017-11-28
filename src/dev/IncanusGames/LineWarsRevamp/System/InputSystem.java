package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Point;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputState;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.OvalHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;

public class InputSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	
	public InputSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTime) {
		l = game.entityManager.getAllEntititiesWithComponentType(Input.class);
		for (Integer entity : l ) {
			switch(game.entityManager.getComponent(entity, Input.class).getInputType()){
			
			
			case UI: {	
				switch(game.entityManager.getComponent(entity, Input.class).getInputState()){
				
				case NULL: { if(game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
						new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
						game.entityManager.getComponent(entity, Input.class).setInputState(InputState.CLICKED);
				}
				
				}
				case CLICKED: {
					if(!game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.SELECTED);
					} else game.entityManager.getComponent(entity, Input.class).setInputState(InputState.NULL);
					break;
				}
				case SELECTED:{
					game.entityManager.getComponent(entity, CommandList.class).getL().add(Commands.ACTIVATE);
					game.entityManager.getComponent(entity, Input.class).setInputState(InputState.NULL);
				}
				break;
				}
				break;
			}
			
			case UNIT:{
				switch(game.entityManager.getComponent(entity, Input.class).getInputState())
				{
				case NULL: {
					if(game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.CLICKED);
					}break;
				}
				case CLICKED: {
					if(!game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.SELECTED);
					}break;
				}
				case SELECTED:{
					
				}break;
				
				}break;
			}
			
			
			case BUTTON:{
				switch(game.entityManager.getComponent(entity, Input.class).getInputState())
				{
				case NULL:{
					if(game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.CLICKED);
					}break;
					
				}
				case CLICKED: {
					if(!game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.SELECTED);
					}break;
				}
				case SELECTED:{
					
				}break;
				
				}break;
			}
			
			
			case TOOLTIP:{
				switch(game.entityManager.getComponent(entity, Input.class).getInputState())
				{
				case NULL:{
					if(game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.CLICKED);
					}break;
				}
				case CLICKED: {
					if(!game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.SELECTED);
					}break;
				}
				case SELECTED:{
					
				}break;
				
				}break;
			}
			
			
			case BUILDING:{
				switch(game.entityManager.getComponent(entity, Input.class).getInputState())
				{
				case NULL:{
					if(game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.CLICKED);
					}
				}
				case CLICKED: {
					if(!game.mouseManager.pressed && inBoundsRect(game.entityManager.getComponent(entity, RectangleHitbox.class), 
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(), (int)game.getEntityManager().getComponent(entity, Position.class).getY()), game.mouseManager.position)){
							game.entityManager.getComponent(entity, Input.class).setInputState(InputState.SELECTED);
					}
				}
				case SELECTED:{
					
				}
				}
				break;
			}
			
			
			default:
				System.out.println("Entity has no INPUT component");
				break;
			}
		}
	}
	
	
	//Helper functions
	private boolean inBoundsOval(OvalHitbox O, Point O1, Point test){
		double mag = Math.sqrt(Math.pow((test.getX()-(O1.getX()+O.getRaduis())), 2) + Math.pow((test.getY()-(O1.getY()+O.getRaduis())), 2));
		System.out.println(mag);
		System.out.println((O.getRaduis() >= mag));
		return (O.getRaduis() >= mag);
	}
	
	private boolean inBoundsRect(RectangleHitbox R, Point R1, Point test){
		return (test.getX() >= R1.getX() && test.getX() <= (R.getWidth()+R1.getX()) && test.getY() >= R1.getY() && test.getY() <= (R.getHeight()+R1.getY()));
	}
	
}
