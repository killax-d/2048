package fr.killax.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import fr.killax.config.ControlSettings;

public class Grid2048 extends Grid implements KeyListener, MouseListener {

	public static enum Direction {
		LEFT, UP, RIGHT, DOWN
	}

	public Grid2048(int x, int y, int width, int height, int x_cell, int y_cell) {
		super(x, y, width, height, x_cell, y_cell);
	}

	public GridCell[][] getGrid() {
		return grid;
	}

	public void move(Direction direction) {
		switch (direction) {
		case LEFT:
			for (int y = 0; y < height(); y++) {
				for (int x = 0; x < width(); x++) {
					for (int offset_x = 0; offset_x < width(); offset_x++) {
						if (x < offset_x) {
							if (match(grid[y][x], grid[y][offset_x]))
								fusion(grid[y][x], grid[y][offset_x]);
							if (grid[y][x].getComponent() == null && grid[y][offset_x].getComponent() != null) {
								grid[y][x].setComponent(grid[y][offset_x].getComponent());
								grid[y][offset_x].setComponent(null);
							}
						}
					}
				}
			}
			break;
		case UP:
			for (int y = 0; y < height(); y++) {
				for (int x = 0; x < width(); x++) {
					for (int offset_y = 0; offset_y < height(); offset_y++) {
						if (y < offset_y) {
							if (match(grid[y][x], grid[offset_y][x]))
								fusion(grid[y][x], grid[offset_y][x]);
							if (grid[y][x].getComponent() == null && grid[offset_y][x].getComponent() != null) {
								grid[y][x].setComponent(grid[offset_y][x].getComponent());
								grid[offset_y][x].setComponent(null);
							}
						}
					}
				}
			}
			break;
		case RIGHT:
			for (int y = 0; y < height(); y++) {
				for (int x = 0; x < width(); x++) {
					for (int offset_x = 0; offset_x < width(); offset_x++) {
						if (x > offset_x) {
							if (match(grid[y][x], grid[y][offset_x]))
								fusion(grid[y][x], grid[y][offset_x]);
							if (grid[y][x].getComponent() == null && grid[y][offset_x].getComponent() != null) {
								grid[y][x].setComponent(grid[y][offset_x].getComponent());
								grid[y][offset_x].setComponent(null);
							}
						}
					}
				}
			}
			break;
		case DOWN:
			for (int y = 0; y < height(); y++) {
				for (int x = 0; x < width(); x++) {
					for (int offset_y = 0; offset_y < height(); offset_y++) {
						if (y > offset_y) {
							if (match(grid[y][x], grid[offset_y][x]))
								fusion(grid[y][x], grid[offset_y][x]);
							if (grid[y][x].getComponent() == null && grid[offset_y][x].getComponent() != null) {
								grid[y][x].setComponent(grid[offset_y][x].getComponent());
								grid[offset_y][x].setComponent(null);
							}
						}
					}
				}
			}
			break;
		}
		randomIntoFreeCell();
	}

	public boolean hasFreeCell() {
		for (int y = 0; y < height(); y++) {
			for (int x = 0; x < width(); x++) {
				if (!isValidTile(grid[y][x]))
					return true;
			}
		}
		return false;
	}

	public void randomIntoFreeCell() {
		if (!hasFreeCell())
			return;
		Random random = new Random();
		boolean pushed = false;
		while (!pushed) {
			int y = random.nextInt(height());
			int x = random.nextInt(height());
			if (!isValidTile(grid[y][x])) {
				pushToCell(new Tile(), x, y);
				pushed = true;
			}
		}
	}

	public boolean isValidTile(GridCell cell) {
		if (cell == null || cell.getComponent() == null || !(cell.getComponent() instanceof Tile))
			return false;
		return true;
	}

	public boolean match(GridCell a, GridCell b) {
		if (!isValidTile(a) || !isValidTile(b))
			return false;
		return ((Tile) a.getComponent()).getPower() == ((Tile) b.getComponent()).getPower();
	}

	public void fusion(GridCell a, GridCell b) {
		if (!isValidTile(a) || !isValidTile(b))
			return;
		((Tile) a.getComponent()).increasePower();
		b.setComponent(null);
	}

	
	/**
	 * KeyBoard Gameplay
	 */
	private ControlSettings controlSettings;
	
	public void sendControl(ControlSettings controls) {
		this.controlSettings = controls;
	}
	
	@Override
	public void keyTyped(KeyEvent event) {}

	@Override
	public void keyPressed(KeyEvent event) {}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == controlSettings.getKeyControl("left"))
			this.move(Direction.LEFT);
		if (event.getKeyCode() == controlSettings.getKeyControl("up"))
			this.move(Direction.UP);
		if (event.getKeyCode() == controlSettings.getKeyControl("right"))
			this.move(Direction.RIGHT);
		if (event.getKeyCode() == controlSettings.getKeyControl("down"))
			this.move(Direction.DOWN);
	}
	
	/**
	 * Mouse Gameplay
	 */
	private boolean sliding;
	private int slideX;
	private int slideY;
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (event.getX() >= x && event.getX() <= x + width
				&& event.getY() >= y && event.getY() <= y+width) {
			sliding = true;
			slideX = event.getX();
			slideY = event.getY();
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if(sliding) {
			sliding = false;

			if (event.getX() >= x && event.getX() <= x + width
					&& event.getY() >= y && event.getY() <= y+width) {
				int x = event.getX();
				int y = event.getY();
				
				int diffX = slideX - x;
				int diffY = slideY - y;
				
				if(diffX > 20 && diffX > diffY)
					this.move(Direction.LEFT);
				else if(diffY > 20 && diffY > diffX)
					this.move(Direction.UP);
				else if(diffX < -20 && diffX < diffY)
					this.move(Direction.RIGHT);
				else if(diffY < -20 && diffY < diffX)
					this.move(Direction.DOWN);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		
	}

}
