package map.tile;

import graphic.Screen;
import graphic.Sprite;

/**
 * Created by ephelsa on 17/06/17.
 */
public class AsphaltTile extends Tile {

    public AsphaltTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void show(int x, int y, Screen screen) {
        screen.showTile(x, y, this);
    }
}
