package fr.killax.ressources;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import fr.killax.ressources.SoundLoader.SoundType;

/**
 * 
 * @author Donné Dylan
 * Simple sound Class
 */

public class BufferedSound {
	
	public static float MUSIC_VOLUME = 0.05F;
	public static float SFX_VOLUME = 0.1F;
	
	private Clip clip;
	private AudioInputStream audioStream;
	private SoundType type;
	private boolean playing;

	/**
	 * Create an Clip Object
	 * @param is
	 */
	public BufferedSound(InputStream is, SoundType type) {
		try {
			InputStream bufferedIn = new BufferedInputStream(is);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
			this.audioStream = audioStream;
			clip = AudioSystem.getClip();
		} catch (Exception e) {
			e.printStackTrace();
		}
		open();
		playing = false;
		this.type = type;
		setVolume(0.0F);
	}

	/**
	 * Get sound type
	 */
	public SoundType getType() {
		return type;
	}
	
	/**
	 * Open the clip
	 */
	public void open() {
		try {
			clip.open(audioStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set LOOP mode
	 * (MainMenu and Background Music)
	 * @param loop
	 */
	public void setLoop(boolean loop) {
		if(loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		else
			clip.loop(0);
	}

	/**
	 * Set loop points
	 * @param start // point to start the loop in seconds
	 * @param end // point to start the loop in seconds
	 */
	public void setLoopPoint(int start, int end) {
		clip.setLoopPoints(start, end);
	}

	/**
	 * Play Music
	 * Reset currentFrame to 0 to avoid glitch sound
	 */
	public void play(int frame) {
		if(playing)
			stop();
		clip.setFramePosition(frame);
		clip.start();
		playing = true;
	}
	
	public void play() {
		play(0);
	}
	
	/**
	 * Stop the Clip music
	 */
	public void stop() {
		playing = false;
		clip.stop();
	}
	
	/**
	 * Set the volume for a sound type
	 * @param type // sound type
	 * @param value // value in float (ex 0.5F)
	 */
	public static void setVolumeType(SoundType type, float value) {
		if (type == SoundType.BACKGROUND)
			MUSIC_VOLUME = value;
		if (type == SoundType.SFX)
			SFX_VOLUME = value;
	}
	
	/**
	 * adjust volume from new settings
	 */
	public void adjustVolume() {
		setVolume((type == SoundType.BACKGROUND ? MUSIC_VOLUME : SFX_VOLUME));
	}

	/**
	 * Set gain Volume
	 * @param volume // change the gain volume with a float (ex 0.05F)
	 */
	public void setVolume(float volume) {
	    if (volume < 0f || volume > 1f)
	        throw new IllegalArgumentException("Volume invalide: " + volume);
	    if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
	    	FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	    	gainControl.setValue(20f * (float) Math.log10(volume));
	    }
	    else
	    	System.err.println("setVolume() method not supported");
	}
}