package fr.killax.component;

import java.awt.Graphics;

public abstract class Component {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Component(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw(Graphics g);

	@Override
	public String toString() {
		return "Component [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

}
