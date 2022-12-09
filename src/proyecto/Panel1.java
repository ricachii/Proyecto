package proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Panel1 extends JPanel {
    //Atributos
    Point p1;
    Point p2;
    Shape figura;
    
    public Color colorActual, colorAnterior;
    
    BufferedImage miImagen;
    Graphics2D g2d;
    boolean rectangulo = true;
    boolean linea = false;
    boolean borrar = false;
    boolean relleno = false;
    boolean rellenoAnterior;
    //Constructor
    public Panel1(){
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.colorActual = Color.MAGENTA;
        this.setBorder(new LineBorder(Color.BLUE, 2));
    }
}
