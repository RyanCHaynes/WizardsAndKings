package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputType;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.CommandList;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
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
	
}
