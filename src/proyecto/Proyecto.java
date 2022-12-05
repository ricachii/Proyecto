
package proyecto;


public class Proyecto {
    public static void main(String[] args) {
        int numero = (int) (Math.random()*1000);
        String nombre = "Pizarra_"+Integer.toString(numero);
        new Paint(nombre);
    }
}
