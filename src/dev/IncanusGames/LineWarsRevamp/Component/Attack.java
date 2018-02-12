package dev.IncanusGames.LineWarsRevamp.Component;

public class Attack implements Component {
	private boolean attacking;
	private int framesInAttackAnimation;
	
	public Attack() {
		attacking = false;
		framesInAttackAnimation = 0;
	}
	
	
	public int getFramesInAttackAnimation() {
		return framesInAttackAnimation;
	}

	public void setFramesInAttackAnimation(int framesInAttackAnimation) {
		this.framesInAttackAnimation = framesInAttackAnimation;
	}
	
	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	
}
