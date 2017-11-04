package dev.IncanusGames.LineWarsRevamp.Component.Collision;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class Collidable implements Component{
	private String behavior;

	public Collidable(String behavior) {
		this.behavior = behavior;
	}
	
	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
}
