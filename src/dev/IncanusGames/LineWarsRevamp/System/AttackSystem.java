package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.GfxAssembler;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class AttackSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public AttackSystem(Game g) {
		this.game = g;
	}
	
	public void Update() {
		l = game.entityManager.getAllEntititiesWithComponentType(Attack.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Attack.class).isCanAttack()) {
				if(game.getEntityManager().getComponent(entity, Vision.class).isTarget()) {
					int closest = -999;
					
					if (game.entityManager.getComponent(entity, Vision.class).isFacingForward()) { //if facing right calculate closest target
						for(int i : game.getEntityManager().getComponent(entity, Vision.class).getInRange())
						{ if (closest == -999) closest = i; //if there is no closest
						else if (game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(i, Position.class).getX() < 
								game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(closest, Position.class).getX()
								) { //damage closest target
							game.getEntityManager().getComponent(closest, Health.class).setHP(game.getEntityManager().getComponent(closest, Health.class).getHP()
									- game.getEntityManager().getComponent(entity, Attack.class).getDamage());

							GfxAssembler.newTimedAnimation(game.entityManager.getComponent(entity, Attack.class).getAnimation(), 
									game.entityManager.getComponent(entity, Vision.class).isFacingForward(),
									game.entityManager.getComponent(entity, Position.class).getX(), 
									game.entityManager.getComponent(entity, Position.class).getY());

							game.entityManager.getComponent(entity, Attack.class).setCanAttack(false);
							game.entityManager.getComponent(entity, Attack.class).setCurrentCD(0);
						}
					}
					}
					else { //if facing left calculate closest target
						for(int i : game.getEntityManager().getComponent(entity, Vision.class).getInRange())
						{ if (closest == -999) closest = i; //if there is no closest
						else if (game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(i, Position.class).getX() > 
								game.getEntityManager().getComponent(entity, Position.class).getX() +
								game.getEntityManager().getComponent(closest, Position.class).getX()
								) { 
							game.getEntityManager().getComponent(closest, Health.class).setHP(game.getEntityManager().getComponent(closest, Health.class).getHP()
									- game.getEntityManager().getComponent(entity, Attack.class).getDamage());

							GfxAssembler.newTimedAnimation(game.entityManager.getComponent(entity, Attack.class).getAnimation(), 
									game.entityManager.getComponent(entity, Vision.class).isFacingForward(),
									game.entityManager.getComponent(entity, Position.class).getX(), 
									game.entityManager.getComponent(entity, Position.class).getY());
						}
						}
					}
				}
					//
			}
			else {
				game.entityManager.getComponent(entity, Attack.class).setCurrentCD(
						game.entityManager.getComponent(entity, Attack.class).getCurrentCD() +1);
				System.out.println(game.entityManager.getComponent(entity, Attack.class).getCurrentCD());
			}
		}
	}
}
