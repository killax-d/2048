package fr.killax.core;

import java.io.FileReader;

import com.google.gson.Gson;

import fr.killax.config.AppSettings;

public class App {
	
	private AppSettings settings;
	private Window window;
	
	private static App instance;
	
	public App() {
		instance = this;
		
		try {
			setSettings(new Gson().fromJson(new FileReader("settings.json"), AppSettings.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		window = new Window(settings.getWindowSettings().getTitle(),
							settings.getWindowSettings().getWidth(), 
							settings.getWindowSettings().getHeight());
	}
	
	public static App getInstance() {
		return instance;
	}

	public AppSettings getSettings() {
		return settings;
	}

	public void setSettings(AppSettings settings) {
		this.settings = settings;
	}

	public Window getWindow() {
		return window;
	}

}
