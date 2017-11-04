package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Timer;
import dev.IncanusGames.LineWarsRevamp.Component.Collision.RectangleHitbox;
import dev.IncanusGames.LineWarsRevamp.Component.UI.Clickable;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UI;
import dev.IncanusGames.LineWarsRevamp.Component.UI.UIBehaviour;
import dev.IncanusGames.LineWarsRevamp.System.ClickableSystem;
import dev.IncanusGames.LineWarsRevamp.System.CollidableSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.PositionSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.TimerSystem;
import dev.IncanusGames.LineWarsRevamp.System.UIBehaviorSystem;
import dev.IncanusGames.LineWarsRevamp.System.UISystem;
import dev.IncanusGames.LineWarsRevamp.System.UnitCommandSystem;

public class GameState extends State{
	private int Foreground,Sky, Lava,Sun,LavaTop, GoodCastle, EvilCastle, fillerUI;
	private static Position SpawnA = new Position(0, 370);
	private static Position SpawnB = new Position(1315, 370);
	private RenderSystem R;
	private MovementSystem M;
	private ClickableSystem Csys;
	private UISystem UI;
	private UIBehaviorSystem UIb;
	private TimerSystem Tsys;
	private CollidableSystem ColideSys;
	private UnitCommandSystem UCSys;
	private PositionSystem Psys;
	
	
	public GameState(Game game) {
		super(game);
		
		this.MakeBackground();

		R = new RenderSystem(game);
		M = new MovementSystem(game);
		Csys = new ClickableSystem(game);
		UI = new UISystem(game);
		UIb = new UIBehaviorSystem(game);
		Tsys = new TimerSystem(game);
		ColideSys = new CollidableSystem(game);
		UCSys = new UnitCommandSystem(game);
		Psys = new PositionSystem(game);
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		M.Update(deltaTimeUpdate);
		UI.Update();
		Csys.Update();
		UIb.Update();
		Tsys.Update();
		ColideSys.Update();
		UCSys.Update();
		Psys.Update(deltaTimeUpdate);
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
		game.entityManager.addComponent(Sky, new Renderable("Sky", 0, 0, 1,false));
		game.entityManager.addComponent(Foreground, new Position(0,370));
		game.entityManager.addComponent(Foreground, new Renderable("Foreground", 0, 0, 1,false));
		game.entityManager.addComponent(Lava, new Position(580,456));
		game.entityManager.addComponent(Lava, new Renderable("Lava", 0, 0, 1,false));
		game.entityManager.addComponent(LavaTop, new Position(600,400));
		game.entityManager.addComponent(LavaTop, new Renderable("LavaTop", 30, 0, 3,true));
		game.entityManager.addComponent(Sun, new Position(1,4));
		game.entityManager.addComponent(Sun, new Renderable("Sun", 20, 0, 3,true));
		game.entityManager.addComponent(GoodCastle, new Position(-3,290));
		game.entityManager.addComponent(GoodCastle, new Renderable("GoodCastle", 10, 0, 5,true));
		game.entityManager.addComponent(EvilCastle, new Position(1115,295));
		game.entityManager.addComponent(EvilCastle, new Renderable("EvilCastle", 0, 0, 1,false));
		game.entityManager.addComponent(fillerUI, new Position(550,625));
		game.entityManager.addComponent(fillerUI, new Renderable("A01", 0, 0, 1,false));
		game.entityManager.addComponent(fillerUI, new UI());
		game.entityManager.addComponent(fillerUI, new RectangleHitbox(32*2,32*2));
		game.entityManager.addComponent(fillerUI, new Clickable("Rect"));
		game.entityManager.addComponent(fillerUI, new UIBehaviour("spawnKnight"));
		game.entityManager.addComponent(fillerUI, new Timer(120));
		
		
		
		
		
	}

}
