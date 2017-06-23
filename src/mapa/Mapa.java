package mapa;

import grafico.Pantalla;
import mapa.tiles.Tile;

/**
 * Created by ephelsa on 23/06/17.
 */
public abstract class Mapa {

    protected int ancho;
    protected int alto;

    protected int[] tiles;

    public Mapa(final int ANCHO, final int ALTO) {
        ancho = ANCHO;
        alto = ALTO;

        tiles = new int[ancho * alto];

        generarMapa();
    }

    public Mapa(final String RUTA) {
        cargarMapa(RUTA);
    }

    protected void generarMapa() {

    }

    private void cargarMapa(final String RUTA) {

    }

    public void actualizar() {

    }

    public void mostrar(final int COMPENSACION_X, final int COMPENSACION_Y, final Pantalla PANTALLA) {
        int norte = COMPENSACION_Y >> 5;
        int sur = (COMPENSACION_Y + PANTALLA.getALTO()) >> 5;
        int oeste = COMPENSACION_X >> 5;
        int este = (COMPENSACION_X + PANTALLA.getANCHO()) >> 5;
    }

    public Tile getTile(final int X, final int Y) {
        final int ID = tiles[X + Y * ancho];

        switch (ID) {
            case 0:
                return Tile.ASFALTO;

            default:
                return Tile.VACIO;
        }
    }
}
