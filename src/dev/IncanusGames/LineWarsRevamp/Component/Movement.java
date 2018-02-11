package dev.IncanusGames.LineWarsRevamp.Component;

public class Movement implements Component{
	private int facing;
	private boolean moving;
	
	public Movement(int facing, boolean moving) {
		this.facing = facing;
		this.moving = moving;
	}
	
	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
