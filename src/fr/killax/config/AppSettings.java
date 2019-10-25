package fr.killax.config;

public class AppSettings {

	private WindowSettings windowSettings;
	private GameSettings gameSettings;

//	public AppSettings() {
//		windowSettings = new WindowSettings();
//		gameSettings = new GameSettings();
//	}
	
	public WindowSettings getWindowSettings() {
		return windowSettings;
	}

	public void setWindowSettings(WindowSettings windowSettings) {
		this.windowSettings = windowSettings;
	}

	public GameSettings getGameSettings() {
		return gameSettings;
	}

	public void setGameSettings(GameSettings gameSettings) {
		this.gameSettings = gameSettings;
	}

}
