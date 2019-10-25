package fr.killax.component;

import java.awt.Graphics;

public class Grid extends Component {
	
	private int cell_width;
	private int cell_height;
	
	private GridCell[][] grid;
	
	public Grid(int x, int y, int width, int height, int x_cell, int y_cell) {
		super(x, y, width, height);
		this.cell_width = width/x_cell;
		this.cell_height = height/y_cell;
		
		this.grid = new GridCell[y_cell][];
		for (int i = 0; i < x_cell; i++) {
			this.grid[i] = new GridCell[x_cell];
			for(int j = 0; j < grid[i].length; j++) 
				grid[i][j] = new GridCell(null, j * cell_width, i * cell_height, cell_width, cell_height);
		}
	}
	
	public int height() {
		return this.grid.length;
	}
	
	public int width() {
		return this.grid[0].length;
	}
	
	public void draw(Graphics g) {
		for(int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				grid[y][x].draw(g);
			}
		}
	}
	
	public void setGridCell(GridCell cell, int x, int y) {
		this.grid[y][x] = cell;
	}
	
	public void pushToCell(Component component, int x, int y) {
		this.grid[y][x].setComponent(component);
		component.width = cell_width;
		component.height = cell_height;
		component.x = x * cell_width;
		component.y = y * cell_height;
	}

}
