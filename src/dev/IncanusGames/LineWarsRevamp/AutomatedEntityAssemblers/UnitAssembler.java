package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.ColisionCenter;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.Collidable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.OvalHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;
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
		Assembler.E.addComponent(entityID, new Renderable("KnightStand", 20, 0, 4,false));
		Assembler.E.addComponent(entityID, new Clickable(""));
		return entityID;
	}
	
	public int createHumanMountedKnight(int posX, int posY, boolean Direction) {
		int entityID = Assembler.E.createEntity();
		//Stats
		Assembler.E.addComponent(entityID, new Health(60));
		Assembler.E.addComponent(entityID, new Movement((float).75)); //speed(in pixels per frame)
		
		//rendering
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new Renderable("MKnightStand", 20, 0, 4,true));
		
		//collision and movement Position
		Assembler.E.addComponent(entityID, new OvalHitbox(8));
		Assembler.E.addComponent(entityID, new Collidable("ovalShape"));
		Assembler.E.addComponent(entityID, new ColisionCenter(posX+38/2, posY+31));
		//UI and UI behavior trees
		Assembler.E.addComponent(entityID, new Clickable("Rect"));
		Assembler.E.addComponent(entityID, new RectangleHitbox(38,31));
		Assembler.E.addComponent(entityID, new UnitCommandBehavior("Unit"));
		
		return entityID;
	}
	
	void setPosition() {
		
	}
}
