package dev.IncanusGames.LineWarsRevamp.Component;

public class Movement implements Component{
	private int facing;
	public Movement(int facing) {
		this.facing = facing;
	}
	
	public int getFacing() {
		return facing;
	}
	public void setFacing(int facing) {
		this.facing = facing;
	}
}
