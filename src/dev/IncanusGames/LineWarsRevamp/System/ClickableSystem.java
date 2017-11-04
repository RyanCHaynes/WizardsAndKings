package dev.IncanusGames.LineWarsRevamp.System;

import java.awt.Point;
import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.OvalHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;
import dev.IncanusGames.LineWarsRevamp.Component.UI.PlayerControlled.UnitCommandBehavior;

public class ClickableSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public ClickableSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Clickable.class);
		for (Integer entity : l ) {
				switch (game.entityManager.getComponent(entity, Clickable.class).getHitboxType()){
					case "Oval": 
						if(game.mouseManager.pressed && inBoundsOval( game.entityManager.getComponent(entity, OvalHitbox.class),
							new Point((int)game.entityManager.getComponent(entity, Position.class).getX(),(int)game.entityManager.getComponent(entity, Position.class).getY())
							, game.mouseManager.position))
					{
						game.entityManager.getComponent(entity, Clickable.class).setClicked(true);
					}
					else if (game.entityManager.getComponent(entity, Clickable.class).isClicked() && !game.mouseManager.pressed 
							&& inBoundsOval( game.entityManager.getComponent(entity, OvalHitbox.class),
								new Point((int)game.entityManager.getComponent(entity, Position.class).getX(),(int)game.entityManager.getComponent(entity, Position.class).getY()),
								game.mouseManager.position)){
						game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
						game.entityManager.getComponent(entity, Clickable.class).setSelected(true);
						if(game.entityManager.hasComponentType(entity, UnitCommandBehavior.class)) {
							game.entityManager.getComponent(entity, UnitCommandBehavior.class).setplayerSelected(true);
						}
					}
					else if (game.mouseManager.pressed){
						game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
						game.entityManager.getComponent(entity, Clickable.class).setSelected(false);
						break;
				}
				case "Rect":
					if(game.mouseManager.pressed && inBoundsRect( game.entityManager.getComponent(entity, RectangleHitbox.class),
						new Point((int)game.entityManager.getComponent(entity, Position.class).getX(),(int)game.entityManager.getComponent(entity, Position.class).getY()), 
						game.mouseManager.position)) { game.entityManager.getComponent(entity, Clickable.class).setClicked(true);
						System.out.println("Clicked");
					}
					else if (game.entityManager.getComponent(entity, Clickable.class).isClicked() && !game.mouseManager.pressed 
							&& inBoundsRect( game.entityManager.getComponent(entity, RectangleHitbox.class)
							,new Point((int)game.entityManager.getComponent(entity, Position.class).getX(),(int)game.entityManager.getComponent(entity, Position.class).getY())
							, game.mouseManager.position)){
						game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
						game.entityManager.getComponent(entity, Clickable.class).setSelected(true);
						if(game.entityManager.hasComponentType(entity, UnitCommandBehavior.class)) {
							game.entityManager.getComponent(entity, UnitCommandBehavior.class).setplayerSelected(true);
							System.out.println("selected");
						}
					}
					else if (game.mouseManager.pressed){
						game.entityManager.getComponent(entity, Clickable.class).setClicked(false);
						game.entityManager.getComponent(entity, Clickable.class).setSelected(false);
					}
					break;
					default:
						System.out.println("No hitbox type for entity:" + entity);
				}
		}
	}
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
