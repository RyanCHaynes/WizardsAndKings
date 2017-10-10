package dev.IncanusGames.LineWarsRevamp.Component;

public class Attack implements Component {
	private int damage;
	private int coolDown;
	private float currentCD;
	private boolean canAttack;
	private String animation;
	
	public Attack(int d, int c, String animation) {
		damage = d;
		coolDown = c;
		canAttack = true;
		currentCD= 0;
		this.animation = animation;
	}
	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCoolDown() {
		return coolDown;
	}

	public void setCoolDown(int coolDown) {
		this.coolDown = coolDown;
	}

	public String getAnimation() {
		return animation;
	}

	public void setAnimation(String animation) {
		this.animation = animation;
	}

	public float getCurrentCD() {
		return currentCD;
	}

	public void setCurrentCD(float currentCD) {
		this.currentCD = currentCD;
	}
	
}
