package fr.killax.component;

import java.awt.Graphics;

public class GridCell extends Component{

	private Component component;
	private int padding;
	
	public GridCell(Component component, int x, int y, int width, int height, int padding) {
		super(x + padding, y + padding, width - padding * 2, height - padding * 2);
		this.component = component;
		this.padding = padding;
	}
	
	public void setComponent(Component component) {
		this.component = component;
		if(component != null) {
			component.x = x + padding;
			component.y = y + padding;
			component.width = width - padding * 2;
			component.height = height - padding * 2;
		}
	}
	
	public Component getComponent() {
		return component;
	}

	@Override
	public void draw(Graphics g) {
		if(component != null)
			component.draw(g);
	}

	@Override
	public String toString() {
		return "GridCell [component=" + component + "]";
	}
	
}
