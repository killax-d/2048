package fr.killax.ressources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import fr.killax.ressources.SoundLoader.SoundType;

public class AssetsLoader {
	
	/**
	 * @author Donné Dylan
	 * Simple assets loader
	 */

	private static Map<String, BufferedImage> assets = new HashMap<String, BufferedImage>();
	private static Map<String, BufferedSound> sounds = new HashMap<String, BufferedSound>();
	private static Map<String, Font> fonts = new HashMap<String, Font>();
	
	/**
	 * Image finder and loader
	 * @param path
	 * @return BufferedImage
	 */
	public static BufferedImage getImage(String path) {
		if (assets.containsKey(path)) {
			return assets.get(path);
		}
		try (InputStream is = AssetsLoader.class.getResourceAsStream(path)) {
			if (is != null) {
				BufferedImage img = ImageIO.read(is);
				assets.putIfAbsent(path, img);
				return img;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		assets.putIfAbsent(path, TextureLoader.NO_TEXTURE);
		return TextureLoader.NO_TEXTURE;
	}

	
	/**
	 * Sound finder and loader
	 * @param path
	 * @return BufferedSound
	 */
	public static BufferedSound getSound(String path, SoundType type) {
		if (sounds.containsKey(path)) {
			return sounds.get(path);
		}
		try (InputStream is = AssetsLoader.class.getResourceAsStream(path)) {
			if (is != null) {
				BufferedSound sound = new BufferedSound(is, type);
				sounds.putIfAbsent(path, sound);
				return sound;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Font finder and loader
	 * @param path
	 * @return Font
	 */
	public static Font getFont(String path, float size) {
		if (fonts.containsKey(path)) {
			return fonts.get(path).deriveFont(size);
		}
		try (InputStream is = AssetsLoader.class.getResourceAsStream(path)) {
		    Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
		    map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
		    map.put(TextAttribute.TRACKING, 0.08);
		    map.put(TextAttribute.SIZE, size);
			if (is != null) {
				Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(map);
				fonts.putIfAbsent(path, font);
				return font;
			}
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		fonts.putIfAbsent(path, FontLoader.NO_FONT);
		return FontLoader.NO_FONT.deriveFont(size);
	}

}