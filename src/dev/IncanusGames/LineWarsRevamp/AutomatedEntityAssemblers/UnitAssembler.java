package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputType;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Input;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.Collidable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.OvalHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;
import dev.IncanusGames.LineWarsRevamp.Component.UI.PlayerControlled.UnitCommandBehavior;

public class UnitAssembler extends Assembler{

	public UnitAssembler(Game g) {
		super(g);
	}
	

	
	
	public int createHumanFootKnight(int posX, int posY, boolean Direction) {
		int entityID = Assembler.E.createEntity();
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new OvalHitbox(16));
		Assembler.E.addComponent(entityID, new Collidable("ovalShape"));
		Assembler.E.addComponent(entityID, new Renderable());
		return entityID;
	}
	
	public int createHumanMountedKnight(int posX, int posY, boolean Direction) {
		int entityID = Assembler.E.createEntity();
		//Stats
		Assembler.E.addComponent(entityID, new Health(60));
		Assembler.E.addComponent(entityID, new Movement((float).75)); //speed(in pixels per frame)
		
		//rendering
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new Renderable());
		Assembler.E.addComponent(entityID, new ClassType("mountedKnight"));
		Assembler.E.addComponent(entityID, new ObjectState("Stand"));
		Assembler.E.addComponent(entityID, new Animation());
		
		//collision and movement Position
		Assembler.E.addComponent(entityID, new OvalHitbox(8));
		Assembler.E.addComponent(entityID, new Collidable("ovalShape"));
		Assembler.E.addComponent(entityID, new ColisionCenter(posX+38/2, posY+31));
		//UI and UI behavior trees
		Assembler.E.addComponent(entityID, new Input(InputType.UNIT));
		Assembler.E.addComponent(entityID, new RectangleHitbox(38,31));
		Assembler.E.addComponent(entityID, new UnitCommandBehavior("Unit"));
		
		return entityID;
	}
	
	void setPosition() {
		
	}
}
