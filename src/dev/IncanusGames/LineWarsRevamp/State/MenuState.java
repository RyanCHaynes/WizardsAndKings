package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.ObjectStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.UIBehaviours;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.System.AnimationSystem;
import dev.IncanusGames.LineWarsRevamp.System.CommandSystem;
import dev.IncanusGames.LineWarsRevamp.System.InputSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.UIBehaviourSystem;

public class MenuState extends State{
	public static Position SpawnA = new Position(180, 510);
	public static Position SpawnB = new Position(1000, 510);
	private RenderSystem R;
	private MovementSystem M;
	private AnimationSystem Asys;
	private InputSystem InptSys;
	private CommandSystem CmdSys;
	private UIBehaviourSystem UBSys;
	//private double StateTime = 0;
	
	public MenuState(Game game) {
		super(game);
		this.MakeBackground();
		this.MakeUI();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		UBSys = new UIBehaviourSystem(game);
		InptSys = new InputSystem(game);
		CmdSys = new CommandSystem(game);
		Asys= new AnimationSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		
		//SystemsUpdates
		M.Update(deltaTimeUpdate);
		InptSys.Update(deltaTimeUpdate);
		CmdSys.Update(deltaTimeUpdate);
		UBSys.Update(deltaTimeUpdate);
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {

		Asys.Update(deltaTimeUpdate);
		R.Update(g, deltaTimeUpdate);
	}
	
	
	
	
	
	
	
	private void MakeBackground() {
	//	game.EA.createProp(30, 140, "GoldCoin", ObjectStates.PROP_NULL);
		game.EA.createProp(0, 0, "Menu_Background", ObjectStates.PROP_NULL);
	}
	
	private void MakeUI() {
		game.EA.createRectangleUI(220, 190, 32*3, 32*3, "Orc_UI", UIBehaviours.USE_0);
	}
}
