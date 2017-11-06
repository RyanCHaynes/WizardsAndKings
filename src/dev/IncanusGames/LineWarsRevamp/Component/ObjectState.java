package dev.IncanusGames.LineWarsRevamp.Component;

public class ObjectState implements Component{
	private String State;
	
	public ObjectState(String State) {
		this.State = State;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}
