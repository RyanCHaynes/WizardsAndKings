package dev.IncanusGames.LineWarsRevamp.Component;

public class ClassType implements Component{
	private String classType;

	public ClassType(String classType) {
		this.classType = classType;
	}
	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}
}
