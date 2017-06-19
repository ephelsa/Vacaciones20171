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
    protected Tile[] tileCatalogue;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        tiles = new int[width * height];

        generateMap();
    }

    public Map(String route) {
        chargeMap(route);

        generateMap();
    }

    private void uploadMap(String route) {

    }

    protected void generateMap() {

    }

    protected void chargeMap(String route) {}

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
                // getTile(x, y).show(x, y, screen);
                if (x < 0 || y < 0 || x >= width || y >= height) {
                    Tile.VOID.show(x, y, screen);
                } else {
                    tileCatalogue[x + y * width].show(x, y , screen);
                }
            }
        }
    }

    public Tile getRandomTile(final int x, final int y) {
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
                return Tile.ASPHALT_LINE;

            case 2:
                return Tile.SAND;

            case 3:
                return Tile.SAND_TA1_L;

            case 4:
                return Tile.SAND_TA1_R;

            case 5:
                return Tile.SAND_TA2_L;

            case 6:
                return Tile.SAND_TA2_R;

            case 7:
                return Tile.SAND_TA3_L;

            case 8:
                return Tile.SAND_TA3_R;

            case 9:
                return Tile.WATER;

            case 10:
                return Tile.WATER_S1_R;

            case 11:
                return Tile.WATER_S2_R;

            default:
                return Tile.VOID;

        }
    }
}
