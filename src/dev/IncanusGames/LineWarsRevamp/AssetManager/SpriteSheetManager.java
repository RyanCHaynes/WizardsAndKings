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
		SpriteSheets.add(new SpriteSheet(410/10,32,"mountedKnight_Stand",10,1));
		
		SpriteSheets.add(new SpriteSheet(410/10,32,"footKnight_Move",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"footKnight_Stand",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"footKnight_Attack",10,1));
		
		SpriteSheets.add(new SpriteSheet(410/10,32,"GoodCastle_MaxLife",10,1));
		
	}
	private static void initEvil() {
		SpriteSheets.add(new SpriteSheet(410/10,32,"EvilCastle_MaxLife",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"EvilCastle_Mouth",10,1));
		
		SpriteSheets.add(new SpriteSheet(410/10,32,"Wolf_Move",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"Wolf_Stand",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"Wolf_Attack",10,1));
	}
	private static void initBackgroud_Beta() {
		SpriteSheets.add(new SpriteSheet(410/10,32,"Sun_Normal",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"Sky_DayTime",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"ForeGround_DayTime",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"LavaTop_DayTime",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"Lava_DayTime",10,1));
	}
	private static void initUI_Beta() {
		SpriteSheets.add(new SpriteSheet(410/10,32,"FillerUI_Unpressed",10,1));
		SpriteSheets.add(new SpriteSheet(410/10,32,"FillerUI_Pressed",10,1));
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
