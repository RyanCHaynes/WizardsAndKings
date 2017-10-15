package dev.IncanusGames.LineWarsRevamp.Component;

public class Renderable implements Component{
	private String animationName;
	private int frame;
	private int frameCount;
	private int transitionDelay;
	private int currentDealyTimer;
	
	/**
	 * @param (Animation name String, transition delay #, Current Frame #, Max frame #)
	 */
	public Renderable(String animationName, int transiotionDelay, int currentFrame, int frameCount) {
		this.animationName = animationName;
		this.frame = currentFrame;
		this.frameCount = frameCount;
		this.transitionDelay = transiotionDelay;
	}
	
	public int getMaxframe() {
		return frameCount;
	}
	public void setMaxframe(int maxframe) {
		this.frameCount = maxframe;
	}
	
	public String getAnimationName() {
		return animationName;
	}
	public void setAnimationName(String animationName) {
		this.animationName = animationName;
	}
	public int getFrame() {
		return frame;
	}
	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getTransitionDelay() {
		return transitionDelay;
	}

	public void setTransitionDelay(int transitionDelay) {
		this.transitionDelay = transitionDelay;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public int getCurrentDealyTimer() {
		return currentDealyTimer;
	}

	public void setCurrentDealyTimer(int currentDealyTimer) {
		this.currentDealyTimer = currentDealyTimer;
	}
}
