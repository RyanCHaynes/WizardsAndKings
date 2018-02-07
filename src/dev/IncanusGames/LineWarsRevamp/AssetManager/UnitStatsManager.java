package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.HashMap;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.HumanUnits;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.OrcUnits;

public class UnitStatsManager {
	public static HashMap<Factions, HashMap<Integer, UnitStatSheet>> StatsData = new HashMap<Factions, HashMap<Integer, UnitStatSheet>>();
	
	public UnitStatsManager() {
		init();
	}
	public static void init(){
		StatsData.put(Factions.HUMAN, new HashMap<Integer, UnitStatSheet>());
		StatsData.get(Factions.HUMAN).put(HumanUnits.FOOT_KNIGHT.ordinal(), new UnitStatSheet());
		StatsData.get(Factions.HUMAN).get(HumanUnits.FOOT_KNIGHT.ordinal()).setData(10, 0, .5, 0, 0, Factions.HUMAN, "footKnight");
		
		StatsData.put(Factions.ORC, new HashMap<Integer, UnitStatSheet>());
		StatsData.get(Factions.ORC).put(OrcUnits.WOLF.ordinal(), new UnitStatSheet());
		StatsData.get(Factions.ORC).get(OrcUnits.WOLF.ordinal()).setData(10, 0, .5, 0.0, 0, Factions.ORC, "Wolf");
	}
}
