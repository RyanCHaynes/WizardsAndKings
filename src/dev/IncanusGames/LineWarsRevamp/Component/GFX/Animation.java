package dev.IncanusGames.LineWarsRevamp.Component.GFX;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

//A state component that represents the objects animation frame 
public class Animation implements Component{
	private int animationFrame;
	private float animationTimer;
	
	
	public Animation(){
		animationFrame=0;
		animationTimer=0;
	}
	public float getAnimationTimer() {
		return animationTimer;
	}

	public void setAnimationTimer(float animationTimer) {
		this.animationTimer = animationTimer;
	}

	public int getAnimationFrame() {
		return animationFrame;
	}

	public void setAnimationFrame(int animationFrame) {
		this.animationFrame = animationFrame;
	}
}
