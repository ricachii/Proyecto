
package archivo;

import javax.swing.JFileChooser;
import org.junit.Test;
import static org.junit.Assert.*;
import pizarra.MiPanel;

/**
 *
 * @author ricar
 */
public class OperacionesTest {
    
    public OperacionesTest() {
    }

    @Test
    public void testGetMiPanel() {
        System.out.println("getMiPanel");
        Operaciones instance = new Operaciones(new MiPanel());
        MiPanel expResult = instance.getMiPanel();
        MiPanel result = instance.getMiPanel();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMiPanel() {
        System.out.println("setMiPanel");
        MiPanel miPanel = null;
        Operaciones instance = null;
        instance.setMiPanel(miPanel);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testAbrir() {
        System.out.println("abrir");
        Operaciones instance = null;
        boolean expResult = false;
        boolean result = instance.abrir();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCreateFileChooser() {
        System.out.println("createFileChooser");
        Operaciones instance = null;
        JFileChooser expResult = null;
        JFileChooser result = instance.createFileChooser();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetFormats() {
        System.out.println("getFormats");
        Operaciones instance = null;
        String[] expResult = null;
        String[] result = instance.getFormats();
        assertArrayEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Operaciones instance = null;
        instance.guardar();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarAutomatico() {
        System.out.println("guardarAutomatico");
        String nombreArchivo = "";
        Operaciones instance = null;
        instance.guardarAutomatico(nombreArchivo);
        //fail("The test case is a prototype.");
    }
    
}
