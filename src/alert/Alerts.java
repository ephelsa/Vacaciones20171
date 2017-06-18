package alert;

import javax.swing.*;

/**
 * Created by ephelsa on 18/06/17.
 */
public class Alerts {

    public void error() {

    }

    public void exitConfirmation() {
        int salida = JOptionPane.showConfirmDialog(null, "¿Desea salir?",
                "Confirmación de salida", JOptionPane.YES_NO_OPTION);

        if (salida == 0) {
            System.exit(0);
        }
    }
}
