package fr.killax.component;

//import java.util.Random;
//import java.awt.Color;
import java.awt.Graphics;

import fr.killax.object.Tiles;

public class Tile extends Component {

//	private Color color;
	private int power;
	
	public Tile() {
		super(0, 0, 0, 0);
//		Random r = new Random();
//		color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		power = 1;
	}

	@Override
	public void draw(Graphics g) {
//		g.setColor(color);
//		g.fillRect(x, y, width, height);
		g.drawImage(Tiles.getTile(power), x, y, width, height, null);
	}

}