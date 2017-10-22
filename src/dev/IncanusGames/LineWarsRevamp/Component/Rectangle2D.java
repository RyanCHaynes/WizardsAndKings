package dev.IncanusGames.LineWarsRevamp.Component;

public class Rectangle2D implements Component{
	
	private int x, y, width, height;
	
	public Rectangle2D(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		width =w + x;
		height=h + y;
	}
	
	
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
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

}
