package fr.killax.ressources;

import java.awt.Font;
import java.nio.file.Paths;

public class FontLoader {

	// The fail-safe default font for missing fonts
	public static Font NO_FONT = new Font("Arial", Font.TRUETYPE_FONT, 12);
	
	public static Font load(String font_path, float size) {
		return AssetsLoader.getFont(Paths.get("res", "fonts") + font_path, size);
	}
	
}
