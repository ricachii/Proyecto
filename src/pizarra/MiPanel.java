
package pizarra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import oyente.DeMovimiento;
import oyente.DeRaton;
import archivo.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class MiPanel extends JPanel {
    // Atributos //
    // ********* //
    private Point puntoX;
    private Point puntoY;
    
    // Opción de menu activa //
    // ********************* //
    private boolean rectangulo = true;
    private boolean linea = false;
    private boolean borrar = false;
    private boolean agregarTexto = false;
    private boolean seleccionar = false;
    private boolean relleno = false;
    
    private Color colorActual, colorAnterior;
    private boolean rellenoAnterior;
    
    private Shape figura;
    private BufferedImage miImagen, antesDeRecorte, recorte;
    private Graphics2D g2d;
    
    // variables para las propiedades del texto //
    private Color color = new Color(255,0,0);
    private int tamanio = 20 ;
    private String tipoFuente = "Arial";
    private Font fuente = new Font(tipoFuente, Font.PLAIN, tamanio);
    private String texto;
    
    // get y set //
    // ********* //
    public Point getPuntoX() {
        return puntoX;
    }

    public void setPuntoX(Point puntoX) {
        this.puntoX = puntoX;
    }

    public Point getPuntoY() {
        return puntoY;
    }

    public void setPuntoY(Point puntoY) {
        this.puntoY = puntoY;
    }

    public boolean isRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(boolean rectangulo) {
        this.rectangulo = rectangulo;
    }

    public boolean isLinea() {
        return linea;
    }

    public void setLinea(boolean linea) {
        this.linea = linea;
    }

    public boolean isBorrar() {
        return borrar;
    }

    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public Color getColorActual() {
        return colorActual;
    }

    public void setColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }

    public Color getColorAnterior() {
        return colorAnterior;
    }

    public void setColorAnterior(Color colorAnterior) {
        this.colorAnterior = colorAnterior;
    }

    public boolean isRellenoAnterior() {
        return rellenoAnterior;
    }

    public void setRellenoAnterior(boolean rellenoAnterior) {
        this.rellenoAnterior = rellenoAnterior;
    }

    public Shape getFigura() {
        return figura;
    }

    public boolean isAgregarTexto() {
        return agregarTexto;
    }

    public void setAgregarTexto(boolean agregarTexto) {
        this.agregarTexto = agregarTexto;
    }

    public boolean isSeleccionar() {
        return seleccionar;
    }

    public void setSeleccionar(boolean seleccionar) {
        this.seleccionar = seleccionar;
    }

    public void setFigura(Shape figura) {
        this.figura = figura;
    }

    public BufferedImage getMiImagen() {
        return miImagen;
    }

    public void setMiImagen(BufferedImage miImagen) {
        this.miImagen = miImagen;
    }

    public BufferedImage getRecorte() {
        return recorte;
    }

    public void setRecorte(BufferedImage recorte) {
        this.recorte = recorte;
    }

    public BufferedImage getAntesDeRecorte() {
        return antesDeRecorte;
    }

    public void setAntesDeRecorte(BufferedImage antesDeRecorte) {
        this.antesDeRecorte = antesDeRecorte;
    }
        
    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    // Constructor //
    // *********** //
   public Panel(){
        this.colorActual = Color.MAGENTA;
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLUE, 2));
        DeRaton miOyenteDeRaton = new DeRaton(this);
        DeMovimiento miOyenteDeMovimiento = new DeMovimiento(this);
        addMouseListener(miOyenteDeRaton);
        addMouseMotionListener(miOyenteDeMovimiento);
        
        
        
    }
    
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
    
    /**
     * 
     * @param paint hereda el paint del original
     * @return no retorna nada
     */
    
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
    public void setp1(Point p1){
        this.p1 = p1;
        
    }
     public void setp2(Point p2){
        this.p2 = p2;
        
    }

    
    public boolean getRectangulo(){
        return rectangulo;
    }
    public boolean getLinea(){
        return linea;
        
    }
    public Point getp1(){
        return p1;
    }
    public Point getp2(){
        return p2;
    }
    
    public boolean getBorrar(){
        return this.borrar;
    }
    //Metodos sobreescritos
    
    /**
     * 
     * @param paintComponent muestra las figuras que se mostraran en el panel
     * @return no retorna nada
     */
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
    /**
     * @param crearGraphics2D metedo del tipo Graphics2D el cual se encarga de crear las figuras respecto su tamaño, posicion, color, etc
     * @return retorna grafica en 2d
     */
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
    
    /**
     * 
     * @param crearRectangulo clase del tipo Shape el cual recibe puntos que inicializan la posicion y tamaño del rentangulo
     * @return Retorna una figura geometrica
     */
    public Shape crearRectangulo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        Shape nuevaFigura = new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
        return nuevaFigura;
    }
    
    /**
     * 
     * @param crearLinea clase del tipo Shape el cual recibe puntos que inicializan la posicion y tamaño de la linea
     * @return Retorna una linea
     */
    public Shape crearLinea(Point p1, Point p2) {
        Shape nuevaFigura = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return nuevaFigura;
    }
    
    /**
     * 
     * @param crearRectangulo clase del tipo Shape el cual recibe puntos que inicializan la posicion y tamaño de la herramienta borrar
     * @return Retorna un area que permite eliminar objetos
     */
    public Shape borrarAlgo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        Shape nuevaFigura = new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
        return nuevaFigura;
    }
    public Shape agregarTexto(Point p1, Point p2) {
        double ancho   = Math.abs(0 - p2.getX());
        double altura  = Math.abs(0 - p2.getY());

        FontRenderContext frc = getG2d().getFontRenderContext();
        TextLayout tl = new TextLayout(this.getTexto(), fuente, frc);
        AffineTransform af = new AffineTransform();
        af.setToTranslation(ancho, altura);
        Shape shape = tl.getOutline(af);
        return shape; 
    } 
    /**
     * @param createFileChooser metodo que crea el seleccionador de archivos
     * @return retorna un archivo de la extensión seleccionada
     */
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
    
    /**
     * @param abrir metodo que se encarga de verificar que la apartura de archivos se lleve a cabo y sea correcta
     * @return retorna un booleano
     */
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
    /**
     * 
     * @param guardarAutomatico recibe el nombre del archivo asociado a la imagen dibujada en la pizarra lo guarda en una extensión jpg y lo almacena en la carpeta exterior a src 
     * @return no retorna nada
     */
    public void guardarAutomatico(String nombreArchivo) {
        try {
            String extension = "jpg";
            String path = ".\\";
            
            if (getMiImagen() != null) {
                nombreArchivo = nombreArchivo +"."+ extension;
                File file = new File(path, nombreArchivo);
                File directory = new File(path);
                // Validar si existe directorio
                if (directory.exists()) {
                    if (file.exists()) {
                        javax.imageio.ImageIO.write(getMiImagen(), extension, file);
                    }
                    else {
                        javax.imageio.ImageIO.write(getMiImagen(), extension, file);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "ATENCION. Directorio: "+path+", no existe.");
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
