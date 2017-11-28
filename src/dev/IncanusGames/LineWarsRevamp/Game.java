package dev.IncanusGames.LineWarsRevamp;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.IncanusGames.LineWarsRevamp.AssetManager.AnimationDataManager;
import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.EntityAssembler;
import dev.IncanusGames.LineWarsRevamp.Display.Display;
import dev.IncanusGames.LineWarsRevamp.EntityManager.EntityManager;
import dev.IncanusGames.LineWarsRevamp.InputManagers.KeyManager;
import dev.IncanusGames.LineWarsRevamp.InputManagers.MouseManager;
import dev.IncanusGames.LineWarsRevamp.State.GameState;
import dev.IncanusGames.LineWarsRevamp.State.State;


public class Game implements Runnable{
		private Display display;
		private Thread thread;
		private boolean running = false;
		private BufferStrategy bs;
		private Graphics g;
		private String title;
		private int width, height;
		private State GameState;
		public KeyManager keyManager;
		public MouseManager mouseManager;
		public EntityManager entityManager = new EntityManager();
		public AnimationDataManager ADH;
		public EntityAssembler EA = new EntityAssembler(this);
		
	
		
		private static int baseFPS = 60;
		private static double MS_PER_UPDATE = 1000000000/baseFPS;
		
		Game(String t, int w, int h){
			title = t;
			width = w;
			height = h;
		}
		
		private void update(double deltaTimeUpdate){
			if(State.getState() != null)
				State.getState().tick(deltaTimeUpdate);
		}
		private void render(double deltaTimeRender){
			bs = display.getCanvas().getBufferStrategy();
			if (bs  == null){
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			g.setColor(Color.red);
			g.clearRect(0, 0, width, height);
			
			if(State.getState() != null)
				State.getState().render(g, deltaTimeRender);

			bs.show();
			g.dispose();
		}
		
		private void init(){
			SpriteSheetManager.init();
			AnimationDataManager.init();
			display = new Display(title, width, height);
			GameState = new GameState(this);
			display.getFrame().addKeyListener(keyManager = new KeyManager());
			display.getCanvas().addMouseListener(mouseManager = new MouseManager());
			display.getCanvas().addMouseMotionListener(mouseManager);
			
			State.setState(GameState);
		}
		
		public synchronized void start(){
			if (running) return;
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
		private void stop(){
			if(!running) return;
			running = false;
			try {
				thread.join();
			} catch(InterruptedException e) {
				
			}
		}
		public void run() {
			init();
			double previousTime = System.nanoTime();
			double deltaTime = 0;
			while (true) {
				double currentTime = System.nanoTime();
				double elapsedTime = currentTime - previousTime;
				previousTime = currentTime;
				deltaTime += elapsedTime;
				while (deltaTime >= MS_PER_UPDATE) {
					update(deltaTime/MS_PER_UPDATE); //passing in a scalar for logic normalization across processing speeds
					render(deltaTime/MS_PER_UPDATE); //passing in a scalar for rendering
					deltaTime -= MS_PER_UPDATE;
				}
				//render(deltaTime/MS_PER_UPDATE);
				//render(deltaTime/MS_PER_UPDATE);//passing in (deltaTime / MS_PER_UPDATE) for smooth rendering
			}
		}
		public Graphics getGraphics(){
			return this.g;
		}
		public EntityManager getEntityManager() {
			return this.entityManager;
		}
}
