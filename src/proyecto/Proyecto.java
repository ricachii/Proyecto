
package proyecto;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Shape;


public class Proyecto {
    public static void main(String[] args) {
        int numero = (int) (Math.random()*1000);
        String nombre = "Pizarra_"+Integer.toString(numero);
        new Paint(nombre);
        //Test Unit
        Point q1 = new Point();
        Point q2 = new Point();
        
        Panel p1 = new Panel();
        
        Graphics g = null;
        Graphics2D g2 = null;
        p1.setG2d(g2);
        p1.getG2d();
        p1.paint(g);
        
        p1.crearGraphics2D();
        p1.getFigura();
        p1.guardarAutomatico(nombre);
        p1.guardar();
        p1.abrir();
        p1.resetAll();
        p1.setp1(q1);
        p1.setp2(q2);
        p1.crearLinea(p1.getp1(), p1.getp2());
        p1.crearRectangulo(p1.getp1(), p1.getp2());
        p1.setFigura(p1.crearRectangulo(q1, q2));
        
    }
}
