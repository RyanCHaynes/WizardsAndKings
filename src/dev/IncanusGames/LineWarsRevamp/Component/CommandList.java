package dev.IncanusGames.LineWarsRevamp.Component;

import java.util.LinkedList;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Commands;

public class CommandList implements Component{
	private LinkedList<Commands> l = new LinkedList<Commands>();

	public LinkedList<Commands> getL() {
		return l;
	}

	public void setL(LinkedList<Commands> l) {
		this.l = l;
	}
}
