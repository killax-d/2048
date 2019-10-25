package fr.killax.component;

import java.util.Random;

public class Grid2048 extends Grid {

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
							if(x < offset_x) {
								if(match(grid[y][x], grid[y][offset_x]))
									fusion(grid[y][x], grid[y][offset_x]);
								if(grid[y][x].getComponent() == null && grid[y][offset_x].getComponent() != null) {
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
							if(y < offset_y) {
								if(match(grid[y][x], grid[offset_y][x]))
									fusion(grid[y][x], grid[offset_y][x]);
								if(grid[y][x].getComponent() == null && grid[offset_y][x].getComponent() != null) {
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
							if(x > offset_x) {
								if(match(grid[y][x], grid[y][offset_x]))
									fusion(grid[y][x], grid[y][offset_x]);
								if(grid[y][x].getComponent() == null && grid[y][offset_x].getComponent() != null) {
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
							if(y > offset_y) {
								if(match(grid[y][x], grid[offset_y][x]))
									fusion(grid[y][x], grid[offset_y][x]);
								if(grid[y][x].getComponent() == null && grid[offset_y][x].getComponent() != null) {
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
				if(!isValidTile(grid[y][x]))
					return true;
			}
		}
		return false;
	}
	
	public void randomIntoFreeCell() {
		if(!hasFreeCell())
			return;
		Random random = new Random();
		boolean pushed = false;
		while (!pushed) {
			int y = random.nextInt(height());
			int x = random.nextInt(height());
			if(!isValidTile(grid[y][x])) {
				pushToCell(new Tile(), x, y);
				pushed = true;
			}
		}
	}
	
	public boolean isValidTile(GridCell cell) {
		if(cell == null || cell.getComponent() == null || !(cell.getComponent() instanceof Tile))
			return false;
		return true;
	}
	
	public boolean match(GridCell a, GridCell b) {
		if(!isValidTile(a) || !isValidTile(b))
			return false;
		return ((Tile) a.getComponent()).getPower() == ((Tile) b.getComponent()).getPower();
	}
	
	public void fusion(GridCell a, GridCell b) {
		if(!isValidTile(a) || !isValidTile(b))
			return;
		((Tile) a.getComponent()).increasePower();
		b.setComponent(null);
	}
	
}
