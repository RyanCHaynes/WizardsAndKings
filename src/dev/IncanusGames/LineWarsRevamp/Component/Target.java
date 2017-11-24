package dev.IncanusGames.LineWarsRevamp.Component;

public class Target implements Component{
	private int x, y, entity;//x,y Are positional targets, Entity is a target witch represents an "in game object"(building, hero, unit)

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

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}
}
