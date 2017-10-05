package dev.IncanusGames.LineWarsRevamp.Component;

public class Renderable implements Component{
	private String animationName;
	private int frame;
	
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
}
