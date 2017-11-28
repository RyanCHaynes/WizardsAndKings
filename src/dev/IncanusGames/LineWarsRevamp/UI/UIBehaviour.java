package dev.IncanusGames.LineWarsRevamp.UI;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class UIBehaviour implements Component{
	private UIBehaviours behaviour;
	private boolean triggered;
	
	public UIBehaviours getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(UIBehaviours behaviour) {
		this.behaviour = behaviour;
	}

	public UIBehaviour(UIBehaviours behaviour){
		this.behaviour = behaviour;
		triggered = false;
	}
	public boolean isTriggered() {
		return triggered;
	}

	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}
	
}
