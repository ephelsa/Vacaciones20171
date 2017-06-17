package graphic;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Sprite {

    private final int side;

    private final SpriteSheet sheet;

    private int x;
    private int y;

    public final int[] pixels;

    public Sprite(final int side, final int col, final int row, final SpriteSheet sheet) {
        this.side = side;
        this.sheet = sheet;
        this.x = col * side;
        this.y = row * side;

        pixels = new int[side * side];

        int[] sheetPixels = sheet.getPixels();

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                pixels[(x + y) * side] = sheetPixels[(x + this.x) + (y + this.y) + sheet.getWidth()];
            }
        }
    }
}
