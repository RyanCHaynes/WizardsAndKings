package dev.IncanusGames.LineWarsRevamp.Component;

public class ObjectState implements Component{
	private String State;
	private boolean canTransition;
	
	
	public boolean isCanTransition() {
		return canTransition;
	}

	public void setCanTransition(boolean canTransition) {
		this.canTransition = canTransition;
	}
	
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
