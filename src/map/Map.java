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

        screen.setDifference(compensationX, compensationY);

        int north = compensationY >> 5; //32;
        int south = (compensationY + screen.getHeight() + Tile.SIDE) >> 5;
        int west = compensationX >> 5;
        int east = (compensationX + screen.getWidth() + Tile.SIDE) >> 5;

        for (int y = north; y < south; y++) {
            for (int x = west; x < east; x++) {
                getTile(x, y).show(x, y, screen);
            }
        }
    }

    public Tile getTile(final int x, final int y) {
        /*
        Creador de tiles al azar. Juego procedular.
         */

        if (x < 0 || y < 0 || x >= width || y >= height) {
            // Controla que no tire error a la hora de llegar a los límites.
            return Tile.VOID;
        }

        int tileID = tiles[x + y * width];

        switch (tileID) {
            case 0:
                return Tile.ASPHALT;

            case 1:
                return Tile.LAVA;

            default:
                return Tile.VOID;

        }
    }
}
