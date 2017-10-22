package dev.IncanusGames.LineWarsRevamp;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.GfxAssembler;
import dev.IncanusGames.LineWarsRevamp.AutomatedEntityAssemblers.UnitAssembler;
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
		public EntityManager entityManager;
		public UnitAssembler UA;
		public GfxAssembler GfxA;
		
		
		private static int baseFPS = 60;
		private static double MS_PER_UPDATE = 1000000000/baseFPS;
		
		Game(String t, int w, int h){
			title = t;
			width = w;
			height = h;
		}
		
		private void update(){
			if(State.getState() != null)
				State.getState().tick();
		}
		private void render(double deltaTimeRender){
			bs = display.getCanvas().getBufferStrategy();
			if (bs  == null){
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, width, height);
			
			if(State.getState() != null)
				State.getState().render(g);

			bs.show();
			g.dispose();
		}
		
		private void init(){
			entityManager = new EntityManager();
			SpriteSheetManager.init();
			display = new Display(title, width, height);
			GameState = new GameState(this);
			display.getFrame().addKeyListener(keyManager = new KeyManager());
			display.getCanvas().addMouseListener(mouseManager = new MouseManager());
			display.getCanvas().addMouseMotionListener(mouseManager);
			UA = new UnitAssembler(this);
			GfxA = new GfxAssembler(this);
			
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
					update();
					deltaTime -= MS_PER_UPDATE;
					render(deltaTime/MS_PER_UPDATE);
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
