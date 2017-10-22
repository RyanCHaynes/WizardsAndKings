package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Target;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class AttackSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public AttackSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Attack.class);
		int counter = 0;
		for (Integer entity : l ) {
			int closest = -99; //set NULL flag for ID of target
			if(game.entityManager.getComponent(entity, Attack.class).isCanAttack()) {//if the entity can attack
				if(game.getEntityManager().getComponent(entity, Target.class).isTargeting()) { //check if it has a target then calculate the closest one
					if (game.entityManager.getComponent(entity, Vision.class).isFacingForward()) { //if facing right calculate closest target
						for(int i : game.getEntityManager().getComponent(entity, Vision.class).getInRange())
						{ if (closest == -99) {closest = i;}//if there is no closest yet, set closest to ID of first entity checked
						else if (game.getEntityManager().getComponent(entity, Position.class).getX() + //else check which entity is closest
								game.getEntityManager().getComponent(i, Position.class).getX() < 
								game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(closest, Position.class).getX()
								) {
							closest = i;
						}
					}
					}
					else {  closest = -99; //reset flag
						//if facing left calculate closest target
						for(int j : game.getEntityManager().getComponent(entity, Vision.class).getInRange())
						{	
							if (closest == -99) {closest = j;}
						else if (game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(j, Position.class).getX() > 
								game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(closest, Position.class).getX()
								) {
							closest = j;
						}
						}
					}
					//Damage and animation change here?
					
				}
				game.entityManager.getComponent(entity, Attack.class).setCurrentCD(0);
			}
			else {
				game.entityManager.getComponent(entity, Attack.class).setCurrentCD(
						game.entityManager.getComponent(entity, Attack.class).getCurrentCD() +1);
			}
			if (closest != entity && closest != -99) {
				game.entityManager.getComponent(closest, Health.class).setHP(game.entityManager.getComponent(closest, Health.class).getHP() - 
						game.entityManager.getComponent(entity, Attack.class).getDamage());
				System.out.println(closest + " damaged, current health: " + game.entityManager.getComponent(closest, Health.class).getHP());
			}
		}
	}
}
