package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * This class maps "Unit Classes" to states, where a unit class is a unique key identifier that will map class types to their stats and animations
 * This class will also init() all of the keys & data in the Animation Data sheets (hard code)
 *  
 */

public class AnimationDataManager {
	public static HashMap<String, HashMap<String, AnimationDataSheet>> AnimationData = new HashMap<String, HashMap<String, AnimationDataSheet>>();
	public AnimationDataManager() {
		init();
	}
	
	public static void init() {
		//Good Units<Class Init>
		AnimationData.put("Human_MountedKnight", new HashMap<String, AnimationDataSheet>());
		AnimationData.put("Human_FootKnight", new HashMap<String, AnimationDataSheet>());
		AnimationData.put("Human_Archer", new HashMap<String, AnimationDataSheet>());
		//Good Units<Data Init>
		AnimationData.get("Human_MountedKnight").put("Move", new AnimationDataSheet());
		AnimationData.get("Human_MountedKnight").get("Move").setData(10, 41, 32, 20, "mountedKnight_Move", true, 0);
		AnimationData.get("Human_MountedKnight").put("Stand", new AnimationDataSheet());
		AnimationData.get("Human_MountedKnight").get("Stand").setData(4, 152/4, 31, 20, "mountedKnight_Stand", true, 0);
		
		//Have to fix these animations before use
		AnimationData.get("Human_FootKnight").put("Move", new AnimationDataSheet());
		AnimationData.get("Human_FootKnight").get("Move").setData(10, 41, 32, 20, "footKnight_Move", true, 0);
		AnimationData.get("Human_FootKnight").put("Stand", new AnimationDataSheet());
		AnimationData.get("Human_FootKnight").get("Stand").setData(10, 41, 32, 20, "footKnight_Stand", true, 0);
		AnimationData.get("Human_FootKnight").put("Attack", new AnimationDataSheet());
		AnimationData.get("Human_FootKnight").get("Attack").setData(10, 41, 32, 20, "footKnight_Attack", true, 0);
		//Good Buildings<Class Init>
		
		//Good Buildings<Data Init>
		AnimationData.put("Good_Castle",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Good_Castle").put("MaxLife", new AnimationDataSheet());
		AnimationData.get("Good_Castle").get("MaxLife").setData(10, 41, 32, 20, "GoodCastle_MaxLife", true, 0);
		//Evil Buildings <Class Init>
		AnimationData.put("Evil_Castle",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Evil_Castle").put("MaxLife", new AnimationDataSheet());
		AnimationData.get("Evil_Castle").get("MaxLife").setData(10, 41, 32, 20, "EvilCastle_MaxLife", true, 0);
				//ComponentSpritesInit
				AnimationData.get("Evil_Castle").put("Mouth", new AnimationDataSheet());
				AnimationData.get("Evil_Castle").get("Mouth").setData(10, 41, 32, 20, "EvilCastle_Mouth", true, 0);
		//Evil Buildings <Data Init>
		AnimationData.put("Evil_Wolf",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Evil_Wolf").put("Move", new AnimationDataSheet());
		AnimationData.get("Evil_Wolf").get("Stand").setData(10, 41, 32, 20, "Wolf_Move", true, 0);
		AnimationData.put("Evil_Wolf",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Evil_Wolf").put("Stand", new AnimationDataSheet());
		AnimationData.get("Evil_Wolf").get("Stand").setData(10, 41, 32, 20, "Wolf_Stand", true, 0);
		AnimationData.put("Evil_Wolf",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Evil_Wolf").put("Attack", new AnimationDataSheet());
		AnimationData.get("Evil_Wolf").get("Attack").setData(10, 41, 32, 20, "Wolf_Attack", true, 0);
		
		//Objects
		
		
		
		//Background/Props
		AnimationData.put("Sun",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Sun").put("Normal", new AnimationDataSheet());
		AnimationData.get("Sun").get("Normal").setData(10, 41, 32, 20, "Sun_Normal", true, 0);
		AnimationData.put("Sky",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Sky").put("DayTime", new AnimationDataSheet());
		AnimationData.get("Sky").get("DayTime").setData(10, 41, 32, 20, "Sky_DayTime", true, 0);
		AnimationData.put("Foreground",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Foreground").put("DayTime", new AnimationDataSheet());
		AnimationData.get("Foreground").get("DayTime").setData(10, 41, 32, 20, "ForeGround_DayTime", true, 0);
		AnimationData.put("LavaTop",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("LavaTop").put("DayTime", new AnimationDataSheet());
		AnimationData.get("LavaTop").get("DayTime").setData(10, 41, 32, 20, "LavaTop_DayTime", true, 0);
		AnimationData.put("Lava",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("Lava").put("DayTime", new AnimationDataSheet());
		AnimationData.get("Lava").get("DayTime").setData(10, 41, 32, 20, "Lava_DayTime", true, 0);
		//UI
		AnimationData.put("FillerUI",  new HashMap<String, AnimationDataSheet>());
		AnimationData.get("FillerUI").put("Unpressed", new AnimationDataSheet());
		AnimationData.get("FillerUI").get("Unpressed").setData(10, 41, 32, 20, "FillerUI_Unpressed", true, 0);
		AnimationData.get("FillerUI").put("Pressed", new AnimationDataSheet());
		AnimationData.get("FillerUI").get("Pressed").setData(10, 41, 32, 20, "FillerUI_Pressed", true, 0);

	}
}
