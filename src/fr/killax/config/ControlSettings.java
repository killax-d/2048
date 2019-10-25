package fr.killax.config;

import java.util.HashMap;

public class ControlSettings {
	
	private HashMap<String, Integer> keys;
	
//	public ControlSettings() {
//		keys = new HashMap<>();
//		keys.put("right", 1);
//		keys.put("left", 2);
//		keys.put("down", 3);
//		keys.put("up", 4);
//	}
	
	public int getKeyControl(String control) {
		return  keys.get(control);
	}

}
