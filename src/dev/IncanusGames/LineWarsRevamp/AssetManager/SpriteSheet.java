package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage sheet;
	private int xPix; //width of frame in pixels
	private int yPix; //height of frame in pixels
	private int frames; //number of frames
	private String filePath; //path to gfx asset
	private int scale;
	
	/** 
	 *@param width, height, filename, frames, scale
	 * 
	 * 
	 * **/
	public SpriteSheet(int width, int height, String filename, int frames, int scale){
		this.yPix = height;
		this.xPix = width;
		this.filePath = filename;
		this.frames = frames;
		this.scale = scale;
	}
	
	public void load(){
		try {
			this.sheet = ImageIO.read(new FileInputStream("res/textures/"+filePath+".png"));
		} catch (IOException e) {
			System.out.print("Failed to load graphical asset from path:");
			System.out.print(filePath);
			e.printStackTrace();
			System.exit(1);
		}
	}
	public BufferedImage frame(int num){
		return sheet.getSubimage((xPix *num),0, xPix, yPix);
	}
	public int getFrameCount(){
		return this.frames;
	}
	public String getFilepath(){
		return this.filePath;
	}
	public BufferedImage getImage(){
		return this.sheet;
	}
	public int xPix(){
		return scale*xPix;
	}
	public int yPix(){
		return scale*yPix;
	}
	public int getScale(){
		return this.scale;
	}
}
