package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	public static HashMap<String, ArrayList<BufferedImage>> AntiAnimationMap = new HashMap<String, ArrayList<BufferedImage>>(); //stores left facing images
	public static void init(){
		
		initGood();
		initEvil();
		initBackgroud_Beta();
		initUI_Beta();
		loadSpriteSheets();
		loadAnimationMap();
		loadAntiAnimationMap();
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
		
		
		
		//Foreground
		SpriteSheets.add(new SpriteSheet(416,234,"foreground_final",1,3));
		SpriteSheets.add(new SpriteSheet(159/3,32,"LavaTop_DayTime",3,4));
		SpriteSheets.add(new SpriteSheet(51,78,"Lava_DayTime",1,4));
		
		
		
		
		//Background
		SpriteSheets.add(new SpriteSheet(84, 52, "moon", 1, 1));
		SpriteSheets.add(new SpriteSheet(132/3, 34, "Sun_Normal", 3, 3));
		
		SpriteSheets.add(new SpriteSheet(122, 33, "cloud morning 1", 1, 1));
		SpriteSheets.add(new SpriteSheet(89, 34, "cloud morning 2", 1, 1));
		SpriteSheets.add(new SpriteSheet(128, 40, "cloud morning 3", 1, 1));
		
		SpriteSheets.add(new SpriteSheet(122, 33, "cloud night 1", 1, 1));
		SpriteSheets.add(new SpriteSheet(95, 34, "cloud night 2", 1, 1));
		SpriteSheets.add(new SpriteSheet(128, 40, "cloud night 3", 1, 1));
		
		SpriteSheets.add(new SpriteSheet(122, 33, "cloud day 1", 1, 1));
		SpriteSheets.add(new SpriteSheet(95, 34, "cloud day 2", 1, 1));
		SpriteSheets.add(new SpriteSheet(128, 40, "cloud day 3", 1, 1));
		
		SpriteSheets.add(new SpriteSheet(612, 161, "sky morning", 1, 3));
		SpriteSheets.add(new SpriteSheet(612, 161, "sky night", 1, 3));
		SpriteSheets.add(new SpriteSheet(612, 161, "sky normal", 1, 2));
		SpriteSheets.add(new SpriteSheet(416, 164, "sky_final", 1, 3));
		
		SpriteSheets.add(new SpriteSheet(250/10, 16, "BirdProp", 10, 1));
	}
	private static void initUI_Beta() {
		SpriteSheets.add(new SpriteSheet(225, 30, "TimeBar", 1, 1));
		SpriteSheets.add(new SpriteSheet(136/8, 15, "GoldCoin", 8, 1));
		SpriteSheets.add(new SpriteSheet(32, 32, "FillerUI_Pressed",1,1));
		SpriteSheets.add(new SpriteSheet(32, 32, "FillerUI_Unpressed",1,1));
		SpriteSheets.add(new SpriteSheet(32, 32, "WolfCardPressed",1,1));
		SpriteSheets.add(new SpriteSheet(32, 32, "WolfCardUnpressed",1,1));
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
	
	private static void loadAntiAnimationMap(){
		Image image;
		BufferedImage xfer;
		for(SpriteSheet x: SpriteSheets)
		{
			AntiAnimationMap.put(x.getFilepath(), new ArrayList<BufferedImage>()); //Map associates filepath with animation name
			for (int i = 0; i<x.getFrameCount(); i++)
			{
				if(x.getScale() != 1){
					image = x.frame(i).getScaledInstance(x.xPix(), x.yPix(), 0);
					xfer = convertToBufferedImage(image);
					xfer = flipImage(xfer);
					AntiAnimationMap.get(x.getFilepath()).add(xfer);
				}else {
					image = x.frame(i).getScaledInstance(x.xPix(), x.yPix(), 0);
					xfer = convertToBufferedImage(image);
					xfer = flipImage(xfer);
					AntiAnimationMap.get(x.getFilepath()).add(xfer);
				}
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
	
	private static BufferedImage flipImage(BufferedImage image) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null),0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return op.filter(image, null);
	}
}
