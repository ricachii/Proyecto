
package pizarra;

import archivo.Operaciones;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 * Clase que estructura la pizarra
 * @author Nicolas
 */
public class Paint extends JFrame implements ActionListener, WindowFocusListener {
    /* Atributos */
    JMenu archivo;
    JMenuItem pizarra, nuevo, abrir, guardar, salir;
    
    JMenu dibujar;
    JRadioButtonMenuItem rectangulo, linea, borrar, agregarTexto, seleccionar;
    JCheckBoxMenuItem relleno;
    JMenuItem color;
    
    JMenu ayuda;
    JMenuItem acerca;
    JColorChooser elegirColor = new JColorChooser();
    
    ButtonGroup btnGrp;
    MiPanel miPanel;
    
    String nombreArchivo;
    
    /* Métodos get y set */
    /**
    * Recupera nombre de archivo
    * @return Nombre de archivo
    */        
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
    * Actualiza nombre de archivo
    * @param nombreArchivo Nombre de archivo
    */     
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    /**
    * Constructor de clase Paint
    * @param arch Nombre de archivo, donde se guardará imagen
    */
    public Paint(String arch) throws HeadlessException {
        crearMenu();
        addListener();
        miPanel = new MiPanel();
        this.add(miPanel);
        this.setSize(1024,800);
        
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.nombreArchivo = arch;
        this.setTitle(this.nombreArchivo);
    }

    /**
    * Dibuja menu de la ventana
    * 
    */   
    private void crearMenu() {
        JMenuBar menu = new JMenuBar();
        this.archivo  = new JMenu("Archivo");
        this.pizarra  = new JMenuItem("Otra pizarra");
        this.nuevo    = new JMenuItem("Nuevo");
        this.abrir    = new JMenuItem("Abrir");
        this.guardar  = new JMenuItem("Guardar");
        this.salir    = new JMenuItem("Salir");
        
        this.archivo.add(this.pizarra);
        this.archivo.add(this.nuevo);
        this.archivo.add(this.abrir);
        this.archivo.add(this.guardar);
        this.archivo.add(this.salir);
        menu.add(this.archivo);
        
        this.dibujar       = new JMenu("Dibujar");
        this.btnGrp        = new ButtonGroup();
        this.rectangulo    = new JRadioButtonMenuItem("Rectangulo");
        this.linea         = new JRadioButtonMenuItem("Linea");
        this.borrar        = new JRadioButtonMenuItem("Borrar");
        this.agregarTexto  = new JRadioButtonMenuItem("Agregar texto");
       // this.seleccionar   = new JRadioButtonMenuItem("Seleccionar área");
        this.btnGrp.add(this.rectangulo);
        this.btnGrp.add(this.linea);
        this.btnGrp.add(this.borrar);
        this.btnGrp.add(this.agregarTexto);
        this.btnGrp.add(this.seleccionar);
        this.btnGrp.setSelected(this.rectangulo.getModel(), true);
        this.relleno    = new JCheckBoxMenuItem("Relleno");
        this.color      = new JMenuItem("Color");
        
        this.dibujar.add(this.rectangulo);
        this.dibujar.add(this.linea);
        this.dibujar.add(this.borrar);
        this.dibujar.add(this.agregarTexto);
      //this.dibujar.add(this.seleccionar);
        this.dibujar.add(this.relleno);
        this.dibujar.add(this.color);
        menu.add(this.dibujar);
        
        this.ayuda  = new JMenu("Ayuda");
        this.acerca = new JMenuItem("Powered by ...");
        this.ayuda.add(this.acerca);
        menu.add(this.ayuda);
        
        this.setJMenuBar(menu);
    }

    /**
    * Valor por defecto para la opción de menu Rectangulo
    * 
    */     
    public void valorPorDefecto() {
        this.btnGrp.setSelected(this.rectangulo.getModel(), true);
        this.relleno.setSelected(false);        
    }
    
    private void addListener() {
        this.pizarra.addActionListener(this);
        this.nuevo.addActionListener(this);
        this.abrir.addActionListener(this);
        this.guardar.addActionListener(this);
        this.salir.addActionListener(this);
        this.rectangulo.addActionListener(this);
        this.linea.addActionListener(this);
        this.borrar.addActionListener(this);
        this.agregarTexto.addActionListener(this);
      //this.seleccionar.addActionListener(this);   
        this.relleno.addActionListener(this);
        this.color.addActionListener(this);
        this.acerca.addActionListener(this);
        addWindowFocusListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pizarra) {
            int numero = (int) (Math.random()*1000);
            String nombre = "Pizarra_"+Integer.toString(numero);
            new Paint(nombre);
        }
        if (e.getSource() == this.nuevo) {
            valorPorDefecto();
            this.miPanel.resetAll();
        }
        if (e.getSource() == this.abrir) {
            Operaciones operaciones = new Operaciones(this.miPanel);
            if (operaciones.abrir()) {
                valorPorDefecto();
                this.miPanel.resetAtributes();                
            }
        }
        if (e.getSource() == this.guardar) {
            Operaciones operaciones = new Operaciones(this.miPanel);
            operaciones.guardar();
        }
        if (e.getSource() == this.salir) {
            this.dispose();
            //System.exit(0);
        }
        if (e.getSource() == this.rectangulo) {
            this.miPanel.setRectangulo(true);
            this.miPanel.setLinea(false);
            this.miPanel.setBorrar(false);
            this.miPanel.setAgregarTexto(false);
            this.miPanel.setSeleccionar(false);
        }
        if (e.getSource() == this.linea) {
            this.miPanel.setRectangulo(false);
            this.miPanel.setLinea(true);
            this.miPanel.setBorrar(false);
            this.miPanel.setAgregarTexto(false);
            this.miPanel.setSeleccionar(false);            
        }
        if (e.getSource() == this.borrar) {
            this.miPanel.setRectangulo(false);
            this.miPanel.setLinea(false);
            this.miPanel.setBorrar(true);
            this.miPanel.setAgregarTexto(false);
            this.miPanel.setSeleccionar(false);            
        }    
        if (e.getSource() == this.agregarTexto) {
            this.miPanel.setRectangulo(false);
            this.miPanel.setLinea(false);
            this.miPanel.setBorrar(false);
            this.miPanel.setAgregarTexto(true);
            this.miPanel.setSeleccionar(false); 
            String txt = JOptionPane.showInputDialog("Escriba texto: ");
            if (txt == null)
                txt = "Texto por defecto";
            this.miPanel.setTexto( txt );
        }    
        if (e.getSource() == this.seleccionar) {
            this.miPanel.setRectangulo(false);
            this.miPanel.setLinea(false);
            this.miPanel.setBorrar(false);
            this.miPanel.setAgregarTexto(false);
            this.miPanel.setSeleccionar(true); 
            // Rescatar imagen original
            System.out.println("1. Hice clic en opcion seleccionar");
            this.miPanel.rescatarImagen();
        }         
        if (e.getSource() == this.relleno) {
            this.miPanel.setRelleno(!this.miPanel.isRelleno());
        }
        if (e.getSource() == this.color) {
            Color aux;
            aux = JColorChooser.showDialog(this, "Elija un color...", this.miPanel.getColorActual());
            this.miPanel.setColorActual(aux);
        }   
        if (e.getSource() == this.acerca) {
            JOptionPane.showMessageDialog(null, "NICOLAS RICCIARDI");
        }        
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        //System.out.println("Gane el focus !!!");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        //System.out.println("1. Perdi el focus !!! "+this.getNombreArchivo());
        Operaciones operaciones = new Operaciones(this.miPanel);
        // Si nombre de archivo es null llamar a guardar
        if (this.getNombreArchivo() == null) {
            operaciones.guardar();
        } 
        // Sino llamar a guardarAtumatico
        else {
            operaciones.guardarAutomatico(this.getNombreArchivo());
        }  
    }
}
