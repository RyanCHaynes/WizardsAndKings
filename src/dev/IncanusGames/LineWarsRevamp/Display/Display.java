package dev.IncanusGames.LineWarsRevamp.Display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.IncanusGames.LineWarsRevamp.Game;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	private int width, height;
	private String title;
	private Dimension d;
	
	public Display(String t, int w, int h, Game g){
		title = t;
		width = w;
		height = h;
		init(g);
	}
	
	private void init(Game g){
		frame = new JFrame(title);
		frame.setSize(d = new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setMaximumSize(d);
		frame.setResizable(false);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		
		frame.add(canvas);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	public JFrame getFrame(){
		return frame;
	}
	
}
