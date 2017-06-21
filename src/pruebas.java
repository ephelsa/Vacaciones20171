import control.Teclado;

/**
 * Created by ephelsa on 20/06/17.
 */
public class pruebas {

    public static void main(String[] args) {
        Teclado teclado = new Teclado();

        while(true) {
            if (teclado.w) {
                System.out.println("s");
            }
        }
    }
}
