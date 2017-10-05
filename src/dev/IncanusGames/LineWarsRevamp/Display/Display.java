package dev.IncanusGames.LineWarsRevamp.Display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	private int width, height;
	private String title;
	private Dimension d;
	
	public Display(String t, int w, int h){
		title = t;
		width = w;
		height = h;
		init();
	}
	
	private void init(){
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
