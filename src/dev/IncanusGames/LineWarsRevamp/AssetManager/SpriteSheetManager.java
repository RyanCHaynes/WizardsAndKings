package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;


public class SpriteSheetManager {
	private static ArrayList<SpriteSheet> SpriteSheets = new ArrayList<SpriteSheet>();
	public static HashMap<String, ArrayList<BufferedImage>> AnimationMap = new HashMap<String, ArrayList<BufferedImage>>(); //stores all animation via hashMap, animate objects will refer to this in their render methods by looking up a string and frame
	public static void init(){
		SpriteSheets.add(new SpriteSheet(263,142,"AlphaBG1",1,5));
		SpriteSheets.add(new SpriteSheet(32,32,"SkeletalSwordsman",1,3));
		SpriteSheets.add(new SpriteSheet(32,32,"SlashAnim",4,3));
		SpriteSheets.add(new SpriteSheet(44,34,"Sun",3,4));
		SpriteSheets.add(new SpriteSheet(310,106,"Sky",1,5));
		SpriteSheets.add(new SpriteSheet(455,105,"Foreground",1,3));
		SpriteSheets.add(new SpriteSheet(53,32,"LavaTop",3,4));
		SpriteSheets.add(new SpriteSheet(51,78,"Lava",1,4));
		SpriteSheets.add(new SpriteSheet(78,94,"GoodCastle",5,3));
		SpriteSheets.add(new SpriteSheet(81,89,"EvilCastle",1,3));
		SpriteSheets.add(new SpriteSheet(17,24,"KnightStand",4,1));
		SpriteSheets.add(new SpriteSheet(20,20,"attackUI",2,7));
		SpriteSheets.add(new SpriteSheet(128,40,"FillerUI",1,2));
		SpriteSheets.add(new SpriteSheet(32,32,"A01",1,2));
		loadSpriteSheets();
		loadAnimationMap();
	}
	
	public static void loadSpriteSheets() //uploading all graphical assets into the arrayList
	{
		for(SpriteSheet x : SpriteSheets){
			x.load();
		}
	}
	
	public static void loadAnimationMap(){
		Image image;
		BufferedImage xfer;
		for(SpriteSheet x: SpriteSheets)
		{
			AnimationMap.put(x.getFilepath(), new ArrayList<BufferedImage>()); //Map associates filepath with animation name
			for (int i = 0; i<x.getFrameCount(); i++)
			{
				if(x.getScale() != 1){
					image = x.frame(i).getScaledInstance(x.xPix(), x.yPix(), 0);
					xfer = convertToBufferedImage(image);
					AnimationMap.get(x.getFilepath()).add(xfer);
				}else AnimationMap.get(x.getFilepath()).add(x.frame(i));
				System.out.println(i);
			}
		}
	}
	
	public static BufferedImage convertToBufferedImage(Image image)
	{
	    BufferedImage newImage = new BufferedImage(
	        image.getWidth(null), image.getHeight(null),
	        BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = newImage.createGraphics();
	    g.drawImage(image, 0, 0, null);
	    g.dispose();
	    return newImage;
	}
}
