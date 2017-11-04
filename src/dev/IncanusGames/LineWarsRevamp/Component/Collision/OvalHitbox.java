package dev.IncanusGames.LineWarsRevamp.Component.Collision;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class OvalHitbox implements Component{
	private int raduis;
	
	
	public OvalHitbox(int raduis) {
		this.raduis = raduis;
	}
	
	public int getRaduis() {
		return raduis;
	}

	public void setRaduis(int raduis) {
		this.raduis = raduis;
	}
	
}
