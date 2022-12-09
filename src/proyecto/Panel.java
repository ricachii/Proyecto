package proyecto;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Panel extends JPanel{
    Point p1;
    Point p2;
    Shape figura;
    
    public Color colorActual, colorAnterior;
    
    
    public Panel(){
        this.colorActual = Color.MAGENTA;
        this.setBorder(new LineBorder(Color.BLUE, 2));
    }
    
}
