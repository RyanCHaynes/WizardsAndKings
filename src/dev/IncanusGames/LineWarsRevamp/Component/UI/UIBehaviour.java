package dev.IncanusGames.LineWarsRevamp.Component.UI;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class UIBehaviour implements Component{
	private String UIBehaviour;
	
	public UIBehaviour(String s) {
		UIBehaviour = s;
	}
	public String getUIBehaviour() {
		return UIBehaviour;
	}

	public void setUIBehaviour(String UIBehaviour) {
		this.UIBehaviour = UIBehaviour;
	}
	
}
