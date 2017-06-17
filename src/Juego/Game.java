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
        JOptionPane.showMessageDialog(null, "Es que joden compa");

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
    }

    private void toShow() {
        /*
        * Se encarga de mostrar las cosas en el juego.
         */
    }

    @Override
    public void run() {
        while(isWorking) {
            toUpdate();
            try {
                thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toShow();
        }
    }
}
