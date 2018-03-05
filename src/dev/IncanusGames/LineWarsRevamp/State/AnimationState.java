package dev.IncanusGames.LineWarsRevamp.State;

import java.awt.Graphics;

import dev.IncanusGames.LineWarsRevamp.Game;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.MovieStates;

public class AnimationState extends State{
	private int framesInState;
	public AnimationState(Game game, MovieStates m, int framesInState) {
		super(game);
		this.framesInState = framesInState;
		switch(m){
			
		}
	}

	@Override
	public void tick(double deltaTimeUpdate) {
		
	}

	@Override
	public void render(Graphics g, double deltaTimeUpdate) {
		
	}

}
