package dev.IncanusGames.LineWarsRevamp;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.IncanusGames.LineWarsRevamp.AssetManager.SpriteSheetManager;
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
		private KeyManager keyManager;
		private MouseManager mouseManager;
		public EntityManager entityManager;
		
		
		Game(String t, int w, int h){
			title = t;
			width = w;
			height = h;
		}
		
		private void tick(){
			if(State.getState() != null)
				State.getState().tick();
		}
		private void render(){
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
			int fps = 60;
			double timePerTick = 1000000000/fps;
			double deltaTime = 0;
			long currentTime;
			long lastTime = System.nanoTime();
			long timer = 0;
			int ticks =0;
			
			while(running){
				currentTime = System.nanoTime();
				deltaTime += (currentTime - lastTime)/timePerTick;
				timer += currentTime - lastTime;
				lastTime = currentTime;
				
				if(deltaTime >= 1){
					tick();
					render();
					ticks++;
					deltaTime--;
				}
			}
			
			
			stop();
		}
		public Graphics getGraphics(){
			return this.g;
		}
		public EntityManager getEntityManager() {
			return this.entityManager;
		}
}
