package dev.IncanusGames.LineWarsRevamp.Component;

public class Vision implements Component{
	private boolean visible, facingForward;
	private int range;
	
	public Vision(int range, boolean visible, boolean facingForward){
		this.range = range;
		this.visible = visible;
		this.facingForward = facingForward;
	}
	
	
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
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
