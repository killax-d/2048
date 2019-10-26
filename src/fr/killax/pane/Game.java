package fr.killax.pane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.killax.component.Grid2048;
import fr.killax.component.Tile;
import fr.killax.core.App;
import fr.killax.core.Gui;

public class Game extends Gui implements KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private Grid2048 grid;
	
	public Game() {
		super();
		grid = new Grid2048(0, 0, 512, 512, 4, 4);
		for (int y = 0; y < grid.height(); y++) {
			for (int x = 0; x < grid.width(); x++) {
				grid.pushToCell(new Tile(), x, y);
			}
		}
		
		grid.sendControl(App.getInstance().getSettings().getGameSettings().getControlSettings());
	}

	@Override
	public void paint(Graphics g) {
		grid.draw(g);
	}

	
	/**
	 * Event Keyboard + Mouse
	 */
	
	@Override
	public void keyTyped(KeyEvent event) {}

	@Override
	public void keyPressed(KeyEvent event) {}

	@Override
	public void keyReleased(KeyEvent event) {
		grid.keyReleased(event);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		grid.mousePressed(event);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		grid.mouseReleased(event);
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		
	}
	
	
}
