package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;

public class Info implements Component{

	Factions faction;
	int unitType;
	
	public Info(Factions f, int unitType) {
		this.faction = f;
		this.unitType = unitType;
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
}
