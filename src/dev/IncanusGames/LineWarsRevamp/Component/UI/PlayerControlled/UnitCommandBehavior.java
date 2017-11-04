package dev.IncanusGames.LineWarsRevamp.Component.UI.PlayerControlled;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class UnitCommandBehavior implements Component{
	private boolean playerSelected;
	private String behavior;

	
	public UnitCommandBehavior(String behavior) {
		this.behavior = behavior;
		playerSelected = false;
	}
	public boolean isplayerSelected() {
		return playerSelected;
	}

	public void setplayerSelected(boolean selected) {
		this.playerSelected = selected;
	}
	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
}
