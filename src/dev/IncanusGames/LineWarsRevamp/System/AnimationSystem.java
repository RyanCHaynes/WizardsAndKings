package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.Component;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;

//The purpose of this class is to manage the animation frames of any animate object
public class AnimationSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public AnimationSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTime) {
		l = game.entityManager.getAllEntititiesWithComponentType(Animation.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Animation.class).getAnimationTimer() >= 
			game.ADH.AnimationData.get(GetClassState(entity)).get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getframesPerSecond()
			) {
				game.entityManager.getComponent(entity, Animation.class).setAnimationFrame(
				(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()+1)
				%game.ADH.AnimationData.get(game.entityManager.getComponent(entity,  ObjectState.class).getState())));
			}
			//if the frameTimeCounter > frameDelay(in animationData) , increment frame and reset counter
			//
		}
	}
	
	private String GetClassState(int e) {
		return (game.entityManager.getComponent(e, ClassType.class).getClass()+"_"+game.entityManager.getComponent(e, ObjectState.class).getState());
	}
}