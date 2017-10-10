package dev.IncanusGames.LineWarsRevamp.Component;

public class TimedLife implements Component{

	private int experationTime;
	private int currentTimeAlive;
	
	public TimedLife(int et) {
		this.experationTime = et;
		this.currentTimeAlive = 0;
	}
	
	public int getExperationTime() {
		return experationTime;
	}

	public void setExperationTime(int experationTime) {
		this.experationTime = experationTime;
	}

	public int getCurrentTimeAlive() {
		return currentTimeAlive;
	}

	public void setCurrentTimeAlive(int currentTimeAlive) {
		this.currentTimeAlive = currentTimeAlive;
	}

}
