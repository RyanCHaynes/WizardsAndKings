package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.HashMap;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.BuildingClass;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.BuildingStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.PropClass;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.PropStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIAnimClasses;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIAnimStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UnitClass;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UnitStates;

/*
 * This class maps "Unit Classes" to states, where a unit class is a unique key identifier that will map class types to their stats and animations
 * This class will also init() all of the keys & data in the Animation Data sheets (hard code)
 *  
 */

public class AnimationDataManager {
	public static HashMap<UnitClass, HashMap<UnitStates, AnimationDataSheet>> UnitAnimationData = new HashMap<UnitClass, HashMap<UnitStates, AnimationDataSheet>>();
	public static HashMap<BuildingClass, HashMap<BuildingStates, AnimationDataSheet>> BuildingAnimationData = new HashMap<BuildingClass, HashMap<BuildingStates, AnimationDataSheet>>();
	public static HashMap<PropClass, HashMap<PropStates, AnimationDataSheet>> PropAnimationData = new HashMap<PropClass, HashMap<PropStates, AnimationDataSheet>>();
	public static HashMap<UIAnimClasses, HashMap<UIAnimStates, AnimationDataSheet>> UIAnimationData = new HashMap<UIAnimClasses, HashMap<UIAnimStates, AnimationDataSheet>>();
	private static String Path;
	
	public AnimationDataManager() {
		initUnitAnimations();
		initBuildingAnimations();
		initPropAnimations();
	}
	
	public static void initUnitAnimations() {
		Path = "Units/";
		//Good Units<Class Init>
		UnitAnimationData.put(UnitClass.MOUNTED_KNIGHT, new HashMap<UnitStates, AnimationDataSheet>());
		UnitAnimationData.put(UnitClass.FOOT_KNIGHT, new HashMap<UnitStates, AnimationDataSheet>());
		UnitAnimationData.put(UnitClass.ARCHER, new HashMap<UnitStates, AnimationDataSheet>());
		//Good Units<Data Init>
		UnitAnimationData.get(UnitClass.MOUNTED_KNIGHT).put(UnitStates.MOVE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.MOUNTED_KNIGHT).get(UnitStates.MOVE).setData(10, 41, 32, 20, Path + "mountedKnight_Move", true, 0);
		UnitAnimationData.get(UnitClass.MOUNTED_KNIGHT).put(UnitStates.IDLE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.MOUNTED_KNIGHT).get(UnitStates.IDLE).setData(4, 152/4, 31, 20, "mountedKnight_Stand", true, 0);
		
		//Have to fix these animations before use
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).put(UnitStates.MOVE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).get(UnitStates.MOVE).setData(10, 41, 32, 20, Path + "footKnight_Move", true, 0);
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).put(UnitStates.IDLE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).get(UnitStates.IDLE).setData(10, 41, 32, 20, Path + "footKnight_Stand", true, 0);
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).put(UnitStates.ATTACK, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.FOOT_KNIGHT).get(UnitStates.ATTACK).setData(10, 41, 32, 20, Path + "footKnight_Attack", true, 0);
		//Objects
		
		UnitAnimationData.put(UnitClass.WOLF,  new HashMap<UnitStates, AnimationDataSheet>());
		UnitAnimationData.get(UnitClass.WOLF).put(UnitStates.MOVE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.WOLF).get(UnitStates.MOVE).setData(10, 41, 32, 20, Path + "Wolf_Move", true, 0);
		UnitAnimationData.put(UnitClass.WOLF,  new HashMap<UnitStates, AnimationDataSheet>());
		UnitAnimationData.get(UnitClass.WOLF).put(UnitStates.IDLE, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.WOLF).get(UnitStates.IDLE).setData(10, 41, 32, 20, Path + "Wolf_Stand", true, 0);
		UnitAnimationData.put(UnitClass.WOLF,  new HashMap<UnitStates, AnimationDataSheet>());
		UnitAnimationData.get(UnitClass.WOLF).put(UnitStates.ATTACK, new AnimationDataSheet());
		UnitAnimationData.get(UnitClass.WOLF).get(UnitStates.ATTACK).setData(10, 41, 32, 20,Path +  "Wolf_Attack", true, 0);
	}
	
	public static void initBuildingAnimations() {
		Path = "Buildings/";
		
		//Good Buildings<Class Init>
		
		//Good Buildings<Data Init>
		BuildingAnimationData.put(BuildingClass.GOODCASTLE,  new HashMap<BuildingStates, AnimationDataSheet>());
		BuildingAnimationData.get(BuildingClass.GOODCASTLE).put(BuildingStates.NORMAL, new AnimationDataSheet());
		BuildingAnimationData.get(BuildingClass.GOODCASTLE).get(BuildingStates.NORMAL).setData(5, 41, 32, 20, Path + "GoodCastle_MaxLife", true, 0);
		//Evil Buildings <Class Init>
		BuildingAnimationData.put(BuildingClass.EVILCASTLE,  new HashMap<BuildingStates, AnimationDataSheet>());
		BuildingAnimationData.get(BuildingClass.EVILCASTLE).put(BuildingStates.NORMAL, new AnimationDataSheet());
		BuildingAnimationData.get(BuildingClass.EVILCASTLE).get(BuildingStates.NORMAL).setData(1, 41, 32, 20, Path + "EvilCastle_MaxLife", true, 0);
				//ComponentSpritesInit
		BuildingAnimationData.get(BuildingClass.EVILCASTLE).put(BuildingStates.PROP0, new AnimationDataSheet());
		BuildingAnimationData.get(BuildingClass.EVILCASTLE).get(BuildingStates.PROP1).setData(1, 41, 32, 20, Path + "EvilCastle_Mouth", true, 0);
		//Evil Buildings <Data Init>
		
	}
	
	public static void initPropAnimations() {
		Path = "Props/";
		PropAnimationData.put(PropClass.SUN,  new HashMap<PropStates, AnimationDataSheet>());
		PropAnimationData.get(PropClass.SUN).put(PropStates.NULL, new AnimationDataSheet());
		PropAnimationData.get(PropClass.SUN).get(PropStates.NULL).setData(3, 41, 32, 20, Path + "Sun_Normal", true, 0);

		
		Path = "Backgrounds/";
		PropAnimationData.put(PropClass.LAVATOP,  new HashMap<PropStates, AnimationDataSheet>());
		PropAnimationData.get(PropClass.LAVATOP).put(PropStates.NULL, new AnimationDataSheet());
		PropAnimationData.get(PropClass.LAVATOP).get(PropStates.NULL).setData(3, 41, 32, 20, Path + "LavaTop_DayTime", true, 0);
		PropAnimationData.put(PropClass.LAVA,  new HashMap<PropStates, AnimationDataSheet>());
		PropAnimationData.get(PropClass.LAVA).put(PropStates.NULL, new AnimationDataSheet());
		PropAnimationData.get(PropClass.LAVA).get(PropStates.NULL).setData(1, 41, 32, 20, Path + "Lava_DayTime", true, 0);
		PropAnimationData.put(PropClass.FOREGROUND,  new HashMap<PropStates, AnimationDataSheet>());
		PropAnimationData.get(PropClass.FOREGROUND).put(PropStates.NULL, new AnimationDataSheet());
		PropAnimationData.get(PropClass.FOREGROUND).get(PropStates.NULL).setData(1, 41, 32, 20, Path + "ForeGround_DayTime", true, 0);
		PropAnimationData.put(PropClass.SKY,  new HashMap<PropStates, AnimationDataSheet>());
		PropAnimationData.get(PropClass.SKY).put(PropStates.DAY, new AnimationDataSheet());
		PropAnimationData.get(PropClass.SKY).get(PropStates.DAY).setData(1, 41, 32, 20, Path + "Sky_DayTime", true, 0);

	}
}
