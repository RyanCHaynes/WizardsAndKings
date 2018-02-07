package dev.IncanusGames.LineWarsRevamp.AssetManager;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;

public class UnitStatSheet {

	private int HP, ARMOR, ATTACK_DAMAGE, COST, SPECIAL_COST;
	private Factions faction;
	private double SPEED, RANGE, COOLDOWN;
	private String classType;
	
	public void setData(int HP, int ARMOR, double SPEED, double RANGE, int ATTACK_DAMAGE, Factions faction, String classType) {
		this.HP = HP;
		this.ARMOR = ARMOR;
		this.SPEED = SPEED;
		this.RANGE = RANGE;
		this.ATTACK_DAMAGE = ATTACK_DAMAGE;
		this.faction = faction;
		this.classType = classType;
	}
	public void setCostData(int cost, int special_cost, double cooldown) {
		this.COOLDOWN = cooldown;
		this.COST = cost;
		this.SPECIAL_COST = special_cost;
	}
	
	public int getCOST() {
		return COST;
	}
	public int getSPECIAL_COST() {
		return SPECIAL_COST;
	}
	public double getCOOLDOWN() {
		return COOLDOWN;
	}
	public int getHP() {
		return HP;
	}

	public int getARMOR() {
		return ARMOR;
	}

	public int getATTACK_DAMAGE() {
		return ATTACK_DAMAGE;
	}

	public Factions getFaction() {
		return faction;
	}

	public double getSPEED() {
		return SPEED;
	}

	public double getRANGE() {
		return RANGE;
	}

	public String getClassType() {
		return classType;
	}
	
}
