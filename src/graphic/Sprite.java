package graphic;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Sprite {

    private final int side;

    private SpriteSheet sheet;

    private int x;
    private int y;

    public final int[] PIXELS;

    // Coleccion de sprites
    private static final SpriteSheet SHEET1 = SpriteSheet.sheet;

    public static final Sprite VOID = new Sprite(32, 0);

    public static final Sprite ASPHALT = new Sprite(32, 0, 0, SHEET1);
    public static final Sprite ASPHALT_LINE = new Sprite(32, 3, 0, SHEET1);

    public static final Sprite SAND = new Sprite(32, 1, 0, SHEET1);
    public static final Sprite SAND_TA1_L = new Sprite(32, 2, 0, SHEET1);
    public static final Sprite SAND_TA2_L = new Sprite(32, 2, 1, SHEET1);
    public static final Sprite SAND_TA3_L = new Sprite(32, 2, 2, SHEET1);
    public static final Sprite SAND_TA1_R = new Sprite(32, 4, 0, SHEET1);
    public static final Sprite SAND_TA2_R = new Sprite(32, 4, 1, SHEET1);
    public static final Sprite SAND_TA3_R = new Sprite(32, 4, 2, SHEET1);

    public static final Sprite WATER = new Sprite(32, 5, 0, SHEET1);
    public static final Sprite WATER_S1_R = new Sprite(32, 6, 0, SHEET1);
    public static final Sprite WATER_S2_R = new Sprite(32, 6, 1, SHEET1);
    // fin coleccion de sprites

    public Sprite(final int side, final int col, final int row, final SpriteSheet sheet) {
        this.side = side;
        this.sheet = sheet;
        this.x = col * this.side;
        this.y = row * this.side;

        PIXELS = new int[this.side * this.side];

        pixelCreator();
    }

    private void pixelCreator() {
        int[] sheetPixels = sheet.getPixels();

        for (int y = 0; y < side; y++) {
            for (int x = 0; x < side; x++) {
                PIXELS[x + y * side] = sheetPixels[(x + this.x) + (y + this.y) + sheet.getWidth()];
            }
        }
    }

    public Sprite(final int side, final int color) {
        this.side = side;

        PIXELS = new int[side * side];

        for (int i = 0; i < PIXELS.length; i++) {
            PIXELS[i] = color;
        }
    }

    public int getSide() {
        return side;
    }
}
