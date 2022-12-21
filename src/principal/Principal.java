package principal;

import pizarra.Paint;

/**
 *
 * @author ricar
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero = (int) (Math.random()*1000);
        String nombre = "Pizarra_"+Integer.toString(numero);
        new Paint(nombre);
    }
}
