package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.UnitStatsManager;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Info;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.rangeSensor;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;

public class AttackSystem implements SubSystem{

	private List<Integer> l;
	private static Game game;
	
	public AttackSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Attack.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Attack.class).isAttacking()) {
				game.entityManager.getComponent(entity, Attack.class).setFramesInAttackAnimation(game.entityManager.getComponent(entity, Attack.class).getFramesInAttackAnimation() + 1);
				
				if(game.entityManager.getComponent(entity, Attack.class).getFramesInAttackAnimation() > UnitStatsManager.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getATTACK_SPEED()*60)
						{
					if(game.entityManager.getComponent(game.entityManager.getComponent(entity, rangeSensor.class).getTarget(), Health.class).getHP() <= 0) {
						game.entityManager.getComponent(entity, Attack.class).setAttacking(false);
						game.entityManager.getComponent(entity, ObjectState.class).setState(ObjectStates.UNIT_IDLE);
						game.getEntityManager().getComponent(entity, Animation.class).setAnimationFrame(0);
						game.entityManager.getComponent(entity, rangeSensor.class).setHasTarget(false);
					}else if (game.entityManager.hasComponentType(game.entityManager.getComponent(entity, rangeSensor.class).getTarget(), Health.class)){
							game.entityManager.getComponent(game.entityManager.getComponent(entity, rangeSensor.class).getTarget(), Health.class).setHP(
							(game.entityManager.getComponent(game.entityManager.getComponent(entity, rangeSensor.class).getTarget(), Health.class).getHP()
							- UnitStatsManager.StatsData.get(game.entityManager.getComponent(entity, Info.class).getFaction()).get(game.entityManager.getComponent(entity, Info.class).getUnitType()).getATTACK_DAMAGE()));
					}
							//System.out.println(entity + "Attacked" + game.entityManager.getComponent(entity, rangeSensor.class).getTarget()); who's it's target
				}
			}
		}
	}
}
