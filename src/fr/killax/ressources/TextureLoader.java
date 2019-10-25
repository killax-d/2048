package fr.killax.ressources;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;

public class TextureLoader {

	// The fail-safe default texture for missing assets
	public static BufferedImage NO_TEXTURE = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	static {
		NO_TEXTURE.setRGB(0, 0, new Color(140, 87, 113).getRGB());
	}
	
	public static BufferedImage load(String texture_name) {
		return AssetsLoader.getImage(Paths.get("res", "textures") + texture_name);
	}

	/**
	 * Sprite cropper
	 * @param path
	 * @return BufferedImage
	 */
	public static BufferedImage getTile(String path, int width, int height, int x, int y) {
		BufferedImage tileset = AssetsLoader.getImage(path);
		boolean validTexture = tileset.getWidth()>= width && tileset.getHeight() >= height;
		if (validTexture) {
			return tileset.getSubimage(x * width, y * height, width, height);
		}
		return NO_TEXTURE;
	}
	
}
