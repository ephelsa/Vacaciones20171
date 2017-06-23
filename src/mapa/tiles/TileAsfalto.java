package mapa.tiles;

import grafico.Pantalla;
import grafico.Sprite;

/**
 * Created by ephelsa on 23/06/17.
 */
public class TileAsfalto extends Tile {
    public TileAsfalto(Sprite SPRITE) {
        super(SPRITE);
    }

    @Override
    public void mostrar(int X, int Y, final Pantalla PANTALLA) {
        PANTALLA.mostrarTile(X, Y, this);
    }
}
