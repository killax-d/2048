package fr.killax.component;

import java.awt.Graphics;

import fr.killax.object.Tiles;
import fr.killax.ressources.FontLoader;

public class Tile extends Component {

	private int power;
	
	public Tile() {
		super(0, 0, 0, 0);
		power = 1;
	}

	public int getPower() {
		return power;
	}
	
	public void increasePower() {
		power *= 2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(Tiles.getTile(power), x, y, width, height, null);
		g.setFont(FontLoader.NO_FONT.deriveFont(24F));
		g.drawString(String.valueOf(power), x + width/2, y + height/2);
	}

	@Override
	public String toString() {
		return "Tile [power=" + power + ", Component=" + super.toString() + "]";
	}

}