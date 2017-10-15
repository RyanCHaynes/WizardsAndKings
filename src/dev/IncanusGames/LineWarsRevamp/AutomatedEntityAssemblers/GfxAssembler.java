package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.TimedLife;

public  class GfxAssembler extends Assembler{

	public GfxAssembler(Game g) {
		super(g);
	}

	public static int newTimedAnimation(String anim, boolean Direction, int posX, int posY){
		int entityID = Assembler.E.createEntity();
		Assembler.E.addComponent(entityID, new Position(posX,posY));
		Assembler.E.addComponent(entityID, new Renderable(anim, 1, 0, 4));
		System.out.println("Slash");
		return entityID;
	}
	
}
