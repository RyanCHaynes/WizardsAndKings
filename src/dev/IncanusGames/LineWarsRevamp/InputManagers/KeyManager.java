package dev.IncanusGames.LineWarsRevamp.InputManagers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class KeyManager implements KeyListener{
	private boolean[] keys;
	public static boolean up, down, left, right, space;
	
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
	}
	
	@Override
	public void keyPressed(KeyEvent k) {
		keys[k.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		keys[k.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}