package fr.killax.ressources;

import fr.killax.core.App;

public class ThemeLoader {
	
	public static void load(String theme_name) {
		App.getInstance().getSettings().getGameSettings().setTheme(theme_name);
	}
	
}
