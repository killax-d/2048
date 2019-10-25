package fr.killax.pane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.killax.component.Grid;
import fr.killax.component.Tile;
import fr.killax.config.ControlSettings;
import fr.killax.core.App;
import fr.killax.core.Gui;

public class Game extends Gui implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	private Grid grid;
	private ControlSettings controlSettings;
	
	public Game() {
		super();
		controlSettings = App.getInstance().getSettings().getGameSettings().getControlSettings();
		grid = new Grid(0, 0, 512, 512, 4, 4);
		for (int y = 0; y < grid.height(); y++) {
			for (int x = 0; x < grid.width(); x++) {
				grid.pushToCell(new Tile(), x, y);
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		grid.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (event.getKeyCode() == controlSettings.getKeyControl("up"))
			System.out.println("up");
		if (event.getKeyCode() == controlSettings.getKeyControl("down"))
			System.out.println("down");
		if (event.getKeyCode() == controlSettings.getKeyControl("left"))
			System.out.println("left");
		if (event.getKeyCode() == controlSettings.getKeyControl("right"))
			System.out.println("right");
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
	}
	
}
