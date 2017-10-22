package dev.IncanusGames.LineWarsRevamp.InputManagers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import javafx.scene.input.MouseButton;

public class MouseManager implements MouseListener, MouseMotionListener{
	public Point position;
	public boolean pressed;
	public boolean leftClick, rightClick;
	
	public void tick(){
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		position = arg0.getPoint();
		if(SwingUtilities.isRightMouseButton(arg0)) {
			rightClick = true;
			System.out.println("eyy R");
		} else if(SwingUtilities.isLeftMouseButton(arg0)) {
			leftClick = true;
			System.out.println("eyy L");
		}
		System.out.println("Mouse pressed @ "+position);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		pressed = false;
		rightClick = false;
		leftClick = false;
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		position = arg0.getPoint();
		System.out.println("Mouse Dragged @ "+position);
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		position = arg0.getPoint();
	}

}