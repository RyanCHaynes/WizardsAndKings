package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.Factions;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.PropTypes;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.System.AnimationSystem;
import dev.IncanusGames.LineWarsRevamp.System.AttackSystem;
import dev.IncanusGames.LineWarsRevamp.System.CollidableSystem;
import dev.IncanusGames.LineWarsRevamp.System.CommandSystem;
import dev.IncanusGames.LineWarsRevamp.System.HealthSystem;
import dev.IncanusGames.LineWarsRevamp.System.InputSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.SensorSystem;
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
	private AttackSystem AtckSys;
	private SensorSystem SenSys;
	private HealthSystem HpSys;
	private int Gold = 100;
	private double StateTime = 0;
	
	public GameState(Game game) {
		super(game);
		this.MakeBackground();
		this.MakeUI();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		HpSys = new HealthSystem(game);
		UBSys = new UIBehaviourSystem(game);
		SenSys = new SensorSystem(game);
		InptSys = new InputSystem(game);
		CmdSys = new CommandSystem(game);
		Asys= new AnimationSystem(game);
		AtckSys = new AttackSystem(game);
		ColideSys = new CollidableSystem(game);
	//	Psys = new PositionSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		
		
		//GameState Data update
		StateTime = StateTime + deltaTimeUpdate;
		if (StateTime > 60) {Gold++; StateTime = 0;} //Gain one gold a second (frame based)
		
		
		//SystemsUpdates
		M.Update(deltaTimeUpdate);
		InptSys.Update(deltaTimeUpdate);
		ColideSys.Update(deltaTimeUpdate);
	//	Psys.Update(deltaTimeUpdate);
		SenSys.Update(deltaTimeUpdate);
		CmdSys.Update(deltaTimeUpdate);
		UBSys.Update(deltaTimeUpdate);
		AtckSys.Update(deltaTimeUpdate);
		HpSys.Update(deltaTimeUpdate);
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {

		Asys.Update(deltaTimeUpdate);
		R.Update(g, deltaTimeUpdate);
		g.drawString(String.valueOf(Gold), 50, 150);
	}
	
	
	
	
	
	
	
	private void MakeBackground() {
		game.EA.createProp(0, 0, "Sky", ObjectStates.PROP_NULL);
		game.EA.createProp(930, 40, "Moon", ObjectStates.PROP_NIGHT);
		game.EA.createMovingProp(500, 120, "Cloud1", 1, Factions.PROPS, PropTypes.CLOUDONE.ordinal(), ObjectStates.PROP_EVENING);
		game.EA.createMovingProp(900, 120, "Cloud3", -1, Factions.PROPS, PropTypes.CLOUDONE.ordinal(), ObjectStates.PROP_EVENING);
		game.EA.createMovingProp(100, 120, "Cloud2", 1, Factions.PROPS, PropTypes.CLOUDONE.ordinal(), ObjectStates.PROP_EVENING);
	//	game.EA.createProp(580, 456, "Lava", ObjectStates.PROP_DAY);
	//	game.EA.createProp(600, 400, "LavaTop", ObjectStates.PROP_DAY);
		game.EA.createProp(0, 0, "Foreground", ObjectStates.PROP_DAY);
		game.EA.createProp(523, 0, "TimeBar", ObjectStates.PROP_NULL);
		//game.EA.createProp(1, 4, "Sun", ObjectStates.PROP_NULL);
		
		//game.EA.createProp(-3, 290, "GoodCastle", ObjectStates.BUILDING_MAXLIFE);
		//game.EA.createProp(1115, 295, "EvilCastle", ObjectStates.BUILDING_MAXLIFE);
		
		game.EA.createProp(30, 140, "GoldCoin", ObjectStates.PROP_NULL);
		
		game.EA.createProp(0, 0, "UI_Corner", ObjectStates.PROP_NULL);
		game.EA.createProp(30, 140, "UI_", ObjectStates.PROP_NULL);
		game.EA.createProp(30, 140, "UI_Corner", ObjectStates.PROP_NULL);
		
	}
	
	private void MakeUI() {
		
		game.EA.createRectangleUI(550, 600, 32, 32, "FillerUI", UIBehaviours.SPAWN_0);
		game.EA.createRectangleUI(650, 600, 32, 32, "WolfCard", UIBehaviours.SPAWN_1);
	}
	
	public int Gold(int amount) {
		return(this.Gold = this.Gold + amount);
	}
}
