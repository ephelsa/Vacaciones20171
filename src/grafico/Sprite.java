package grafico;

public final class Sprite {
	
	private int lado;
	private int columna;
	private int fila;
	public HojaSprites hoja;
	
	private int x;
	private int y;
	
	public final int[] PIXELES;
	
	// Colecciones
	public final static Sprite VACIO = new Sprite(32, 0xff000000);
	public final static Sprite ASFALTO = new Sprite(32, 5, 0, HojaSprites.ASFALTO);
	// fin(Colecciones)
	
	public Sprite(final int LADO, final int COLUMNA, final int FILA, final HojaSprites HOJA) {
		this.lado = LADO;
		this.columna = COLUMNA;
		this.fila = FILA;
		this.hoja = HOJA;

		this.x = this.columna * this.lado;
		this.y = this.fila * this.lado;
		
		PIXELES = new int[this.lado * this.lado];
		
		crearPixeles();
	}
	
	public Sprite(final int LADO, final int COLOR) {
		this.lado = LADO;
		
		PIXELES = new int[LADO * LADO];

		for (int i = 0; i < PIXELES.length; i++) {
			PIXELES[i] = COLOR;
		}
	}
	
	private void crearPixeles() {
		final int[] PIXELES_HOJA = hoja.getPixeles();
		
		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				PIXELES[x + y * lado] = PIXELES_HOJA[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}

	public int getLado() {
		return lado;
	}
}
