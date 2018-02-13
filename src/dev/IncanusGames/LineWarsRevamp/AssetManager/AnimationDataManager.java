package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.HashMap;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;

/*
 * This class maps "Unit Classes" to states, where a unit class is a unique key identifier that will map class types to their stats and animations
 * This class will also init() all of the keys & data in the Animation Data sheets (hard code)
 *  
 */

public class AnimationDataManager {
	public static HashMap<String, HashMap<ObjectStates, AnimationDataSheet>> AnimationData = new HashMap<String, HashMap<ObjectStates, AnimationDataSheet>>();
	public AnimationDataManager() {
		init();
	}
	
	public static void init() {
		//Good Units<Class Init>
		AnimationData.put("mountedKnight", new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.put("footKnight", new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.put("Human_Archer", new HashMap<ObjectStates, AnimationDataSheet>());
		//Good Units<Data Init>
		AnimationData.get("mountedKnight").put(ObjectStates.UNIT_MOVE, new AnimationDataSheet());
		AnimationData.get("mountedKnight").get(ObjectStates.UNIT_MOVE).setData(10, 41, 32, 20, "mountedKnight_Move", true, 0);
		AnimationData.get("mountedKnight").put(ObjectStates.UNIT_IDLE, new AnimationDataSheet());
		AnimationData.get("mountedKnight").get(ObjectStates.UNIT_IDLE).setData(4, 152/4, 31, 20, "mountedKnight_Stand", true, 0);
		
		//Have to fix these animations before use
		AnimationData.get("footKnight").put(ObjectStates.UNIT_MOVE, new AnimationDataSheet());
		AnimationData.get("footKnight").get(ObjectStates.UNIT_MOVE).setData(4, 64/4, 24, 20, "footKnight_Move", true, 0);
		AnimationData.get("footKnight").put(ObjectStates.UNIT_IDLE, new AnimationDataSheet());
		AnimationData.get("footKnight").get(ObjectStates.UNIT_IDLE).setData(4, 128/4, 23, 20, "footKnight_Stand", true, 0);
		AnimationData.get("footKnight").put(ObjectStates.UNIT_ATTACK, new AnimationDataSheet());
		AnimationData.get("footKnight").get(ObjectStates.UNIT_ATTACK).setData(13, 468/13, 33, 10, "footKnight_Attack", true, 0);
		AnimationData.get("footKnight").put(ObjectStates.UNIT_DEATH, new AnimationDataSheet());
		AnimationData.get("footKnight").get(ObjectStates.UNIT_DEATH).setData(1, 32, 32, 10, "footKnight_DEATH", true, 0);
		//Good Buildings<Class Init>
		
		//Good Buildings<Data Init>
		AnimationData.put("GoodCastle",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("GoodCastle").put(ObjectStates.BUILDING_MAXLIFE, new AnimationDataSheet());
		AnimationData.get("GoodCastle").get(ObjectStates.BUILDING_MAXLIFE).setData(5, 41, 32, 20, "GoodCastle_MaxLife", true, 0);
		//Evil Buildings <Class Init>
		AnimationData.put("EvilCastle",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("EvilCastle").put(ObjectStates.BUILDING_MAXLIFE, new AnimationDataSheet());
		AnimationData.get("EvilCastle").get(ObjectStates.BUILDING_MAXLIFE).setData(1, 41, 32, 20, "EvilCastle_MaxLife", true, 0);
				//ComponentSpritesInit
				AnimationData.get("EvilCastle").put(ObjectStates.BUILDING_PROP0, new AnimationDataSheet());
				AnimationData.get("EvilCastle").get(ObjectStates.BUILDING_PROP0).setData(1, 41, 32, 20, "EvilCastle_Mouth", true, 0);
		//Evil Buildings <Data Init>
		AnimationData.put("Wolf",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Wolf").put(ObjectStates.UNIT_MOVE, new AnimationDataSheet());
		AnimationData.get("Wolf").get(ObjectStates.UNIT_MOVE).setData(7, 224/7, 18, 20, "Wolf_Move", true, 0);
		AnimationData.get("Wolf").put(ObjectStates.UNIT_IDLE, new AnimationDataSheet());
		AnimationData.get("Wolf").get(ObjectStates.UNIT_IDLE).setData(2, 56/2, 18, 20, "Wolf_Stand", true, 0);
		AnimationData.get("Wolf").put(ObjectStates.UNIT_ATTACK, new AnimationDataSheet());
		AnimationData.get("Wolf").get(ObjectStates.UNIT_ATTACK).setData(6, 168/6, 18, 10, "Wolf_Attack", true, 0);
		
		//Objects
		
		
		
		//Background/Props
		AnimationData.put("Sun",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Sun").put(ObjectStates.PROP_NULL, new AnimationDataSheet());
		AnimationData.get("Sun").get(ObjectStates.PROP_NULL).setData(3, 41, 32, 20, "Sun_Normal", true, 0);
		AnimationData.put("Foreground",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Foreground").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Foreground").get(ObjectStates.PROP_DAY).setData(1, 416, 234, 20, "foreground_final", true, 0);
		AnimationData.put("LavaTop",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("LavaTop").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("LavaTop").get(ObjectStates.PROP_DAY).setData(3, 41, 32, 20, "LavaTop_DayTime", true, 0);
		
		AnimationData.put("Lava",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Lava").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Lava").get(ObjectStates.PROP_DAY).setData(1, 51, 78, 20, "Lava_DayTime", true, 0);
		
		// Frames Xwidth Ywidth FPS AnimationName Loop loopFrame
		AnimationData.put("Moon",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Moon").put(ObjectStates.PROP_NIGHT, new AnimationDataSheet());
		AnimationData.get("Moon").get(ObjectStates.PROP_NIGHT).setData(1, 84, 52, 20, "moon", true, 0);
		
		AnimationData.put("Cloud1",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Cloud1").put(ObjectStates.PROP_EVENING, new AnimationDataSheet());
		AnimationData.get("Cloud1").get(ObjectStates.PROP_EVENING).setData(1, 122, 33, 20, "cloud morning 1", true, 0);
		AnimationData.put("Cloud2",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Cloud2").put(ObjectStates.PROP_EVENING, new AnimationDataSheet());
		AnimationData.get("Cloud2").get(ObjectStates.PROP_EVENING).setData(1, 89, 34, 20, "cloud morning 2", true, 0);
		AnimationData.put("Cloud3",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Cloud3").put(ObjectStates.PROP_EVENING, new AnimationDataSheet());
		AnimationData.get("Cloud3").get(ObjectStates.PROP_EVENING).setData(1, 128, 40, 20, "cloud morning 3", true, 0);
		
		AnimationData.get("Cloud1").put(ObjectStates.PROP_NIGHT, new AnimationDataSheet());
		AnimationData.get("Cloud1").get(ObjectStates.PROP_NIGHT).setData(1, 122, 33, 20, "cloud night 1", true, 0);
		AnimationData.get("Cloud2").put(ObjectStates.PROP_NIGHT, new AnimationDataSheet());
		AnimationData.get("Cloud2").get(ObjectStates.PROP_NIGHT).setData(1, 95, 34, 20, "cloud night 2", true, 0);
		AnimationData.get("Cloud3").put(ObjectStates.PROP_NIGHT, new AnimationDataSheet());
		AnimationData.get("Cloud3").get(ObjectStates.PROP_NIGHT).setData(1, 128, 40, 20, "cloud night 3", true, 0);
		
		AnimationData.get("Cloud1").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Cloud1").get(ObjectStates.PROP_DAY).setData(1, 122, 33, 20, "cloud day 1", true, 0);
		AnimationData.get("Cloud2").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Cloud2").get(ObjectStates.PROP_DAY).setData(1, 95, 34, 20, "cloud day 2", true, 0);
		AnimationData.get("Cloud3").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Cloud3").get(ObjectStates.PROP_DAY).setData(1, 128, 40, 20, "cloud day 3", true, 0);
		
		AnimationData.put("Sky",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("Sky").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Sky").get(ObjectStates.PROP_DAY).setData(1, 612, 161, 20, "sky morning", true, 0);
		AnimationData.get("Sky").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Sky").get(ObjectStates.PROP_DAY).setData(1, 612, 161, 20, "sky night", true, 0);
		AnimationData.get("Sky").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("Sky").get(ObjectStates.PROP_DAY).setData(1, 612, 161, 20, "sky normal", true, 0);
		
		AnimationData.get("Sky").put(ObjectStates.PROP_NULL, new AnimationDataSheet());
		AnimationData.get("Sky").get(ObjectStates.PROP_NULL).setData(1, 416, 234, 20, "sky_final", true, 0);
		
		AnimationData.put("BirdProp",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("BirdProp").put(ObjectStates.PROP_DAY, new AnimationDataSheet());
		AnimationData.get("BirdProp").get(ObjectStates.PROP_DAY).setData(10, 250/10, 16, 20, "BirdProp", true, 0);
		
		
		
		
		
		
		//UI
		AnimationData.put("TimeBar",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("TimeBar").put(ObjectStates.PROP_NULL, new AnimationDataSheet());
		AnimationData.get("TimeBar").get(ObjectStates.PROP_NULL).setData(1, 225, 16, 20, "TimeBar", true, 0);
		
		AnimationData.put("GoldCoin",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("GoldCoin").put(ObjectStates.PROP_NULL, new AnimationDataSheet());
		AnimationData.get("GoldCoin").get(ObjectStates.PROP_NULL).setData(8, 136/8, 15, 10, "GoldCoin", true, 0);
		
		AnimationData.put("FillerUI",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("FillerUI").put(ObjectStates.UI_NULL, new AnimationDataSheet());
		AnimationData.get("FillerUI").get(ObjectStates.UI_NULL).setData(1, 41, 32, 20, "FillerUI_Unpressed", true, 0);
		AnimationData.get("FillerUI").put(ObjectStates.UI_PRESSED, new AnimationDataSheet());
		AnimationData.get("FillerUI").get(ObjectStates.UI_PRESSED).setData(1, 41, 32, 20, "FillerUI_Pressed", true, 0);
		AnimationData.get("FillerUI").put(ObjectStates.UI_DISPLAY, new AnimationDataSheet());
		AnimationData.get("FillerUI").get(ObjectStates.UI_DISPLAY).setData(1, 41, 32, 20, "FillerUI_Pressed", true, 0);
		
		AnimationData.put("WolfCard",  new HashMap<ObjectStates, AnimationDataSheet>());
		AnimationData.get("WolfCard").put(ObjectStates.UI_NULL, new AnimationDataSheet());
		AnimationData.get("WolfCard").get(ObjectStates.UI_NULL).setData(1, 41, 32, 20, "WolfCardUnpressed", true, 0);
		AnimationData.get("WolfCard").put(ObjectStates.UI_PRESSED, new AnimationDataSheet());
		AnimationData.get("WolfCard").get(ObjectStates.UI_PRESSED).setData(1, 41, 32, 20, "WolfCardPressed", true, 0);
		AnimationData.get("WolfCard").put(ObjectStates.UI_DISPLAY, new AnimationDataSheet());
		AnimationData.get("WolfCard").get(ObjectStates.UI_DISPLAY).setData(1, 41, 32, 20, "WolfCardPressed", true, 0);
	}
}
