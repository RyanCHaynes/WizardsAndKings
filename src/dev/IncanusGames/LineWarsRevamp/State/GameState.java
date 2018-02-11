package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.System.AnimationSystem;
import dev.IncanusGames.LineWarsRevamp.System.CollidableSystem;
import dev.IncanusGames.LineWarsRevamp.System.CommandSystem;
import dev.IncanusGames.LineWarsRevamp.System.InputSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.UIBehaviourSystem;

public class GameState extends State{
	public static Position SpawnA = new Position(180, 510);
	public static Position SpawnB = new Position(1000, 510);
	private RenderSystem R;
	private MovementSystem M;
	private CollidableSystem ColideSys;
	private AnimationSystem Asys;
	private InputSystem InptSys;
	private CommandSystem CmdSys;
	private UIBehaviourSystem UBSys;
	private int Gold = 100;
	private double StateTime = 0;
	
	public GameState(Game game) {
		super(game);
		this.MakeBackground();
		this.MakeUI();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		
		CmdSys = new CommandSystem(game);
		InptSys = new InputSystem(game);
		ColideSys = new CollidableSystem(game);
	//	Psys = new PositionSystem(game);
		Asys= new AnimationSystem(game);
		UBSys = new UIBehaviourSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		
		
		//GameState Data update
		StateTime = StateTime + deltaTimeUpdate;
		if (StateTime > 60) {Gold++; StateTime = 0;} //Gain one gold a second (frame based)
		
		
		//SystemsUpdates
		M.Update(deltaTimeUpdate);
		InptSys.Update(deltaTimeUpdate);
		ColideSys.Update();
	//	Psys.Update(deltaTimeUpdate);
		Asys.Update(deltaTimeUpdate);
		CmdSys.Update(deltaTimeUpdate);
		UBSys.Update(deltaTimeUpdate);
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {
		R.Update(g, deltaTimeUpdate);
		g.drawString(String.valueOf(Gold), 50, 150);
	}
	
	
	
	
	
	
	
	private void MakeBackground() {
		game.EA.createProp(0, 0, "Sky", ObjectStates.PROP_NULL);
		game.EA.createProp(900, 50, "Moon", ObjectStates.PROP_NIGHT);
		game.EA.createProp(500, 150, "Cloud1", ObjectStates.PROP_EVENING);
		game.EA.createProp(100, 150, "Cloud2", ObjectStates.PROP_EVENING);
		game.EA.createProp(900, 50, "Moon", ObjectStates.PROP_NIGHT);
	//	game.EA.createProp(580, 456, "Lava", ObjectStates.PROP_DAY);
	//	game.EA.createProp(600, 400, "LavaTop", ObjectStates.PROP_DAY);
		game.EA.createProp(0, 0, "Foreground", ObjectStates.PROP_DAY);
		//game.EA.createProp(1, 4, "Sun", ObjectStates.PROP_NULL);
		
		//game.EA.createProp(-3, 290, "GoodCastle", ObjectStates.BUILDING_MAXLIFE);
		//game.EA.createProp(1115, 295, "EvilCastle", ObjectStates.BUILDING_MAXLIFE);
		
		game.EA.createProp(30, 140, "GoldCoin", ObjectStates.PROP_NULL);
		
	}
	
	private void MakeUI() {
		
		game.EA.createRectangleUI(550, 600, 32, 32, "FillerUI", UIBehaviours.SPAWN_0);
		game.EA.createRectangleUI(650, 600, 32, 32, "WolfCard", UIBehaviours.SPAWN_1);
	}
	
	public int Gold(int amount) {
		return(this.Gold = this.Gold + amount);
	}
}
