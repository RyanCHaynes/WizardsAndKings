package dev.IncanusGames.LineWarsRevamp.Component.UI;

import dev.IncanusGames.LineWarsRevamp.Component.Component;

public class Clickable implements Component{
	private boolean clicked;
	private boolean selected;
	
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
	
}
