package fr.killax.core;

import java.awt.Container;
import java.awt.Graphics;

public abstract class Gui extends Container {

	private static final long serialVersionUID = 1L;

	public Gui() {
		this.setBounds(App.getInstance().getWindow().getBounds());
	}
	
	public abstract void paint(Graphics g);
	
}
