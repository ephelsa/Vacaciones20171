package mapa.tiles;

import grafico.Pantalla;
import grafico.Sprite;

/**
 * Created by ephelsa on 23/06/17.
 */
public abstract class Tile {
    private int x;
    private int y;

    private final Sprite SPRITE;

    // Coleccion de tiles
    public static final Tile VACIO = new TileVoid(Sprite.VACIO);
    public static final Tile ASFALTO = new TileAsfalto(Sprite.ASFALTO);
    // fin(Coleccion de tiles)

    public Tile(final Sprite SPRITE) {
        this.SPRITE = SPRITE;
    }

    public void mostrar(final int X, final int Y, final Pantalla PANTALLA) {

    }

    public boolean solido() {
        return false;
    }

    public Sprite getSprite() {
        return SPRITE;
    }
}
