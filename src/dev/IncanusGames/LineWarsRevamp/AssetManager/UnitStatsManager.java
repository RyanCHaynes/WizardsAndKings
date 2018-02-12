package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.HashMap;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.HumanUnits;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.OrcUnits;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.PropTypes;

public class UnitStatsManager {
	public static HashMap<Factions, HashMap<Integer, UnitStatSheet>> StatsData = new HashMap<Factions, HashMap<Integer, UnitStatSheet>>();
	
	public UnitStatsManager() {
		init();
	}
	
	// HP, ARMOR, SPEED, HITBOX.X, ATTACK RANGE, ATTACK DAMAGE, ATTACK SPEED in APS, faction, unitType;
	public static void init(){
		StatsData.put(Factions.HUMAN, new HashMap<Integer, UnitStatSheet>());
		StatsData.get(Factions.HUMAN).put(HumanUnits.FOOT_KNIGHT.ordinal(), new UnitStatSheet());
		StatsData.get(Factions.HUMAN).get(HumanUnits.FOOT_KNIGHT.ordinal()).setData(10, 0, .5, 128/8, 0, 1, 1, Factions.HUMAN, "footKnight");
		
		StatsData.put(Factions.ORC, new HashMap<Integer, UnitStatSheet>());
		StatsData.get(Factions.ORC).put(OrcUnits.WOLF.ordinal(), new UnitStatSheet());
		StatsData.get(Factions.ORC).get(OrcUnits.WOLF.ordinal()).setData(10, 0, .5, 56/2, 0.0, 2, 1, Factions.ORC, "Wolf");
		
		StatsData.put(Factions.PROPS, new HashMap<Integer, UnitStatSheet>());
		StatsData.get(Factions.PROPS).put(PropTypes.CLOUDONE.ordinal(), new UnitStatSheet());
		StatsData.get(Factions.PROPS).get(PropTypes.CLOUDONE.ordinal()).setData(10, 0, .09, 0, 0.0, 0, 1, Factions.PROPS, "Cloud1");
	}
}
