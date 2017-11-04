package dev.IncanusGames.LineWarsRevamp.Component;

public class Movement implements Component{
	private boolean movement;
	private float speed; //in pixels per second
	private int destX, destY;
	private float Xnorm,Ynorm;
	private float Xvect, Yvect;//the distance vector (used to calculate movement stoppage)
	private double TimeReq;

	public Movement(float s) {
		this.speed = s;
		movement = false;
	}
	public float getXvect() {
		return Xvect;
	}
	public void setXvect(float xvect) {
		Xvect = xvect;
	}
	public float getYvect() {
		return Yvect;
	}
	public void setYvect(float yvect) {
		Yvect = yvect;
	}
	public double getTimeReq() {
		return TimeReq;
	}

	public void setTimeReq(double timeReq) {
		TimeReq = timeReq;
	}
	public float getXnorm() {
		return Xnorm;
	}

	public void setXnorm(float xnorm) {
		Xnorm = xnorm;
	}

	public float getYnorm() {
		return Ynorm;
	}

	public void setYnorm(float ynorm) {
		Ynorm = ynorm;
	}
	public boolean isMovement() {
		return movement;
	}

	public void setMovement(boolean movement) {
		this.movement = movement;
	}	
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getDestX() {
		return destX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public int getDestY() {
		return destY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}
}
