package graphic;

import map.tile.Tile;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Screen {

    private final int width;
    private final int height;

    private int differenceX;
    private int differenceY;

    public final int[] pixels;

    public Screen(final int width, final int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void cleanScreen() {
        /** Este método se encarga de limpiar lo que había antes en pantalla
         *  para poder dibujar de nuevo.
         *  Si no se limpia, los gráficos van dejando manchas, o un destello detrás de ellos.
         */

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void showTile(int compensationX, int compensationY, Tile tile) {
        compensationX -= differenceX;
        compensationY -= differenceY;

        for (int y = 0; y < tile.sprite.getSide(); y++) {
            int posY = y + compensationY;

            for (int x = 0; x < tile.sprite.getSide(); x++) {
                int posX = x + compensationX;

                if (posX < -tile.sprite.getSide() || posX >= width || posY < 0 || posY >= height) {
                    break;
                }
                if (posX < 0) { posX = 0; }

                pixels[posX + posY * width] = tile.sprite.pixels[x + y * tile.sprite.getSide()];
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDifference(final int differenceX, final int differenceY) {
        this.differenceX = differenceX;
        this.differenceY = differenceY;
    }
}
