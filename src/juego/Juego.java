package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;

import javax.swing.JFrame;

import grafico.Pantalla;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final String TITULO = "Cargar sprites";
	
	private static boolean trabajando = false;
	
	private static final int ANCHO = 500;
	private static final int ALTO = 500;
	
	private static final int X = 0;
	private static final int Y = 0;
	
	private static int aps = 0;
	private static int fps = 0;
	
	private static JFrame ventana; 
	private static Thread hilo;
	private static Pantalla pantalla;
	
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private final static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	
	public Juego() {
		
		setPreferredSize(new Dimension(ANCHO, ALTO));
		
		ventana = new JFrame(TITULO);
		pantalla = new Pantalla(ANCHO, ALTO);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		Juego juego = new Juego();
		
		juego.iniciarHilo();
	}
	
	public synchronized void iniciarHilo() {
		trabajando = true;
		
		hilo = new Thread(this, "Graficos");
		
		hilo.start();		
	}
	
	public synchronized void detenerHilo() {
		trabajando = false;
		
		try {
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		aps++;		
	}
	
	public void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();	
		
		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}
		
		pantalla.limpiar();
		pantalla.mostrar(X, Y);
		
		System.arraycopy(pantalla.PIXELES, 0, pixeles, 0, pixeles.length);

		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.GREEN);
		g.fillRect(ANCHO >> 1, ALTO >> 1, 32, 32);
		
		g.setColor(Color.WHITE);
		g.drawString("Prueba", 10, 10);		
		
		g.dispose();
		estrategia.show();
		
		fps++;
	}

	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		requestFocus();
		
		while(trabajando) {
			final long inicioCiclo = System.nanoTime();
			
			tiempoTranscurrido = inicioCiclo - referenciaActualizacion;
			referenciaActualizacion = inicioCiclo;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) {
				actualizar();
				
				delta--;
			}
			
			mostrar();
			
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				
				System.out.println("APS: " + aps + " || FPS: " + fps);
				
				aps = 0;
				fps = 0;
				
				referenciaContador = System.nanoTime();
			}
		}
	}
}
