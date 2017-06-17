package Juego;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ephelsa on 16/06/17.
 */
public class Game extends Canvas implements Runnable {

    /*
    *   Aquí van las variables que pertenecen a la ventana del juego.
    */

    //private static final long serialVersionUID = 1L;

    private static final int WIDTH = 720;
    private static final int HEIGHT = 460;

    private static volatile boolean isWorking = false;

    private static final String TITLE = "Ventana <3";

    private static int ups = 0;
    private static int fps = 0;

    private static JFrame window;
    private static Thread thread;

    private Game() {
        /*
        * Características de la ventana.
        */

        setPreferredSize(new Dimension(WIDTH, HEIGHT));

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
        Game ventana = new Game();
        ventana.startThread();
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

        ups++;
    }

    private void toShow() {
        /*
        * Se encarga de mostrar las cosas en el juego.
         */

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
