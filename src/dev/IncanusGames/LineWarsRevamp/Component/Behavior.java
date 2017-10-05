package dev.IncanusGames.LineWarsRevamp.Component;

public class Behavior implements Component{
	private String BehaviorTree;
	
	public Behavior(String behaviorTree) {
		BehaviorTree = behaviorTree;
	}

	public String getBehaviorTree() {
		return BehaviorTree;
	}

	public void setBehaviorTree(String behaviorTree) {
		BehaviorTree = behaviorTree;
	}
	
}
