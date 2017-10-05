package dev.IncanusGames.LineWarsRevamp.Component;

import java.util.List;

public class Vision implements Component{
	private boolean target, visible, facingForward;
	private int range;
	private List<Integer> inRange;
	
	public boolean isTarget() {
		return target;
	}
	public void setTarget(boolean target) {
		this.target = target;
	}
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public List<Integer> getInRange() {
		return inRange;
	}
	public void setInRange(List<Integer> inRange) {
		this.inRange = inRange;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isFacingForward() {
		return facingForward;
	}
	public void setFacingForward(boolean facingForward) {
		this.facingForward = facingForward;
	}
}
