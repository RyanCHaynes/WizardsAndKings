package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * This class stores the data of all of the games images in a hash map that maps the animation names to buffered image arrays
 * These buffered image arrays are created by splicing sprite sheets into their individual frames
 */
public class SpriteSheetManager {
	private static ArrayList<SpriteSheet> SpriteSheets = new ArrayList<SpriteSheet>();
	public static HashMap<String, ArrayList<BufferedImage>> AnimationMap = new HashMap<String, ArrayList<BufferedImage>>(); //stores all animation via hashMap, animate objects will refer to this in their render methods by looking up a string and frame
	public static void init(){
		
		initGood();
		initEvil();
		initBackgroud_Beta();
		initUI_Beta();
		loadSpriteSheets();
		loadAnimationMap();
	}
	
	private static void initGood() {
		SpriteSheets.add(new SpriteSheet(410/10,32,"mountedKnight_Move",10,1));
		SpriteSheets.add(new SpriteSheet(152/4,31,"mountedKnight_Stand",4,1));
		
		SpriteSheets.add(new SpriteSheet(64/4,24,"footKnight_Move",4,1));
		SpriteSheets.add(new SpriteSheet(128/4,23,"footKnight_Stand",4,1));
		//SpriteSheets.add(new SpriteSheet(410/10,32,"footKnight_Attack",10,1));
		
		SpriteSheets.add(new SpriteSheet(390/5,94,"GoodCastle_MaxLife",5,3));
		
	}
	private static void initEvil() {
		SpriteSheets.add(new SpriteSheet(81/1,89,"EvilCastle_MaxLife",1,3));
		SpriteSheets.add(new SpriteSheet(50/1,45,"EvilCastle_Mouth",1,1));
		
		SpriteSheets.add(new SpriteSheet(224/7,18,"Wolf_Move",7,1));
		SpriteSheets.add(new SpriteSheet(56/2,18,"Wolf_Stand",2,1));
		SpriteSheets.add(new SpriteSheet(168/6,18,"Wolf_Attack",6,1));
	}
	private static void initBackgroud_Beta() {
		SpriteSheets.add(new SpriteSheet(132/3,34,"Sun_Normal",3,4));
		SpriteSheets.add(new SpriteSheet(310/1,106,"Sky_DayTime",1,5));
		SpriteSheets.add(new SpriteSheet(455/1,105,"ForeGround_DayTime",1,3));
		SpriteSheets.add(new SpriteSheet(159/3,32,"LavaTop_DayTime",3,4));
		SpriteSheets.add(new SpriteSheet(51/1,78,"Lava_DayTime",1,4));
	}
	private static void initUI_Beta() {
		SpriteSheets.add(new SpriteSheet(32/1,32,"FillerUI_Unpressed",1,2));
		SpriteSheets.add(new SpriteSheet(32/1,32,"FillerUI_Pressed",1,1));
	}
	
	private static void loadSpriteSheets() //uploading all graphical assets into the arrayList
	{
		for(SpriteSheet x : SpriteSheets){
			x.load();
		}
	}
	
	private static void loadAnimationMap(){
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
	
	private static BufferedImage convertToBufferedImage(Image image)
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
