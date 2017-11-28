package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;

public class ObjectState implements Component{
	private ObjectStates State;
	
	public ObjectState(ObjectStates State) {
		this.State = State;
	}

	public ObjectStates getState() {
		return State;
	}

	public void setState(ObjectStates state) {
		State = state;
	}
}
