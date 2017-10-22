package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Behavior;
import dev.IncanusGames.LineWarsRevamp.Component.Death;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Vector2d;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;
import dev.IncanusGames.LineWarsRevamp.Component.Physics.Collidable;
import dev.IncanusGames.LineWarsRevamp.Component.Physics.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;

public class UnitAssembler extends Assembler{

	public UnitAssembler(Game g) {
		super(g);
	}
	
	public int createSkeletonSM(int posX, int posY, boolean Direction) {
		int entityID = Assembler.E.createEntity();
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new Health(10));
		//Assembler.E.addComponent(entityID, new Vision());
		Assembler.E.addComponent(entityID, new Renderable("SkeletalSwordsman", 0, 0, 1));
		Assembler.E.addComponent(entityID, new Movement());
		Assembler.E.addComponent(entityID, new Death());
		if (Direction) {
			Assembler.E.addComponent(entityID, new Vector2d(2,0));
		} 
		else Assembler.E.addComponent(entityID, new Vector2d(-2,0));
		
		Assembler.E.addComponent(entityID, new Behavior("skeleton"));
		//Assembler.E.addComponent(entityID, new Attack(2,60*1, "SlashAnim"));
		Assembler.E.getComponent(entityID, Health.class).setHP(10);
		Assembler.E.getComponent(entityID, Vision.class).setRange(50);
		//Assembler.E.getComponent(entityID, Vision.class).setVisible(true);
		//Assembler.E.getComponent(entityID, Vision.class).setFacingForward(Direction);
		return entityID;
	}
	
	
	
	public int createHumanFootKnight(int posX, int posY, boolean Direction) {

		int entityID = Assembler.E.createEntity();
		
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new RectangleHitbox(posX, posY+10, 24+posX,24+posY));
		Assembler.E.addComponent(entityID, new Collidable());
		Assembler.E.addComponent(entityID, new Behavior("knight"));
		Assembler.E.addComponent(entityID, new Renderable("KnightStand", 20, 0, 4));
		Assembler.E.addComponent(entityID, new Clickable());
		
		
		
		return entityID;
	}

}
