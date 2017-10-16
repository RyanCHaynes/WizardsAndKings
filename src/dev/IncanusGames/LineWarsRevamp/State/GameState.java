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
	private int Foreground,Sky, Lava,Sun,LavaTop, GoodCastle, EvilCastle, knight1, knight2, knight3, knight4,knight5,knight6,knight7,knight8, knight9;
	private int attackUI;
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
		
		this.MakeBackground();
		
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
	
	
	
	
	
	
	
	private void MakeBackground() {

		Sky = game.entityManager.createEntity();
		Lava = game.entityManager.createEntity();
		LavaTop = game.entityManager.createEntity();
		Sun = game.entityManager.createEntity();
		Foreground = game.entityManager.createEntity();
		GoodCastle = game.entityManager.createEntity();
		EvilCastle = game.entityManager.createEntity();
		knight1 = game.entityManager.createEntity();
		knight2 = game.entityManager.createEntity();
		knight3 = game.entityManager.createEntity();
		knight4 = game.entityManager.createEntity();
		knight5 = game.entityManager.createEntity();
		knight6 = game.entityManager.createEntity();
		knight7 = game.entityManager.createEntity();
		knight8 = game.entityManager.createEntity();
		knight9 = game.entityManager.createEntity();
		attackUI = game.entityManager.createEntity();
		
		game.entityManager.addComponent(Sky, new Position(0,0));
		game.entityManager.addComponent(Sky, new Renderable("Sky", 0, 0, 1));
		game.entityManager.addComponent(Foreground, new Position(0,370));
		game.entityManager.addComponent(Foreground, new Renderable("Foreground", 0, 0, 1));
		game.entityManager.addComponent(Lava, new Position(580,456));
		game.entityManager.addComponent(Lava, new Renderable("Lava", 0, 0, 1));
		game.entityManager.addComponent(LavaTop, new Position(600,400));
		game.entityManager.addComponent(LavaTop, new Renderable("LavaTop", 30, 0, 3));
		game.entityManager.addComponent(Sun, new Position(1,4));
		game.entityManager.addComponent(Sun, new Renderable("Sun", 20, 0, 3));
		game.entityManager.addComponent(GoodCastle, new Position(-3,290));
		game.entityManager.addComponent(GoodCastle, new Renderable("GoodCastle", 10, 0, 5));
		game.entityManager.addComponent(EvilCastle, new Position(1115,295));
		game.entityManager.addComponent(EvilCastle, new Renderable("EvilCastle", 0, 0, 1));
		
		
		
		
		
	}

}
