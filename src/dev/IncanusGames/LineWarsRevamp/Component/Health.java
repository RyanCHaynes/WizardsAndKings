package dev.IncanusGames.LineWarsRevamp.Component;

public class Health implements Component{
	private int hp, maxHp;
	private boolean alive;
	
	
	
	public Health(int hp){
		this.maxHp = hp;
		this.hp = hp;
		this.alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	public int getHP() {
		return hp;
	}
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
}
