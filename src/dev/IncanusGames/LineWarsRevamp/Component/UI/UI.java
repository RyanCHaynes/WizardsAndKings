package dev.IncanusGames.LineWarsRevamp.Component.UI;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class UI implements Component{
	private boolean TriggerAction;

	public boolean isTriggerAction() {
		return TriggerAction;
	}

	public void setTriggerAction(boolean Action) {
		this.TriggerAction = Action;
	}
	
	
}
