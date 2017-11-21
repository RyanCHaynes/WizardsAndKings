package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputStates;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputType;

public class Input implements Component{
	
	public Input(InputType inputType){
		this.inputType = inputType;
		inputState = InputStates.NULL;
	}
	
	
	public InputStates getInputState() {
		return inputState;
	}
	public void setInputState(InputStates inputState) {
		this.inputState = inputState;
	}
	public InputType getInputType() {
		return inputType;
	}
	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}
	private InputStates inputState; //its state of input
	private InputType inputType; //its input type
}
