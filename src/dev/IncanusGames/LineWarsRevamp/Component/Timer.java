package dev.IncanusGames.LineWarsRevamp.Component;

public class Timer implements Component{
	private float currentCoolDown;
	private float coolDown;
	private boolean ready;
	
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public Timer(int coolDown) {
		this.coolDown = coolDown;
		ready = true;
		currentCoolDown = 0;
	}
	public float getCurrentCoolDown() {
		return currentCoolDown;
	}
	public void setCurrentCoolDown(float currentCoolDown) {
		this.currentCoolDown = currentCoolDown;
	}
	public float getCoolDown() {
		return coolDown;
	}
	public void setCoolDown(float coolDown) {
		this.coolDown = coolDown;
	}
	
}
