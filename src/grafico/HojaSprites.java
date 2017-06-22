package grafico;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	
	public final int[] PIXELES;
	
	private final String RUTA;
	private final int ANCHO;
	private final int ALTO;
	
	// Colecciones
	public final static HojaSprites ASFALTO = new HojaSprites("/texturas/fondo1.png", 320, 320);
	// fin(Colecciones)
	
	public HojaSprites (final String RUTA, final int LADO) {
		this.RUTA = RUTA;
		ANCHO = LADO;
		ALTO = LADO;
		
		PIXELES = new int[ANCHO * ALTO];
		
		creadorImagen();
	}
	
	
	public HojaSprites (final String RUTA, final int ANCHO, final int ALTO) {
		this.ANCHO = ANCHO;
		this.ALTO = ALTO;
		this.RUTA = RUTA;
		
		PIXELES = new int[ANCHO * ALTO];
		
		creadorImagen();
	}
	
	private void creadorImagen () {
		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(RUTA));
			
			imagen.getRGB(0, 0, ANCHO, ALTO, PIXELES, 0, ANCHO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getAncho() {
		return ANCHO;
	}
	
	public int getAlto() {
		return ALTO;
	}
	
	public int[] getPixeles() {
		return PIXELES;
	}
}
