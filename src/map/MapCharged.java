package map;

import map.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by ephelsa on 19/06/17.
 */
public class MapCharged extends Map {

    private int[] pixels;

    public MapCharged(String route) {
        super(route);
    }

    @Override
    protected void generateMap() {
        for (int i = 0; i < pixels.length; i++) {

            switch (pixels[i]) {
                case 0xff1d1d1d:
                    tileCatalogue[i] = Tile.ASPHALT;
                    continue;

                case 0xfff5d967:
                    tileCatalogue[i] = Tile.SAND;
                    continue;

                case 0xffc2ab51:
                    tileCatalogue[i] = Tile.SAND_TA1_L;
                    continue;

                case 0xff8b7623:
                    tileCatalogue[i] = Tile.SAND_TA2_L;
                    continue;

                case 0xff373013:
                    tileCatalogue[i] = Tile.SAND_TA3_L;
                    continue;

                case 0xff7f5300:
                    tileCatalogue[i] = Tile.ASPHALT_LINE;
                    continue;

                case 0xff2da38e:
                    tileCatalogue[i] = Tile.WATER;
                    continue;

                case 0xff71bd8b:
                    tileCatalogue[i] = Tile.WATER_S1_R;
                    continue;

                case 0xff2da18c:
                    tileCatalogue[i] = Tile.WATER_S2_R;
                    continue;

                default:
                    tileCatalogue[i] = Tile.VOID;
                    continue;
            }
        }
    }

    protected void chargeMap(String route) {
        try {
            BufferedImage image = ImageIO.read(MapCharged.class.getResource(route));

            width = image.getWidth();
            height = image.getHeight();

            tileCatalogue = new Tile[width * height];
            pixels = new int[width * height];

            image.getRGB(0, 0, width, height, pixels, 0, width);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
