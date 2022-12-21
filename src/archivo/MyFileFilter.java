
package archivo;

import java.io.File;

/**
 * Clase que define los filtros para busqueda de archivo
 * @author Nicolas
 */
public class MyFileFilter extends javax.swing.filechooser.FileFilter {
    private String extension;
    private String description;
    /**
    * Constructor de clase MyFileFilter
    * @param extension Extensión del archivo
    * @param description Descripción de la extensión
    * 
    */ 
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

    /**
    * Recupera atributo extensión
    * @return extension Nombre de la extensión del archivo
    * 
    */       
    public String getExtension() {
        return extension;
    }    
}
