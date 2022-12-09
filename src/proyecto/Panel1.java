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
    
    //Metodos, get, set
    
    public Color getColorActual(){
        return colorActual;
    }
    public void setColorActual(Color colorActual){
        this.colorActual = colorActual;
    }
    
      public Color getColorAnterior() {
        return colorAnterior;
    }

    public void setColorAnterior(Color colorAnterior) {
        this.colorAnterior = colorAnterior;
    }
    

    public void paint(Graphics g){
        super.paint(g);

    }
    
    public BufferedImage getMiImagen() {
        return miImagen;
    }
    
    public void setMiImagen(BufferedImage miImagen) {
        this.miImagen = miImagen;
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }
    
    public Shape getFigura() {
        return figura;
    }

    public void setFigura(Shape figura) {
        this.figura = figura;
    }
    //Metodos sobreescritos
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getMiImagen() == null) {
            setG2d( this.crearGraphics2D() );
        }
        if (getFigura() != null) {
            // Arreglar este if
            if (relleno) {
                getG2d().setColor(getColorActual());
                getG2d().draw(getFigura());
                getG2d().fill(getFigura());
            }
            else {
                getG2d().setColor(getColorActual());
                getG2d().draw(getFigura());                
            }
            if (getMiImagen() != null && isShowing()) {
                g.drawImage(getMiImagen(), 0, 0, this);
            }
            if (borrar) {
                //System.out.println("MiPanel..paintComponent");
                setColorActual( getColorAnterior() );
                relleno = rellenoAnterior;
            }
            setFigura(null);
        }
    }
    //otros metodos
    public Graphics2D crearGraphics2D() {
        Graphics2D g2 = null;
        
        if (getMiImagen() == null || getMiImagen().getWidth() != getSize().width || getMiImagen().getHeight() != getSize().height){
            setMiImagen( (BufferedImage) createImage(getSize().width, getSize().height) );   
        }
        if (getMiImagen() != null) {
            g2 = getMiImagen().createGraphics();
            g2.setColor(getColorActual());
            g2.setBackground(getBackground());
        }
        g2.clearRect(0, 0, getSize().width, getSize().height);
        return g2;
    }
    
    public Shape crearRectangulo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        Shape nuevaFigura = new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
        return nuevaFigura;
    }
    
    public Shape crearLinea(Point p1, Point p2) {
        Shape nuevaFigura = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return nuevaFigura;
    }

    public Shape borrarAlgo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        Shape nuevaFigura = new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
        return nuevaFigura;
    }
    public JFileChooser createFileChooser() {
        JFileChooser jfc = new JFileChooser();
        
        jfc.setAcceptAllFileFilterUsed(true);
        String[] tipoArchivos = getFormats();
        
        for (String tipoArchivo : tipoArchivos) {
            jfc.addChoosableFileFilter(new MyFileFilter(tipoArchivo, tipoArchivo + " file"));
        }
        return jfc;
    }
    public void resetAtributes(){
        this.rectangulo = true;
        this.linea = false;
        this.borrar = false;
        this.relleno = false;
        setColorActual(Color.MAGENTA);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLUE, 2));        
    }
    
    public void resetAll() {
        resetAtributes();
        setMiImagen(null);
        repaint();
    }
   
    public boolean abrir() {
        try {
            JFileChooser jfc = createFileChooser();
            jfc.showDialog(this, "Seleccionar archivo ...");
            
            File file = jfc.getSelectedFile();
            if (file == null) {
                return false;
            }
            setMiImagen( javax.imageio.ImageIO.read(file) );
            int w = getMiImagen().getWidth(null);
            int h = getMiImagen().getHeight(null);
            
            if (getMiImagen().getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(getMiImagen(), 0, 0, null);
            }
            setG2d( (Graphics2D) getMiImagen().getGraphics() );
            repaint();
            return true;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
            //System.exit(1);
        }
    }
    
    public String[] getFormats() {
        String[] formatos = javax.imageio.ImageIO.getWriterFormatNames();
        java.util.TreeSet<String> setFormatos = new java.util.TreeSet<String>();
        for (String setFormato : setFormatos) {
            setFormatos.add(setFormato.toLowerCase());
        }
        return setFormatos.toArray(new String[0]);
    }
    
    public void guardar() {
        try {
            JFileChooser jfc = createFileChooser();
            jfc.showDialog(this, "Seleccionar archivo ...");
            
            File file = jfc.getSelectedFile();
            if (file == null) {
                return;
            }
            javax.swing.filechooser.FileFilter ff = jfc.getFileFilter();
            String nombreArchivo = file.getName();
            String extension = "jpg";
            if (ff instanceof MyFileFilter) {
                extension = ((MyFileFilter) ff).getExtension();
            }
            nombreArchivo = nombreArchivo +"."+ extension;
            file = new File(file.getParent(), nombreArchivo);
            javax.imageio.ImageIO.write(getMiImagen(), extension, file);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Clases extras
    class MyFileFilter extends javax.swing.filechooser.FileFilter {
        private String extension;
        private String description;

        public MyFileFilter(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }
        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase().endsWith("."+extension) || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        public String getExtension() {
            return extension;
        }
    }
}
