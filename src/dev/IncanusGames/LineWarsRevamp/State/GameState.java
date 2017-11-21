package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.ClassType;
import dev.IncanusGames.LineWarsRevamp.Component.ObjectState;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.GFX.Animation;
import dev.IncanusGames.LineWarsRevamp.System.AnimationSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.PositionSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;

public class GameState extends State{
	private int Foreground,Sky, Lava,Sun,LavaTop, GoodCastle, EvilCastle, fillerUI;
	private static Position SpawnA = new Position(0, 370);
	private static Position SpawnB = new Position(1315, 370);
	private RenderSystem R;
	private MovementSystem M;
	private PositionSystem Psys;
	private AnimationSystem Asys;
	
	
	public GameState(Game game) {
		super(game);
		
		this.MakeBackground();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		Psys = new PositionSystem(game);
		Asys= new AnimationSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		M.Update(deltaTimeUpdate);
		Psys.Update(deltaTimeUpdate);
		Asys.Update(deltaTimeUpdate);
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {
		R.Update(g, deltaTimeUpdate);
	}
	
	
	
	
	
	
	
	private void MakeBackground() {

		Sky = game.entityManager.createEntity();
		Lava = game.entityManager.createEntity();
		LavaTop = game.entityManager.createEntity();
		Sun = game.entityManager.createEntity();
		Foreground = game.entityManager.createEntity();
		GoodCastle = game.entityManager.createEntity();
		EvilCastle = game.entityManager.createEntity();
		fillerUI = game.entityManager.createEntity();
		
		game.entityManager.addComponent(Sky, new Position(0,0));
		game.entityManager.addComponent(Sky, new Renderable());
		game.entityManager.addComponent(Sky, new ClassType("Sky"));
		game.entityManager.addComponent(Sky, new ObjectState("DayTime"));
		game.entityManager.addComponent(Sky, new Animation());
		
		game.entityManager.addComponent(Foreground, new Position(0,370));
		game.entityManager.addComponent(Foreground, new Renderable());
		game.entityManager.addComponent(Foreground, new ClassType("Foreground"));
		game.entityManager.addComponent(Foreground, new ObjectState("DayTime"));
		game.entityManager.addComponent(Foreground, new Animation());
		
		game.entityManager.addComponent(Lava, new Position(580,456));
		game.entityManager.addComponent(Lava, new Renderable());
		game.entityManager.addComponent(Lava, new ClassType("Lava"));
		game.entityManager.addComponent(Lava, new ObjectState("DayTime"));
		game.entityManager.addComponent(Lava, new Animation());
		
		game.entityManager.addComponent(LavaTop, new Position(600,400));
		game.entityManager.addComponent(LavaTop, new Renderable());
		game.entityManager.addComponent(LavaTop, new ClassType("LavaTop"));
		game.entityManager.addComponent(LavaTop, new ObjectState("DayTime"));
		game.entityManager.addComponent(LavaTop, new Animation());
		
		game.entityManager.addComponent(Sun, new Position(1,4));
		game.entityManager.addComponent(Sun, new Renderable());
		game.entityManager.addComponent(Sun, new ClassType("Sun"));
		game.entityManager.addComponent(Sun, new ObjectState("Normal"));
		game.entityManager.addComponent(Sun, new Animation());
		
		game.entityManager.addComponent(GoodCastle, new Position(-3,290));
		game.entityManager.addComponent(GoodCastle, new Renderable());
		game.entityManager.addComponent(GoodCastle, new ClassType("GoodCastle"));
		game.entityManager.addComponent(GoodCastle, new ObjectState("MaxLife"));
		game.entityManager.addComponent(GoodCastle, new Animation());
		
		game.entityManager.addComponent(EvilCastle, new Position(1115,295));
		game.entityManager.addComponent(EvilCastle, new Renderable());
		game.entityManager.addComponent(EvilCastle, new ClassType("EvilCastle"));
		game.entityManager.addComponent(EvilCastle, new ObjectState("MaxLife"));
		game.entityManager.addComponent(EvilCastle, new Animation());
		
		game.entityManager.addComponent(fillerUI, new Position(550,625));
		game.entityManager.addComponent(fillerUI, new Renderable());
		game.entityManager.addComponent(fillerUI, new RectangleHitbox(32*2,32*2));
		game.entityManager.addComponent(fillerUI, new ClassType("FillerUI"));
		game.entityManager.addComponent(fillerUI, new ObjectState("Unpressed"));
		game.entityManager.addComponent(fillerUI, new Animation());
		
		
		
		
		
	}

}
