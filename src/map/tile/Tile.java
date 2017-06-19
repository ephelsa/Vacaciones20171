package map.tile;

import graphic.Screen;
import graphic.Sprite;

/**
 * Created by ephelsa on 17/06/17.
 */
public class Tile {
    public int x;
    public int y;

    public Sprite sprite;

    public static final int SIDE = 32;

    // Colección de tiles.
    public static final Tile VOID = new Tile(Sprite.VOID);

    public static final Tile ASPHALT = new Tile(Sprite.ASPHALT);
    public static final Tile ASPHALT_LINE = new Tile(Sprite.ASPHALT_LINE);

    public static final Tile SAND = new Tile(Sprite.SAND);
    public static final Tile SAND_TA1_L = new Tile(Sprite.SAND_TA1_L);
    public static final Tile SAND_TA2_L = new Tile(Sprite.SAND_TA2_L);
    public static final Tile SAND_TA3_L = new Tile(Sprite.SAND_TA3_L);
    public static final Tile SAND_TA1_R = new Tile(Sprite.SAND_TA1_R);
    public static final Tile SAND_TA2_R = new Tile(Sprite.SAND_TA2_R);
    public static final Tile SAND_TA3_R = new Tile(Sprite.SAND_TA3_R);

    public static final Tile WATER = new Tile(Sprite.WATER);
    public static final Tile WATER_S1_R = new Tile(Sprite.WATER_S1_R);
    public static final Tile WATER_S2_R = new Tile(Sprite.WATER_S2_R);
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
