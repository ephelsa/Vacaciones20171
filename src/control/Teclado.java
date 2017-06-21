package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	
	private final int NUMERO_TECLAS;
	private final boolean[] TECLAS;
	
	// Definición de teclas.
	private boolean w;	// Arriba
	private boolean s;	// Abajo
	private boolean a;	// Izquierda
	private boolean d;	// Derecha
	// fin(Definición de teclas)
	
	public Teclado(final int NUMERO_TECLAS) {
		this.NUMERO_TECLAS = NUMERO_TECLAS;
		
		TECLAS = new boolean[this.NUMERO_TECLAS];
	}
	
	public void actualizarLectura() {
		w = TECLAS[KeyEvent.VK_W];
		s = TECLAS[KeyEvent.VK_S];
		a = TECLAS[KeyEvent.VK_A];
		d = TECLAS[KeyEvent.VK_D];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Presionada.
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Presionada sin soltar.
		TECLAS[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Soltar una vez pulsada.
		TECLAS[e.getKeyCode()] = false;
	}

}
