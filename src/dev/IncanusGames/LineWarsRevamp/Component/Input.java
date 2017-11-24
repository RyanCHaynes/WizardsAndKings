package dev.IncanusGames.LineWarsRevamp.Component;

import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputState;
import dev.IncanusGames.LineWarsRevamp.AssetManager.EnumTypes.InputType;

public class Input implements Component{
	
	public Input(InputType i){
		inputType = i;
		inputState = InputState.NULL;
	}
	
	public InputType getInputType() {
		return inputType;
	}

	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}

	public InputState getInputState() {
		return inputState;
	}

	public void setInputState(InputState inputState) {
		this.inputState = inputState;
	}

	private InputType inputType;
	private InputState inputState;
}
