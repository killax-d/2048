package fr.killax;

import fr.killax.core.App;
import fr.killax.pane.Game;

public class Main {

	public static void main(String[] args) {
		new App();
		
		App.getInstance().getWindow().setCurrentGui(new Game());
	}
}
