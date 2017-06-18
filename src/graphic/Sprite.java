package graphic;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Sprite {

    private final int side;

    private SpriteSheet sheet;

    private int x;
    private int y;

    public final int[] pixels;

    // Coleccion de sprites
    public static final Sprite ASPHALT = new Sprite(32, 0, 0, SpriteSheet.desert);
    public static final Sprite VOID = new Sprite(32, 0);
    public static final Sprite LAVA = new Sprite(32, 0xc65a07);
    // fin coleccion de sprites

    public Sprite(final int side, final int col, final int row, final SpriteSheet sheet) {
        this.side = side;
        this.sheet = sheet;
        this.x = col * side;
        this.y = row * side;

        pixels = new int[side * side];

        int[] sheetPixels = sheet.getPixels();

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                pixels[x + y * side] = sheetPixels[(x + this.x) + (y + this.y) + sheet.getWidth()];
            }
        }
    }

    public Sprite(final int side, final int color) {
        this.side = side;

        pixels = new int[side * side];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public int getSide() {
        return side;
    }
}
