package graphic;

import map.tile.Tile;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Screen {

    private final int width;
    private final int height;

    public final int[] pixels;

    //TEMPORALS
    private final static int SPRITE_SIDE = 32;
    private final static int SPRITE_MASK = SPRITE_SIDE - 1;
    //END TEMPORALS

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
// Temporal
    public void showScreen(final int compensationX, final int compensationY) {
        /** Dibujar en pantalla
         * Después de estar limpia, este método se encarga de dibujar.
         */

        for (int y = 0; y < height; y++) {
            int posY = y + compensationY;

            if (posY < 0 || posY >= height) {
                /* Gestiona que no se salga de la ventana.
                 * "continue" hace que pase directamente al otro for.
                 */
                continue;
            }

            for (int x = 0; x < width; x++) {
                int posX = x + compensationX;

                if (posX < 0 || posX >= width) {
                /* Gestiona que no se salga de la ventana.
                 * "continue" hace que pase directamente al otro for.
                 */
                    continue;
                }

                // Código para dibujar en pantalla.
                // TEMPORAL
                pixels[posX + posY * width] = Sprite.ASPHALT.pixels[(x & SPRITE_MASK)
                        + (y & SPRITE_MASK) * SPRITE_SIDE];
                // END TEMPORAL
            }
        }
    }
    //End temporal

    public void showTile(int compensationX, int compensationY, Tile tile) {
        for (int y = 0; y < tile.sprite.getSide(); y++) {
            int posY = y + compensationY;

            for (int x = 0; x < tile.sprite.getSide(); x++) {
                int posX = x + compensationX;

                if (posX < 0 || posX > width || posY < 0 || posY > height) {
                    break;
                }

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
}
