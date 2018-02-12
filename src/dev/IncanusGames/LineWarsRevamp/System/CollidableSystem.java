package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.Collidable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.OvalHitbox;

public class CollidableSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public CollidableSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Collidable.class);
		for (Integer entity : l ) {
				switch(game.entityManager.getComponent(entity, Collidable.class).getBehavior()) {
				case "Rectangle2D":
						
					break;
				case "ovalShape":
					for(Integer entity2 : l) {
						if (entity == entity2) break;
						switch(game.entityManager.getComponent(entity2, Collidable.class).getBehavior()) {
						case "ovalShape":
							if(OvalOvalColide(game.entityManager.getComponent(entity, OvalHitbox.class), game.entityManager.getComponent(entity, ColisionCenter.class),
									game.entityManager.getComponent(entity2, OvalHitbox.class),game.entityManager.getComponent(entity2, ColisionCenter.class))) {
								System.out.println("Entity:" + entity + "  Collided with:"+ entity2);
							}
						}
					}
						//we know two circles collide if (((magnitude of the vector between their two centers) - magnitude of their radiuses) < magnitude of their radiuses))
					
					break;
				}
				
			}
	}
	
	private boolean OvalOvalColide(OvalHitbox O1, ColisionCenter C1, OvalHitbox O2,ColisionCenter C2){
		double mag = Math.sqrt(Math.pow((C2.getX()-C1.getX()), 2) + Math.pow((C2.getY()-C1.getY()), 2));
		return ((O1.getRaduis() + O2.getRaduis()) >= mag);
	}
}
