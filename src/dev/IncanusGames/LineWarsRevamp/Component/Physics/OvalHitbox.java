package dev.IncanusGames.LineWarsRevamp.Component.Physics;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class OvalHitbox implements Component{
private int x, y, height, width;
	
	
	public OvalHitbox(int x,int y,int width,int height) {
		this.x =x;
		this.y = y;
		this.width = width;
		this.height = height;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
