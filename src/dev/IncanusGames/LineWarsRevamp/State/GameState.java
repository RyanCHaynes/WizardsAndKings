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
	private int Foreground,Sky, Lava,Sun,LavaTop, GoodCastle;
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
		Sky = game.entityManager.createEntity();
		Lava = game.entityManager.createEntity();
		LavaTop = game.entityManager.createEntity();
		Sun = game.entityManager.createEntity();
		Foreground = game.entityManager.createEntity();
		GoodCastle = game.entityManager.createEntity();
		//game.entityManager.addComponent(background, new Position(0,0));
		//game.entityManager.addComponent(background, new Renderable("AlphaBG1", 0, 0, 1));
		game.entityManager.addComponent(Sky, new Position(0,0));
		game.entityManager.addComponent(Sky, new Renderable("Sky", 0, 0, 1));
		game.entityManager.addComponent(Foreground, new Position(0,395));
		game.entityManager.addComponent(Foreground, new Renderable("Foreground", 0, 0, 1));
		game.entityManager.addComponent(Lava, new Position(580,466));
		game.entityManager.addComponent(Lava, new Renderable("Lava", 0, 0, 1));
		game.entityManager.addComponent(LavaTop, new Position(600,430));
		game.entityManager.addComponent(LavaTop, new Renderable("LavaTop", 30, 0, 3));
		game.entityManager.addComponent(Sun, new Position(1,4));
		game.entityManager.addComponent(Sun, new Renderable("Sun", 20, 0, 3));
		game.entityManager.addComponent(GoodCastle, new Position(-5,325));
		game.entityManager.addComponent(GoodCastle, new Renderable("GoodCastle", 10, 0, 5));
		
		//UA.createSkeletonSM(SpawnA.getX(), SpawnA.getY(), true);
		//UA.createSkeletonSM(SpawnB.getX(), SpawnB.getY(), false);
		
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
