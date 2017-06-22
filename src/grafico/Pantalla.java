package grafico;

public final class Pantalla {
	
	private final int ANCHO;
	private final int ALTO;
	
	public final int[] PIXELES;
	
	// Temporal
	private final static int LADO_SPRITE = 32;
	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
	// fin temporal
	
	public Pantalla(final int ANCHO, final int ALTO) {
		this.ANCHO = ANCHO;
		this.ALTO = ALTO;
		
		PIXELES = new int[this.ALTO * this.ANCHO];
	}
	
	public void limpiar() {
		for (int i = 0; i < PIXELES.length; i++) {
			PIXELES[i] = 0xff5c5d5e;
		}
	}
	
	public void mostrar(final int COMPENSACION_X, final int COMPENSACION_Y) {
		final int[] PIXELES_SPRITE = Sprite.ASFALTO.PIXELES;

		for (int y = 0; y < ALTO; y++) {
			int posicionY = y + COMPENSACION_Y;
			
			if (posicionY < 0 || posicionY >= ALTO) {
				// Que NO nos salgamos en la altura.
				continue;
			}
			
			for (int x = 0; x < ANCHO; x++) {
				int posicionX = x + COMPENSACION_X;
								
				if (posicionX < 0 || posicionX >= ANCHO) {
					continue;
				}

				// Temporal
				PIXELES[posicionX + posicionY * ANCHO] = PIXELES_SPRITE[(x & MASCARA_SPRITE)
				                                                        + (y & MASCARA_SPRITE) * LADO_SPRITE];
			}
		}
	}
}
