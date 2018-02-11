package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.AnimationDataManager;
import dev.IncanusGames.LineWarsRevamp.AssetManager.UnitStatsManager;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputType;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Info;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;
import dev.IncanusGames.LineWarsRevamp.UI.UIBehaviour;

public class EntityAssembler extends Assembler{

	public EntityAssembler(Game g) {
		super(g);
	}
	
	
	//UI
	public void createRectangleUI(float posX, float posY, int height, int width, String sprite, UIBehaviours behaviour) { //link UI to some programmatic behavior, can do this via enum - switch combo. 
		int entity = E.createEntity();
		E.addComponent(entity, new Position(posX, posY));
		E.addComponent(entity, new Renderable());
		E.addComponent(entity, new Input(InputType.UI));
		E.addComponent(entity, new RectangleHitbox(height,width));
		E.addComponent(entity, new ClassType(sprite));
		E.addComponent(entity, new CommandList());
		E.addComponent(entity, new ObjectState(ObjectStates.UI_NULL));
		E.addComponent(entity, new UIBehaviour(behaviour));
		E.addComponent(entity, new Animation());
	}
	
	//props
	public void createProp(float posX, float posY, String sprite, ObjectStates state) {
		int entity = E.createEntity();
		E.addComponent(entity, new Position(posX,posY));
		E.addComponent(entity, new Renderable());
		E.addComponent(entity, new ClassType(sprite));
		E.addComponent(entity, new ObjectState(state));
		E.addComponent(entity, new Animation());
	}
	
	public void createMovingProp(float posX, float posY, String sprite, int facing,Factions f,  int propType, ObjectStates state) {
		int entity = E.createEntity();
		E.addComponent(entity, new Position(posX,posY));
		E.addComponent(entity, new Renderable());
		E.addComponent(entity, new ClassType(sprite));
		E.addComponent(entity, new ObjectState(state));
		E.addComponent(entity, new Animation());
		E.addComponent(entity, new Movement(facing, true));
		E.addComponent(entity, new Info(f, propType));
	}
	
	
	
	public void createUnit(int x, int y, Factions f, int unitType, int facing) {
		int entity = E.createEntity();
		E.addComponent(entity, new Position(x,y));
		E.addComponent(entity, new Renderable());
		E.addComponent(entity, new Animation());
		E.addComponent(entity, new Input(InputType.UNIT));
		E.addComponent(entity, new Movement(facing, false));
		E.addComponent(entity, new ClassType(UnitStatsManager.StatsData.get(f).get(unitType).getClassType()));
		E.addComponent(entity, new RectangleHitbox(AnimationDataManager.AnimationData.get(UnitStatsManager.StatsData.get(f).get(unitType).getClassType()).get(ObjectStates.UNIT_IDLE).getxWidth(), 
				AnimationDataManager.AnimationData.get(UnitStatsManager.StatsData.get(f).get(unitType).getClassType()).get(ObjectStates.UNIT_IDLE).getyWidth()));
		E.addComponent(entity, new CommandList());
		E.addComponent(entity, new ObjectState(ObjectStates.UNIT_IDLE));
		E.addComponent(entity, new Info(f, unitType));
		System.out.println("created " + unitType);
	}
	
}
 