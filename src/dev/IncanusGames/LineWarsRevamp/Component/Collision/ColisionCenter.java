package dev.IncanusGames.LineWarsRevamp.Component.Collision;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class ColisionCenter implements Component {
	private float x,y;

	public ColisionCenter(float x , float y) {
		this.x=x;
		this.y=y;
	}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
