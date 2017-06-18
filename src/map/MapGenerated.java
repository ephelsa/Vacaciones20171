package map;

import java.util.Random;

/**
 * Created by ephelsa on 17/06/17.
 */
public class MapGenerated extends Map {

    private final Random random = new Random();

    public MapGenerated(int width, int height) {
        super(width, height);
    }

    protected void generateMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt();
            }
        }
    }
}
