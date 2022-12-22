
package pizarra;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricar
 */
public class PaintTest {
    
    public PaintTest() {
    }

    @Test
    public void testGetNombreArchivo() {
        System.out.println("getNombreArchivo");
        Paint instance = new Paint("dsdsfds");
        String expResult = "dsdsfds";
        String result = instance.getNombreArchivo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetNombreArchivo() {
        System.out.println("setNombreArchivo");
        String nombreArchivo = "";
        Paint instance = null;
        instance.setNombreArchivo(nombreArchivo);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testValorPorDefecto() {
        System.out.println("valorPorDefecto");
        Paint instance = null;
        instance.valorPorDefecto();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Paint instance = null;
        instance.actionPerformed(e);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testWindowGainedFocus() {
        System.out.println("windowGainedFocus");
        WindowEvent e = null;
        Paint instance = null;
        instance.windowGainedFocus(e);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testWindowLostFocus() {
        System.out.println("windowLostFocus");
        WindowEvent e = null;
        Paint instance = null;
        instance.windowLostFocus(e);
        //fail("The test case is a prototype.");
    }
    
}
