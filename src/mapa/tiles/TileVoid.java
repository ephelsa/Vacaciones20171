package mapa.tiles;

import grafico.Pantalla;
import grafico.Sprite;

/**
 * Created by ephelsa on 23/06/17.
 */
public class TileVoid extends Tile {

    public TileVoid(Sprite SPRITE) {
        super(SPRITE);
    }

    @Override
    public void mostrar(int X, int Y, Pantalla PANTALLA) {
        PANTALLA.mostrarTile(X, Y, this);
    }
}
