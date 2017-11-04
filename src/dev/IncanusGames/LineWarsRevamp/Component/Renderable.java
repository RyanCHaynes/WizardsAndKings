package dev.IncanusGames.LineWarsRevamp.Component;

public class Renderable implements Component{
	private String animationName;
	private int frame;
	private int frameCount;
	private int framesPerSecond;
	private int currentDealyTimer;
	private boolean loop;
	
	/**
	 * @param (Animation name String, transition delay #, Current Frame #, Max frame #)
	 */
	public Renderable(String animationName, int framesPerSecond, int currentFrame, int frameCount, boolean loop) {
		this.animationName = animationName;
		this.frame = currentFrame;
		this.frameCount = frameCount;
		this.framesPerSecond = framesPerSecond;
		this.loop = loop;
	}
	
	public void setNewAnimation(String animationName, int framesPerSecond, int currentFrame, int frameCount, boolean loop) {
		this.animationName = animationName;
		this.frame = currentFrame;
		this.frameCount = frameCount;
		this.framesPerSecond = framesPerSecond;
		this.loop = loop;
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

	public int getframesPerSecond() {
		return framesPerSecond;
	}

	public void setframesPerSecond(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
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
	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

}
