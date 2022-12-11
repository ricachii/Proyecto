package proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.io.File;
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


public class Paint extends JFrame implements ActionListener, WindowFocusListener {
    /* Atributos */
    JMenu archivo;
    JMenuItem pizarra, nuevo, abrir, guardar, salir;
    
    JMenu dibujar;
    JRadioButtonMenuItem rectangulo, linea, borrar,texto;
    JCheckBoxMenuItem relleno;
    JMenuItem color;
    
    JMenu ayuda;
    JMenuItem acerca;
    JColorChooser elegirColor = new JColorChooser();
    
    ButtonGroup btnGrp;
    Panel Panel;
   
    
    String nombreArchivo;
    

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    /* Constructor */
    public Paint(String arch) throws HeadlessException {
        crearMenu();
        addListener();
        Panel = new Panel();
        //Panel1 = new Panel1();
        this.add(Panel);
        this.setSize(1024,800);
        
       // this.add(Panel1);
       // Panel1.setBounds(0, 0, 1024 ,100);
       // this.setSize(1024,800);
        
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.nombreArchivo = arch;
        this.setTitle(this.nombreArchivo);
    }
    
    private void crearMenu() {
        JMenuBar menu = new JMenuBar();
        this.archivo = new JMenu("Archivo");
        this.pizarra = new JMenuItem("Otra pizarra");
        this.nuevo = new JMenuItem("Nuevo");
        this.abrir = new JMenuItem("Abrir");
        this.guardar = new JMenuItem("Guardar");
        this.salir = new JMenuItem("Salir");
        
        this.archivo.add(this.pizarra);
        this.archivo.add(this.nuevo);
        this.archivo.add(this.abrir);
        this.archivo.add(this.guardar);
        this.archivo.add(this.salir);
        menu.add(this.archivo);
        
        this.dibujar = new JMenu("Dibujar");
        this.btnGrp = new ButtonGroup();
        this.rectangulo = new JRadioButtonMenuItem("Rectangulo");
        this.linea = new JRadioButtonMenuItem("Linea");
        this.borrar = new JRadioButtonMenuItem("Borrar");
        this.texto = new JRadioButtonMenuItem("Texto");
        this.btnGrp.add(this.rectangulo);
        this.btnGrp.add(this.linea);
        this.btnGrp.add(this.borrar);
        this.btnGrp.add(this.texto);
        this.btnGrp.setSelected(this.rectangulo.getModel(), true);
        this.relleno = new JCheckBoxMenuItem("Relleno");
        this.color = new JMenuItem("Color");
        
        this.dibujar.add(this.rectangulo);
        this.dibujar.add(this.linea);
        this.dibujar.add(this.borrar);
        this.dibujar.add(this.relleno);
        this.dibujar.add(this.texto);
        this.dibujar.add(this.color);
        menu.add(this.dibujar);
        
        this.ayuda = new JMenu("Ayuda");
        this.acerca = new JMenuItem("Powered by ...");
        this.ayuda.add(this.acerca);
        menu.add(this.ayuda);
        
        this.setJMenuBar(menu);
    }
    
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
            this.Panel.resetAll();
        }
        if (e.getSource() == this.abrir) {
            if (this.Panel.abrir()) {
                valorPorDefecto();
                this.Panel.resetAtributes();                
            }
        }
        if (e.getSource() == this.guardar) {
            this.Panel.guardar();
        }
        if (e.getSource() == this.salir) {
            this.dispose();
           
        }
        if (e.getSource() == this.rectangulo) {
            this.Panel.rectangulo = true;
            this.Panel.linea = false;
            this.Panel.borrar = false;
        }
        if (e.getSource() == this.linea) {
            this.Panel.rectangulo = false;
            this.Panel.linea = true;
            this.Panel.borrar = false;
        }
        if (e.getSource() == this.borrar) {
            this.Panel.rectangulo = false;
            this.Panel.linea = false;
            this.Panel.borrar = true;
        }        
        if (e.getSource() == this.relleno) {
            this.Panel.relleno = !this.Panel.relleno;
        }
        if (e.getSource() == this.color) {
            Color aux;
            aux = JColorChooser.showDialog(this, "Elija un color...", this.Panel.getColorActual());
            this.Panel.setColorActual(aux);
        }   
        if (e.getSource() == this.acerca) {
            JOptionPane.showMessageDialog(null, "Nicolas Ricciardi"
                    + "\nMatias Barriga");
        }        
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
      
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        System.out.println("1. Perdi el focus !!! "+this.getNombreArchivo());
        
        if (this.getNombreArchivo() == null) {
            this.Panel.guardar();
        } 
        else {
            this.Panel.guardarAutomatico(this.getNombreArchivo());
        }
    }
}

