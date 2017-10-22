package dev.IncanusGames.LineWarsRevamp.Component.Physics;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class Collidable implements Component{
	private String behavior;

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
}
