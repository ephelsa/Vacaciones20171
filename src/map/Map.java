package map;

import graphic.Screen;
import graphic.Sprite;

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

    public void show(int compensationX, int compensationY, Screen screen) {
        int north = compensationY >> 5; //32;
        int south = (compensationY + screen.getHeight()) >> 5;
        int west = compensationX >> 5;
        int east = (compensationX + screen.getWidth()) >> 5;
    }
}
