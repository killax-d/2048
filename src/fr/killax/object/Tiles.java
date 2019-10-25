package fr.killax.object;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import fr.killax.core.App;
import fr.killax.ressources.TextureLoader;

public class Tiles {

	private static BufferedImage TEXTURE;
	public static int WIDTH;
	public static int HEIGHT;
	
	private static HashMap<Integer, BufferedImage> TILES;
	
	public static void init() {
		setTexture(App.getInstance().getSettings().getGameSettings().getTheme());
		loadTiles();
	}
	
	public static HashMap<Integer, BufferedImage> getTiles() {
		return TILES;
	}
	
	public static BufferedImage getTile(int number) {
		return TILES.get(number);
	}
	
	public static void setTexture(String texture) {
		TEXTURE = TextureLoader.load("themes/" + texture + "/tiles.png");
		WIDTH = TEXTURE.getWidth() / 4;
		HEIGHT = TEXTURE.getHeight() / 3;
	}
	
	public static void loadTiles() {
		TILES = new HashMap<Integer, BufferedImage>();
		int tile = 0;
		for (int y = 0; y < TEXTURE.getHeight(); y+= HEIGHT)
			for (int x = 0; x < TEXTURE.getWidth(); x += WIDTH)
				TILES.put(tile == 0 ? ++tile : (tile *= 2), TextureLoader.getTile(TEXTURE, WIDTH, HEIGHT, x/WIDTH, y/HEIGHT));
	}
	
}
