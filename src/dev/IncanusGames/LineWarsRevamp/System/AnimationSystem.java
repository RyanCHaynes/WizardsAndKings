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
	
	public void Update(double deltaTimeUpdate) {
		l = game.entityManager.getAllEntititiesWithComponentType(Animation.class);
		for (Integer entity : l ) {
			if(game.entityManager.getComponent(entity, Animation.class).isAnimationSwitched()) {
				game.entityManager.getComponent(entity, Animation.class).setAnimationSwitched(false);
				game.entityManager.getComponent(entity, Animation.class).setAnimationFrame(0);
				game.entityManager.getComponent(entity, Animation.class).setAnimationTimer(0);
			}
			game.entityManager.getComponent(entity, Animation.class).setAnimationTimer(game.entityManager.getComponent(entity, Animation.class).getAnimationTimer()+1);
			if(game.ADH.AnimationData.get(game.entityManager.getComponent(entity,  ClassType.class).getClassType()).get(game.entityManager.getComponent(entity,  ObjectState.class).getState()).getMaxFrame() == 1) {game.entityManager.getComponent(entity, Animation.class).setAnimationTimer(0);} //do nothing
			else if(game.entityManager.getComponent(entity, Animation.class).getAnimationTimer() >= 
			game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType()).get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getframesPerSecond() //if A timer >= framesPerAFrame
			) {
				game.entityManager.getComponent(entity, Animation.class).setAnimationTimer(0);
				if(game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType()).get(game.entityManager.getComponent(entity, ObjectState.class).getState()).isLoop()) {		//if it loops calc next frame with a mod
					game.entityManager.getComponent(entity, Animation.class).setAnimationFrame((
					(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()+1)%game.ADH.AnimationData.get(game.entityManager.getComponent(entity,  ClassType.class).
					getClassType()).get(game.entityManager.getComponent(entity,  ObjectState.class).getState()).getMaxFrame())); 
				} else if ((game.entityManager.getComponent(entity, Animation.class).getAnimationFrame())
				== game.ADH.AnimationData.get(game.entityManager.getComponent(entity, ClassType.class).getClassType()).get(game.entityManager.getComponent(entity, ObjectState.class).getState()).getMaxFrame()) {}// if it dosen't loop check if current frame == max frame, if not increment;
				else game.entityManager.getComponent(entity, Animation.class).setAnimationFrame(game.entityManager.getComponent(entity, Animation.class).getAnimationFrame()+1);
			}
			//if the frameTimeCounter > frameDelay(in animationData) , increment frame and reset counter
			//
		}
	}
}