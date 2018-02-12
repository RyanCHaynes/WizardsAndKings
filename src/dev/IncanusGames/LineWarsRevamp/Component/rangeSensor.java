package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.FacingDirections;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.SensorBehaviours;

public class rangeSensor implements Component{
	private boolean isSensing;
	private boolean hasTarget;
	private int Target;
	private FacingDirections direction;
	private SensorBehaviours behaviour;
	


	public rangeSensor(FacingDirections facing, SensorBehaviours behaviour){
		this.direction = facing;
		this.behaviour = behaviour;
		isSensing = true;
		this.hasTarget = false;
		this.Target = -1;
	}
	
	
	public boolean isHasTarget() {
		return hasTarget;
	}
	
	public void setHasTarget(boolean hasTarget) {
		this.hasTarget = hasTarget;
	}

	public int getTarget() {
		return Target;
	}
	
	public void setTarget(int target) {
		Target = target;
	}
	
	public boolean isSensing() {
		return isSensing;
	}

	public void setSensing(boolean isSensing) {
		this.isSensing = isSensing;
	}
	
	public SensorBehaviours getBehavior() {
		return behaviour;
	}

	public void setBehavior(SensorBehaviours behavior) {
		this.behaviour = behavior;
	}
	public FacingDirections getDirection() {
		return direction;
	}
	public int getDirectionAsInt() {
		switch(direction) {
		case LEFT: return -1;
		case NUETRAL: return 0;
		case RIGHT: return 1;
		default: return 0;
		}
	}


	public void setDirection(FacingDirections direction) {
		this.direction = direction;
	}
}
