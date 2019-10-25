package fr.killax.config;

public class GameSettings {

	private String theme;
	private ControlSettings controlSettings;

//	public GameSettings() {
//		setTheme("default");
//		controlSettings = new ControlSettings();
//	}
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public ControlSettings getControlSettings() {
		return controlSettings;
	}

	public void setControlSettings(ControlSettings controlSettings) {
		this.controlSettings = controlSettings;
	}

}
