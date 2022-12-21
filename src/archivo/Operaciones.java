
package archivo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pizarra.MiPanel;

/**
 * Clase con las operaciones para abrir y guardar archivo de imagen
 * @author Nicolas
 */
public class Operaciones {
    private MiPanel miPanel;

    /**
    * Recupera objeto MiPanel
    * @return miPanel objeto MiPanel
    * 
    */        
    public MiPanel getMiPanel() {
        return miPanel;
    }
    
    /**
    * Actualiza objeto MiPanel
    * @param miPanel Objeto que contiene los dibujos
    * 
    */  
    public void setMiPanel(MiPanel miPanel) {
        this.miPanel = miPanel;
    }

    /**
    * Constructor de clase Operaciones
    * @param miPanel Objeto que contiene los dibujos
    * 
    */       
    public Operaciones(MiPanel miPanel) {
        this.miPanel = miPanel;
    }

    /**
    * Permite abrir un archivo de imagen, de extensión .jpg
    * @return true En el caso de apertura exitosa. false en caso contrario.
    */      
    public boolean abrir() {
        try {
            JFileChooser jfc = createFileChooser();
            jfc.showDialog(this.getMiPanel(), "Seleccionar archivo ...");
            
            File file = jfc.getSelectedFile();
            if (file == null) {
                return false;
            }
            getMiPanel().setMiImagen( javax.imageio.ImageIO.read(file) );
            int w = getMiPanel().getMiImagen().getWidth(null);
            int h = getMiPanel().getMiImagen().getHeight(null);
            
            if (getMiPanel().getMiImagen().getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(getMiPanel().getMiImagen(), 0, 0, null);
            }
            getMiPanel().setG2d( (Graphics2D) getMiPanel().getMiImagen().getGraphics() );
            getMiPanel().repaint();
            return true;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
            //System.exit(1);
        }
    }

    /**
    * Crear una lista de los archivos que pueden ser aceptados
    * @return jfc lista de tipos de archivos
    * 
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

    /**
    * Obtener una lista de formatos 
    * @return setFormatos.toArray(new String[0]) lista de formatos
    * 
    */   
    public String[] getFormats() {
        String[] formatos = javax.imageio.ImageIO.getWriterFormatNames();
        java.util.TreeSet<String> setFormatos = new java.util.TreeSet<String>();
        for (String setFormato : setFormatos) {
            setFormatos.add(setFormato.toLowerCase());
        }
        return setFormatos.toArray(new String[0]);
    }  

    /**
    * Permite guardar un archivo de imagen, de extensión .jpg
    * 
    */         
    public void guardar() {
        try {
            JFileChooser jfc = createFileChooser();
            jfc.showDialog(this.getMiPanel(), "Seleccionar archivo ...");
            
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
            javax.imageio.ImageIO.write(getMiPanel().getMiImagen(), extension, file);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
    * Permite guardar de manera automática un archivo de imagen, de extensión .jpg en un directorio definido.
    * @param nombreArchivo Nombre del archivo con el cual se guarda.
    * 
    */     
    public void guardarAutomatico(String nombreArchivo) {
        try {
            String extension = "jpg";
            String path = "D:\\Ideas\\Otros\\";
            
            if (getMiPanel().getMiImagen() != null) {
                nombreArchivo = nombreArchivo +"."+ extension;
                File file = new File(path, nombreArchivo);
                File directory = new File(path);
                // Validar si existe directorio
                if (directory.exists()) {
                    if (file.exists()) {
                        javax.imageio.ImageIO.write(getMiPanel().getMiImagen(), extension, file);
                    }
                    else {
                        javax.imageio.ImageIO.write(getMiPanel().getMiImagen(), extension, file);
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
