package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.GfxAssembler;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.UnitAssembler;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.System.AttackSystem;
import dev.IncanusGames.LineWarsRevamp.System.BehaviorSystem;
import dev.IncanusGames.LineWarsRevamp.System.DeathSystem;
import dev.IncanusGames.LineWarsRevamp.System.HealthSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.VisionSystem;

public class GameState extends State{
	private int background;
	private static Position SpawnA = new Position(0, 370);
	private static Position SpawnB = new Position(1315, 370);
	private UnitAssembler UA;
	private GfxAssembler GfxA;
	private RenderSystem R;
	private MovementSystem M;
	private BehaviorSystem B;
	private VisionSystem V;
	private AttackSystem Asys;
	private DeathSystem Dsys;
	private HealthSystem Hsys;
	
	
	public GameState(Game game) {
		super(game);
		UA = new UnitAssembler(game);
		GfxA = new GfxAssembler(game);
		Asys = new AttackSystem(game);
		background = game.entityManager.createEntity();
		
		
		game.entityManager.addComponent(background, new Position(0,0));
		game.entityManager.addComponent(background, new Renderable("AlphaBG1", 0, 0, 1));

		UA.createSkeletonSM(SpawnA.getX(), SpawnA.getY(), true);
		UA.createSkeletonSM(SpawnB.getX(), SpawnB.getY(), false);
		
		R = new RenderSystem(game);
		M = new MovementSystem(game);
		B = new BehaviorSystem(game);
		V= new VisionSystem(game);
		Dsys = new DeathSystem(game);
		Hsys = new HealthSystem(game);
		Asys = new AttackSystem(game);
	}

	@Override
	public void tick() {
		V.Update();
		M.Update();
		Asys.Update();
		Dsys.Update();
		Hsys.Update();
		B.Update();
	}

	@Override
	public void render(Graphics g) {
		R.Update(g);
	}

}
