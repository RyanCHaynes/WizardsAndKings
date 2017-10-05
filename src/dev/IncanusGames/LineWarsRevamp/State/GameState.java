package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.Component.Behavior;
import dev.IncanusGames.LineWarsRevamp.Component.Health;
import dev.IncanusGames.LineWarsRevamp.Component.Movement;
import dev.IncanusGames.LineWarsRevamp.Component.Position;
import dev.IncanusGames.LineWarsRevamp.Component.Renderable;
import dev.IncanusGames.LineWarsRevamp.Component.Vector2d;
import dev.IncanusGames.LineWarsRevamp.Component.Vision;
import dev.IncanusGames.LineWarsRevamp.System.BehaviorSystem;
import dev.IncanusGames.LineWarsRevamp.System.MovementSystem;
import dev.IncanusGames.LineWarsRevamp.System.RenderSystem;
import dev.IncanusGames.LineWarsRevamp.System.VisionSystem;

public class GameState extends State{
	private int background, spawner, skeleton, skeletonb;
	private RenderSystem R;
	private MovementSystem M;
	private BehaviorSystem B;
	private VisionSystem V;
	public GameState(Game game) {
		super(game);
		background = game.entityManager.generateNewEntityID();
		spawner = game.entityManager.generateNewEntityID();
		skeleton = game.entityManager.generateNewEntityID();
		skeletonb = game.entityManager.generateNewEntityID();
		game.entityManager.addComponent(background, new Position(0,0));
		game.entityManager.addComponent(background, new Renderable());
		game.entityManager.addComponent(spawner, new Position(20,20));
		
		game.entityManager.addComponent(skeleton, new Position(1191,663));
		game.entityManager.addComponent(skeleton, new Health());
		game.entityManager.addComponent(skeleton, new Vision());
		game.entityManager.addComponent(skeleton, new Renderable());
		game.entityManager.addComponent(skeleton, new Movement());
		game.entityManager.addComponent(skeleton, new Vector2d(-2,0));
		game.entityManager.addComponent(skeleton, new Behavior("skeleton"));
		
		game.entityManager.addComponent(skeletonb, new Position(0,663));
		game.entityManager.addComponent(skeletonb, new Health());
		game.entityManager.addComponent(skeletonb, new Vision());
		game.entityManager.addComponent(skeletonb, new Renderable());
		game.entityManager.addComponent(skeletonb, new Movement());
		game.entityManager.addComponent(skeletonb, new Vector2d(2,0));
		game.entityManager.addComponent(skeletonb, new Behavior("skeleton"));

		game.entityManager.getComponent(background, Renderable.class).setAnimationName("AlphaBG1");
		game.entityManager.getComponent(background, Renderable.class).setFrame(0);
		//skeleton renderable
		game.entityManager.getComponent(skeleton, Renderable.class).setAnimationName("SkeletalSwordsman");
		game.entityManager.getComponent(skeleton, Health.class).setHP(10);
		game.entityManager.getComponent(skeleton, Renderable.class).setFrame(0);
		game.entityManager.getComponent(skeleton, Vision.class).setRange(10);
		game.entityManager.getComponent(skeleton, Vision.class).setVisible(true);
		
		
		game.entityManager.getComponent(skeletonb, Renderable.class).setAnimationName("SkeletalSwordsman");
		game.entityManager.getComponent(skeletonb, Health.class).setHP(10);
		game.entityManager.getComponent(skeletonb, Renderable.class).setFrame(0);
		game.entityManager.getComponent(skeletonb, Vision.class).setRange(10);
		game.entityManager.getComponent(skeletonb, Vision.class).setFacingForward(true);
		
		R = new RenderSystem(game);
		M = new MovementSystem(game);
		B = new BehaviorSystem(game);
		V= new VisionSystem(game);
	}

	@Override
	public void tick() {
		V.Update();
		B.Update();
		M.Update();
	}

	@Override
	public void render(Graphics g) {
		R.Update(g);
	}

}
