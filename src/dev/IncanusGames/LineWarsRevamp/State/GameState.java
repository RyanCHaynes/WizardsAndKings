package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;
import java.sql.Time;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.System.AnimationSystem;
import dev.IncanusGames.LineWarsRevamp.System.CollidableSystem;
import dev.IncanusGames.LineWarsRevamp.System.InputSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.PositionSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;

public class GameState extends State{
	private static Position SpawnA = new Position(0, 370);
	private static Position SpawnB = new Position(1315, 370);
	private RenderSystem R;
	private MovementSystem M;
	private CollidableSystem ColideSys;
	private PositionSystem Psys;
	private AnimationSystem Asys;
	private InputSystem InptSys;
	private double time = System.nanoTime();
	
	public GameState(Game game) {
		super(game);
		
		this.MakeBackground();
		this.MakeUI();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		
		InptSys = new InputSystem(game);
		ColideSys = new CollidableSystem(game);
		Psys = new PositionSystem(game);
		Asys= new AnimationSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		time += deltaTimeUpdate;
		
		M.Update(deltaTimeUpdate);
		InptSys.Update(deltaTimeUpdate);
		ColideSys.Update();
		Psys.Update(deltaTimeUpdate);
		Asys.Update(deltaTimeUpdate);
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {
		R.Update(g, deltaTimeUpdate);
	}
	
	
	
	
	
	
	
	private void MakeBackground() {
		game.EA.createProp(0, 0, "Sky", ObjectStates.PROP_DAY);
		game.EA.createProp(580, 456, "Lava", ObjectStates.PROP_DAY);
		game.EA.createProp(600, 400, "LavaTop", ObjectStates.PROP_DAY);
		game.EA.createProp(0, 370, "Foreground", ObjectStates.PROP_DAY);
		game.EA.createProp(1, 4, "Sun", ObjectStates.PROP_NULL);
		
		game.EA.createProp(-3, 290, "GoodCastle", ObjectStates.BUILDING_MAXLIFE);
		game.EA.createProp(1115, 295, "EvilCastle", ObjectStates.BUILDING_MAXLIFE);
		
	}
	
	private void MakeUI() {
		//game.EA.createRectangleUI(550, 600, 64, 64, "FillerUI", UIBehaviours.SPAWN_0);
	}
}
