package dev.IncanusGames.LineWarsRevamp.Component;

public class Target implements Component{
	private boolean targeting;
	private int target;

	public boolean isTargeting() {
		return targeting;
	}
	public void setTargeting(boolean targeting) {
		this.targeting = targeting;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	
}
