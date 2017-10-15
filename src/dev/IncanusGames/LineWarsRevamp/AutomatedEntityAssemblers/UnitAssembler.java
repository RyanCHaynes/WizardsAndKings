package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Attack;
import dev.IncanusGames.LineWarsRevamp.Component.Behavior;
import dev.IncanusGames.LineWarsRevamp.Component.Death;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Vector2d;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;

public class UnitAssembler extends Assembler{

	public UnitAssembler(Game g) {
		super(g);
	}
	
	public int createSkeletonSM(int posX, int posY, boolean Direction) {
		int entityID = Assembler.E.createEntity();
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new Health(10));
		Assembler.E.addComponent(entityID, new Vision());
		Assembler.E.addComponent(entityID, new Renderable("SkeletalSwordsman", 0, 0, 1));
		Assembler.E.addComponent(entityID, new Movement());
		Assembler.E.addComponent(entityID, new Death());
		if (Direction) {
			Assembler.E.addComponent(entityID, new Vector2d(2,0));
		} 
		else Assembler.E.addComponent(entityID, new Vector2d(-2,0));
		
		Assembler.E.addComponent(entityID, new Behavior("skeleton"));
		Assembler.E.addComponent(entityID, new Attack(2,60*1, "SlashAnim"));
		Assembler.E.getComponent(entityID, Health.class).setHP(10);
		Assembler.E.getComponent(entityID, Vision.class).setRange(50);
		Assembler.E.getComponent(entityID, Vision.class).setVisible(true);
		Assembler.E.getComponent(entityID, Vision.class).setFacingForward(Direction);
		return entityID;
	}

}
