package graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ephelsa on 16/06/17.
 */
public class SpriteSheet {

    private final int width;
    private final int heigth;

    private final int[] pixels; // publc -> Para acceder agresivamente. Ejecución > Elegancia.

    public SpriteSheet(final String route, final int width, final int heigth) {
        this.width = width;
        this.heigth = heigth;

        pixels = new int[width * heigth];

        BufferedImage image;

        try {
            image = ImageIO.read(SpriteSheet.class.getResource(route));

            image.getRGB(0, 0, width, heigth, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public int[] getPixels() {
        return pixels;
    }

}
