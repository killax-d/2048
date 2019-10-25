package fr.killax.ressources;

import java.nio.file.Paths;

public class SoundLoader {
	
	public static enum SoundType {
		BACKGROUND, SFX
	}
	
	public static BufferedSound load(String sound_name, SoundType type) {
		return AssetsLoader.getSound(Paths.get("res", "sounds") + sound_name, type);
	}
	
}
