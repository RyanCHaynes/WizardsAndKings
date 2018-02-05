package dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.EntityManager.EntityManager;

public abstract class Assembler {
	protected static EntityManager E;
	protected Game g;
	Assembler(Game g){
		E = g.getEntityManager();
	}
}
