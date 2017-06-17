package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ephelsa on 16/06/17.
 */
public final class Keyboard implements KeyListener {

    private static int keysNumber = 120;
    private final boolean[] keys = new boolean[keysNumber];

    /**
     * Las siguientes variables van públicas, es debido a que si usamos "Getters and Setters",
     * y vamos a estar accediendo a estos agresivamente; los métodos PUEDEN retrasar la ejecución.
     */

    public boolean upKey;
    public boolean downKey;
    public boolean leftKey;
    public boolean rightKey;
    public boolean escKey;

    public void toUpdate() {
        upKey = keys[KeyEvent.VK_W];    // W = 0x57.
        downKey = keys[KeyEvent.VK_S];  // S = 0x53.
        leftKey = keys[KeyEvent.VK_A];  // A = 0x41.
        rightKey = keys[KeyEvent.VK_D]; // D = 0x44.
        escKey = keys[KeyEvent.VK_ESCAPE];  // ESCAPE = 0x1B;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Pulsar y soltar.

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Pulsar. Pero no se ha soltado.

        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Soltar. Cuando ya se había pulsado.

        keys[e.getKeyCode()] = false;
    }
}
