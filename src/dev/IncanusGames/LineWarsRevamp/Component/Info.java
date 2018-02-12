package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;

public class Info implements Component{

	private Factions faction;
	private int unitType;
	private int playerOwner;
	
	public Info(Factions f, int unitType, int playerOwner) {
		this.faction = f;
		this.unitType = unitType;
		this.playerOwner = playerOwner;
	}
	
	public Factions getFaction() {
		return faction;
	}

	public void setFaction(Factions faction) {
		this.faction = faction;
	}

	public int getUnitType() {
		return unitType;
	}

	public void setUnitType(int unitType) {
		this.unitType = unitType;
	}
	
	public int getPlayerOwner() {
		return playerOwner;
	}

	public void setPlayerOwner(int playerOwner) {
		this.playerOwner = playerOwner;
	}

}
