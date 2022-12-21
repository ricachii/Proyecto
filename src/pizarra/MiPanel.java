
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

/**
 * Clase donde se realiza dibujo, la pizarra
 * @author Nicolas
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
    
    // Cuando se puede mover imgen recordata //
    // ************************************* //
    private boolean moverRecorte = false;
    
    private Color colorActual, colorAnterior;
    private boolean rellenoAnterior;
    
    private Shape figura;
    private BufferedImage miImagen, antesDeRecorte, recorte;
    private Graphics2D g2d;
    
    // variables para las propiedades del texto //
    //private Color color = new Color(255,0,0);
    private int tamanio = 20 ;
    private String tipoFuente = "Arial";
    private Font fuente = new Font(tipoFuente, Font.PLAIN, tamanio);
    private String texto;
    
    /**
    * Recupera objeto Point, punto de origen
    * @return puntoX objeto Point
    * 
    */       
    public Point getPuntoX() {
        return puntoX;
    }

    /**
    * Actualiza atributo puntoX
    * @param puntoX Objeto que contiene punto de origen
    * 
    */  
    public void setPuntoX(Point puntoX) {
        this.puntoX = puntoX;
    }

    /**
    * Recupera objeto Point, punto de destinoi
    * @return puntoY objeto Point
    * 
    */      
    public Point getPuntoY() {
        return puntoY;
    }

    /**
    * Actualiza atributo puntoY
    * @param puntoY Objeto que contiene punto de destino
    * 
    */  
    public void setPuntoY(Point puntoY) {
        this.puntoY = puntoY;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Rectangulo" esta activo o no
    * @return rectangulo Indica si opción de menu "Rectangulo" esta activo o no
    * 
    */     
    public boolean isRectangulo() {
        return rectangulo;
    }

    /**
    * Actualiza atributo rectangulo
    * @param rectangulo Objeto que indica si opción de menu "Rectangulo", esta activa o no.
    * 
    */  
    public void setRectangulo(boolean rectangulo) {
        this.rectangulo = rectangulo;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Linea" esta activo o no
    * @return linea Indica si opción de menu "Linea" esta activo o no
    * 
    */     
    public boolean isLinea() {
        return linea;
    }

    /**
    * Actualiza atributo linea
    * @param linea Objeto que indica si opción de menu "Linea", esta activa o no.
    * 
    */ 
    public void setLinea(boolean linea) {
        this.linea = linea;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Borrar" esta activo o no
    * @return borrar Indica si opción de menu "Borrar" esta activo o no
    * 
    */  
    public boolean isBorrar() {
        return borrar;
    }

    /**
    * Actualiza atributo borrar
    * @param borrar Objeto que indica si opción de menu "Borrar", esta activa o no.
    * 
    */ 
    public void setBorrar(boolean borrar) {
        this.borrar = borrar;
    }

    /**
    * Actualiza atributo agregarTexto
    * @param agregarTexto Objeto que indica si opción de menu "Agregar texto", esta activa o no.
    * 
    */ 
    public void setAgregarTexto(boolean agregarTexto) {
        this.agregarTexto = agregarTexto;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Seleccionar" esta activo o no
    * @return seleccionar Indica si opción de menu "Seleccionar" esta activo o no
    * 
    */  
    public boolean isSeleccionar() {
        return seleccionar;
    }

    /**
    * Actualiza atributo seleccionar
    * @param seleccionar Objeto que indica si opción de menu "Seleccionar", esta activa o no.
    * 
    */ 
    public void setSeleccionar(boolean seleccionar) {
        this.seleccionar = seleccionar;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Relleno" esta activo o no
    * @return relleno Indica si opción de menu "Relleno" esta activo o no
    * 
    */
    public boolean isRelleno() {
        return relleno;
    }

    /**
    * Actualiza atributo relleno
    * @param relleno Objeto que indica si opción de menu "Relleno", esta activa o no.
    * 
    */ 
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    /**
    * Recupera valor boolean, que indica si la imagen recortada puede ser movida o no
    * @return moverRecorte Indica si opción de menu "Relleno" esta activo o no
    * 
    */
    public boolean isMoverRecorte() {
        return moverRecorte;
    }

    /**
    * Actualiza atributo moverRecorte
    * @param moverRecorte Objeto que indica si la imagen recortada puede ser movida o no.
    * 
    */ 
    public void setMoverRecorte(boolean moverRecorte) {
        this.moverRecorte = moverRecorte;
    }

    /**
    * Recupera objeto Color, que indica el color vigente
    * @return colorActual Indica el color vigente
    * 
    */
    public Color getColorActual() {
        return colorActual;
    }

    /**
    * Actualiza atributo colorActual
    * @param colorActual Objeto que indica el color actual, en uso.
    * 
    */ 
    public void setColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }

    /**
    * Recupera objeto Color, que indica el color anterior al actual
    * @return colorAnterior Indica el color anterior al actual
    * 
    */
    public Color getColorAnterior() {
        return colorAnterior;
    }

    /**
    * Actualiza atributo colorAnterior
    * @param colorAnterior Objeto que indica el color anterior al actual.
    * 
    */ 
    public void setColorAnterior(Color colorAnterior) {
        this.colorAnterior = colorAnterior;
    }

    /**
    * Recupera valor boolean, que indica el valor anterior al actual, de la opción de menu "Relleno"
    * @return rellenoAnterior Indica el valor anterior al actual, de la opción de menu "Relleno"
    * 
    */
    public boolean isRellenoAnterior() {
        return rellenoAnterior;
    }

    /**
    * Actualiza atributo rellenoAnterior
    * @param rellenoAnterior Objeto que indica el valor anterior al actual, de la opción de menu "Relleno"
    * 
    */ 
    public void setRellenoAnterior(boolean rellenoAnterior) {
        this.rellenoAnterior = rellenoAnterior;
    }

    /**
    * Recupera objeto Shape
    * @return figura objeto Shape
    * 
    */       
    public Shape getFigura() {
        return figura;
    }

    /**
    * Recupera valor boolean, que indica si opción de menu "Agregar texto" esta activo o no
    * @return agregarTexto Indica si opción de menu "Agregar texto" esta activo o no
    * 
    */    
    public boolean isAgregarTexto() {
        return agregarTexto;
    }

    /**
    * Actualiza atributo figura
    * @param figura Objeto que almacena la figura a colocar en imagen
    * 
    */ 
    public void setFigura(Shape figura) {
        this.figura = figura;
    }

    /**
    * Recupera objeto BufferedImage
    * @return miImagen objeto BufferedImage
    * 
    */  
    public BufferedImage getMiImagen() {
        return miImagen;
    }

    /**
    * Actualiza atributo miImagen
    * @param miImagen Objeto que almacena la imagen dibujada
    * 
    */     
    public void setMiImagen(BufferedImage miImagen) {
        this.miImagen = miImagen;
    }

    /**
    * Recupera objeto BufferedImage, de recorte de imagen
    * @return recorte objeto BufferedImage, de recorte de imagen
    * 
    */  
    public BufferedImage getRecorte() {
        return recorte;
    }

    /**
    * Actualiza atributo recorte
    * @param recorte Objeto que almacena recorte de imagen
    * 
    */ 
    public void setRecorte(BufferedImage recorte) {
        this.recorte = recorte;
    }

    /**
    * Recupera objeto BufferedImage, de imagen antes de recortar
    * @return antesDeRecorte objeto BufferedImage, de imagen antes de recortar
    * 
    */  
    public BufferedImage getAntesDeRecorte() {
        return antesDeRecorte;
    }

    /**
    * Actualiza atributo antesDeRecorte
    * @param antesDeRecorte Objeto que almacena imagen antes de recortar
    * 
    */ 
    public void setAntesDeRecorte(BufferedImage antesDeRecorte) {
        this.antesDeRecorte = antesDeRecorte;
    }

    /**
    * Recupera objeto Graphics2D
    * @return g2d objeto Graphics2D
    * 
    */         
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
    * Actualiza atributo g2d
    * @param g2d Objeto que almacena imagen
    * 
    */ 
    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    /**
    * Recupera texto a colocar en imagen
    * @return texto Texto a colocar en imagen
    * 
    */ 
    public String getTexto() {
        return texto;
    }

    /**
    * Actualiza atributo texto
    * @param texto Objeto que almacena texto a colocar en imagen
    * 
    */ 
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
    * Constructor de clase MiPanel
    * 
    */       
    public MiPanel() {
        this.setColorActual(Color.MAGENTA);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLUE, 2));

        DeRaton deRaton = new DeRaton(this);
        DeMovimiento deMovimiento = new DeMovimiento(this);
        
        addMouseListener(deRaton);
        addMouseMotionListener(deMovimiento);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (getMiImagen() == null) {
            setG2d( this.crearGraphics2D() );
        }
        
        if (this.isMoverRecorte()) {
            System.out.println("Pintando. Puedo mover!!!");
            getG2d().translate(this.getPuntoY().getX(), this.getPuntoY().getY());
            getG2d().drawImage(this.getRecorte(), 0, 0, this);
        }
        
        if (this.getFigura() != null) {
            getG2d().setColor(getColorActual());
            getG2d().draw(getFigura());            
            if (this.isRelleno()) {
                getG2d().fill(getFigura());
            }

            if (this.getMiImagen() != null && isShowing()) {
                g.drawImage(getMiImagen(), 0, 0, this);
            }
            if (this.isBorrar()) {
                this.setColorActual( this.getColorAnterior() );
                this.setRelleno(this.isRellenoAnterior());
            }
            this.setFigura(null);
        }
    }    

    /**
    * Deja los valores del menu a un valor por defecto
    * 
    */ 
    public void resetAtributes(){
        this.setRectangulo(true);
        this.setLinea(false);
        this.setBorrar(false);
        this.setRelleno(false);
        this.setAgregarTexto(false);
        this.setSeleccionar(false);
        this.setColorActual(Color.MAGENTA);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLUE, 2));        
    }

    /**
    * Deja todos los valores de la imagen y menu a un valor por defecto
    * 
    */    
    public void resetAll() {
        this.resetAtributes();
        this.setMiImagen(null);
        repaint();
    }

    /**
    * Crea un objeto de tipo Graphics2D, para pintar imagen
    * @return g2 Objeto de tipo Graphics2D
    * 
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
    * Crea un objeto de tipo Shape, correspondiente a un rectangulo
    * @param p1 Punto de origen
    * @param p2 Punto de destino
    * @return Rectangle2D.Double Shape, correspondiente a un rectangulo
    * 
    */          
    public Shape crearRectangulo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        return new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
    }   

    /**
    * Crea un objeto de tipo Shape, correspondiente a una linea
    * @param p1 Punto de origen
    * @param p2 Punto de destino
    * @return Line2D.Double Shape, correspondiente a una linea
    * 
    */      
    public Shape crearLinea(Point p1, Point p2) {
        return new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    /**
    * Crea un objeto de tipo Shape, correspondiente a un rectangulo de área a borrar
    * @param p1 Punto de origen
    * @param p2 Punto de destino
    * @return Rectangle2D.Double Shape, correspondiente a un rectangulo de área a borrar
    * 
    */     
    public Shape borrarAlgo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        return new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
    }

    /**
    * Crea un objeto de tipo Shape, correspondiente a un texto
    * @param p1 Punto de origen
    * @param p2 Punto de destino
    * @return shape Shape, correspondiente a un texto
    * 
    */   
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
    * Crea un objeto de tipo Shape, correspondiente a un área a seleccionar
    * @param p1 Punto de origen
    * @param p2 Punto de destino
    * @return Rectangle2D.Double Shape, correspondiente a un área a seleccionar
    * 
    */     
    public Shape seleccionarAlgo(Point p1, Point p2) {
        double xInicio = Math.min(p1.getX(),  p2.getX());
        double yInicio = Math.min(p1.getY(),  p2.getY());
        double ancho   = Math.abs(p1.getX() - p2.getX());
        double altura  = Math.abs(p1.getY() - p2.getY());
        
        // Recortar imagen
        System.out.println("3. Recortando area seleccionada");
        this.recorte = this.getMiImagen().getSubimage((int)xInicio, (int)yInicio, (int)ancho, (int)altura);
        this.setMoverRecorte(true);
        return new Rectangle2D.Double(xInicio, yInicio, ancho, altura);
    } 

    /**
    * Guarda la imagen existente ante de hacer recorte
    * 
    */     
    public void rescatarImagen() {
        this.setAntesDeRecorte( this.getMiImagen() );
    }
    
    /**
    * Dibuja la imagen recortada
    * @param g2 Desde donde se dibujara la imagen recortada
    * 
    */     
    public void pintarEnOffscreen( Graphics2D g2){
        double xInicio = Math.min(this.getPuntoX().getX(),  this.getPuntoY().getX());
        double yInicio = Math.min(this.getPuntoX().getY(),  this.getPuntoY().getY());
        double ancho   = Math.abs(this.getPuntoX().getX() - this.getPuntoY().getX());
        double altura  = Math.abs(this.getPuntoX().getY() - this.getPuntoY().getY());
        
        g2 = this.getRecorte().createGraphics();
    }    
}
