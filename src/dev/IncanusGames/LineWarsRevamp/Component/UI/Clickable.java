package dev.IncanusGames.LineWarsRevamp.Component.UI;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class Clickable implements Component{
	private boolean clicked;
	private boolean selected;
	private String HitboxType;
	
	public Clickable(String HitboxType) {
		this.HitboxType = HitboxType;
	}
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public String getHitboxType() {
		return HitboxType;
	}

	public void setHitboxType(String hitboxType) {
		HitboxType = hitboxType;
	}
	
}
