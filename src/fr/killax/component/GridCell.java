package fr.killax.component;

import java.awt.Graphics;

public class GridCell extends Component{

	private Component component;
	
	public GridCell(Component component, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.component = component;
	}
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	public Component getComponent() {
		return component;
	}

	@Override
	public void draw(Graphics g) {
		if(component != null)
			component.draw(g);
	}
	
}
