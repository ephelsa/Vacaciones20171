package mapa;

import java.util.Random;

/**
 * Created by ephelsa on 23/06/17.
 */
public class MapaGenerador extends Mapa {

    private final Random AZAR = new Random();

    public MapaGenerador(int ANCHO, int ALTO) {
        super(ANCHO, ALTO);
    }

    protected void generarMapa() {
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                tiles[x + y * ancho] = AZAR.nextInt(3);
            }
        }

    }
}
