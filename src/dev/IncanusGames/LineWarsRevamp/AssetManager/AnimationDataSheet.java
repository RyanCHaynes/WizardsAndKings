package dev.IncanusGames.LineWarsRevamp.AssetManager;

import java.util.HashMap;

/*
 * This class holds the static data for each individual animation such as Total frame count, Frames displayed per second, animation key(to sprite sheet map)
 *  and if the animation loops. The hash map stored here is State based in which is a component of entities. 
 *  "Attack" State-> "Attack" Animation" 
 */



public class AnimationDataSheet{
		private int maxFrame, xWidth, yWidth, loopFrame;
		private float framesPerSecond;
		private String animationName;
		private boolean loop;
		
		public void setData(int frames, int xWidth, int yWidth, float framesPerSecond, String animationNAme, boolean loop, int loopFrame) {
			this.maxFrame = frames;
			this.xWidth = xWidth;
			this.yWidth = yWidth;
			this.framesPerSecond = framesPerSecond;
			this.animationName = animationNAme;
			this.loop = loop;
			this.loopFrame =loopFrame;
		}
		
		public int getMaxFrame() {
			return maxFrame;
		}
		public float getframesPerSecond() {
			return framesPerSecond;
		}
		public String getAnimationName() {
			return animationName;
		}
		public boolean isLoop() {
			return loop;
		}
		public int getyWidth() {
			return yWidth;
		}

		public int getxWidth() {
			return xWidth;
		}
		public int getLoopFrame() {
			return loopFrame;
		}

}
	
