package map;

import alert.Alerts;
import graphic.Screen;
import graphic.Sprite;
import map.tile.Tile;

/**
 * Created by ephelsa on 17/06/17.
 */
public abstract class Map {
    protected int width;
    protected int height;

    protected int[] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new int[width * height];

        generateMap();
    }

    public Map(String route) {
        uploadMap(route);
    }

    private void uploadMap(String route) {

    }

    protected void generateMap() {

    }

    public void update() {

    }

    public void show(final int compensationX, final int compensationY, final Screen screen) {
        int north = compensationY >> 5; //32;
        int south = (compensationY + screen.getHeight()) >> 5;
        int west = compensationX >> 5;
        int east = (compensationX + screen.getWidth()) >> 5;
    }

    public Tile getTile(final int x, final int y) {
        int tileID = tiles[x + y * width];

        switch (tileID) {
            case 0:
                return Tile.ASPHALT;

            case 1:
                return Tile.VOID;

            default:
                return null;

        }

    }
}
