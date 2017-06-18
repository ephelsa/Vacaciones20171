package map.tile;

import graphic.Screen;
import graphic.Sprite;

/**
 * Created by ephelsa on 17/06/17.
 */
public abstract class Tile {
    public int x;
    public int y;

    public Sprite sprite;

    // Colección de tiles.
    public static final Tile ASPHALT = new AsphaltTile(Sprite.ASPHALT);
    public static final Tile VOID = new VoidTile(Sprite.VOID);
    // Fin colección de tiles.

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void show(int x, int y, Screen screen) {

    }

    public boolean solid() {
        return false;
    }
}
