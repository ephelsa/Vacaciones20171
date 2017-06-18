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

    public static final int SIDE = 32;

    // Colección de tiles.
    public static final Tile ASPHALT = new AsphaltTile(Sprite.ASPHALT);
    public static final Tile VOID = new VoidTile(Sprite.VOID);
    public static final Tile LAVA = new LavaTile(Sprite.LAVA);
    // Fin colección de tiles.

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void show(int x, int y, Screen screen) {
        screen.showTile(x << 5, y << 5, this);
    }

    public boolean solid() {
        return false;
    }
}
