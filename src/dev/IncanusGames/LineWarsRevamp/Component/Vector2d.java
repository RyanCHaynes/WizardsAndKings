package dev.IncanusGames.LineWarsRevamp.Component;

public class Vector2d implements Component{
	private int x, y;

	public Vector2d(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
