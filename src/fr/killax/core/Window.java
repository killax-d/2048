package fr.killax.core;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;
	
	public Window(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		setVisible(true);
		setBackground(Color.BLACK);
		
		registerClock();
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
	}
	
	private void registerClock() {
		Timer clock = new Timer();
		clock.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				App.getInstance().getWindow().getCurrentGui().repaint();
			}
		}, 1000, 17);
	}
	
	public void setCurrentGui(Container gui) {
		setContentPane(gui);
		revalidate();
	}
	
	public Container getCurrentGui() {
		return getContentPane();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		if (getCurrentGui() instanceof MouseWheelListener) {
			((MouseWheelListener) getCurrentGui()).mouseWheelMoved(event);
		}
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		if (getCurrentGui() instanceof MouseMotionListener) {
			((MouseMotionListener) getCurrentGui()).mouseDragged(event);
		}
	}

	@Override
	public void mouseMoved(MouseEvent event) {
		if (getCurrentGui() instanceof MouseMotionListener) {
			((MouseMotionListener) getCurrentGui()).mouseMoved(event);
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (getCurrentGui() instanceof MouseListener) {
			((MouseListener) getCurrentGui()).mouseClicked(event);
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if (getCurrentGui() instanceof MouseListener) {
			((MouseListener) getCurrentGui()).mouseEntered(event);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if (getCurrentGui() instanceof MouseListener) {
			((MouseListener) getCurrentGui()).mouseExited(event);
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		if (getCurrentGui() instanceof MouseListener) {
			((MouseListener) getCurrentGui()).mousePressed(event);
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		if (getCurrentGui() instanceof MouseListener) {
			((MouseListener) getCurrentGui()).mouseReleased(event);
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (getCurrentGui() instanceof KeyListener) {
			((KeyListener) getCurrentGui()).keyPressed(event);
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (getCurrentGui() instanceof KeyListener) {
			((KeyListener) getCurrentGui()).keyReleased(event);
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (getCurrentGui() instanceof KeyListener) {
			((KeyListener) getCurrentGui()).keyTyped(event);
		}
	}
}
