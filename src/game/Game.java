package game;

import control.Keyboard;
import graphic.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by ephelsa on 16/06/17.
 */
public class Game extends Canvas implements Runnable {

    /*
    *   Aquí van las variables que pertenecen a la ventana del game.
    */

    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static volatile boolean isWorking = false;

    private static final String TITLE = "Ventana <3";

    private static int ups = 0;
    private static int fps = 0;

    private static int x = 0;
    private static int y = 0;

    private static JFrame window;
    private static Thread thread;
    private static Keyboard keyboard;
    private static Screen screen;

    private static BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    private static int[] pixels = ((DataBufferInt) image.getRaster()
            .getDataBuffer()).getData();

    private Game() {
        /*
        * Características del juego.
        */

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        keyboard = new Keyboard();
        addKeyListener(keyboard);

        screen = new Screen(WIDTH, HEIGHT);

        window = new JFrame(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        /*
        * Método principal.
         */
        Game window = new Game();
        window.startThread();
    }

    private synchronized void startThread() {
        /*
        * Método es para inciar el hilo.
        *
        * Hilos:
        * -Graphics <- Actualiza los gráficos.
         */

        isWorking = true;

        thread = new Thread(this, "Graphics");
        thread.start();
    }

    private synchronized void stopThread() {
        /*
        * Método para detener el hilo.
         */

        isWorking = false;

        try {
            thread.join();  // Se encarga de detener el hilo, cuando este termine.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void toUpdate () {
        /*
        * Se encarga de actualizar todas las variables del juego.
         */

        keyboard.toUpdate();

        if (keyboard.escKey) {
            System.out.println("Salir");
        }
        if (keyboard.upKey) {
            y++;
        }
        if (keyboard.downKey) {
            y--;
        }
        if (keyboard.leftKey) {
            x++;
        }
        if (keyboard.rightKey) {
            x--;
        }

        ups++;
    }

    private void toShow() {
        /*
        * Se encarga de mostrar las cosas en el game.
         */

        BufferStrategy strategy = getBufferStrategy();

        if (strategy == null) {
            createBufferStrategy(2);

            return;
        }

        screen.cleanScreen();
        screen.showScreen(x, y);

        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

//        for (int i = 0; i < pixels.length; i++) {
//            pixels[i] = screen.pixels[i];

        // Costoso para máquinas viejas (Versiones viejas de JAVA).
//        }

        Graphics g = strategy.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.RED);
        g.fillRect(WIDTH/2, HEIGHT/2, 32, 32);
        g.dispose();

        strategy.show();

        fps++;
    }

    @Override
    public void run() {
        /*
         * NS_FOR_SECOND = Equivalencia de nano segundo a segundo.
         * UPS_TARGET = Actualizaciones por segundo.
         * NS_FOR_UPDATE = Cuando nanosegundos transcurre para actualizar.
         *
         * delta = Cantidad de tiempo hasta realizar una actualización.
         * timeElapsed = Tiempo que ha pasado desde que se referenció hasta el inicio.
         * Todo esto es para actualizar el juego.
          */

        final int NS_FOR_SECOND = 1000000000;
        final byte UPS_TARGET = 60;
        final double NS_FOR_UPDATE = NS_FOR_SECOND / UPS_TARGET;

        long updateReference = System.nanoTime();
        long countReference = System.nanoTime();

        double timeElapsed;
        double delta = 0;

        requestFocus(); // Para que el usuario no cliquee en la ventana.

        while (isWorking) {
            final long loopStart = System.nanoTime();

            timeElapsed = loopStart - updateReference;
            updateReference = loopStart;

            delta += timeElapsed / NS_FOR_UPDATE;

            while (delta >= 1) {
                toUpdate();
                delta--;
            }

            toShow();

            if (System.nanoTime() - countReference > NS_FOR_SECOND) {
                // Mostrar los Frames Por Segundo - Actualizaciones Por Segundo
                window.setTitle(TITLE + " || UPS: " + ups + " || FPS: " + fps);
                ups = 0;
                fps = 0;
                countReference = System.nanoTime();
            }
        }
    }
}
