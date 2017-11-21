package dev.IncanusGames.LineWarsRevamp.System;

import java.util.List;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;

public class InputSystem implements SubSystem{
	private List<Integer> l;
	private static Game game;
	
	public InputSystem(Game g) {
		this.game = g;
	}
	
	public void Update(double deltaTime) {
		l = game.entityManager.getAllEntititiesWithComponentType(Input.class);
		for (Integer entity : l ) {
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
