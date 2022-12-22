
package oyente;

import java.awt.event.MouseEvent;
import org.junit.Test;
import static org.junit.Assert.*;
import pizarra.MiPanel;

/**
 *
 * @author ricar
 */
public class DeMovimientoTest {
    
    public DeMovimientoTest() {
    }

    @Test
    public void testGetMiPanel() {
        System.out.println("getMiPanel");
        DeMovimiento instance = new DeMovimiento( new MiPanel());
        MiPanel expResult = new MiPanel();
        MiPanel result = instance.getMiPanel();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMiPanel() {
        System.out.println("setMiPanel");
        MiPanel miPanel = null;
        DeMovimiento instance = null;
        instance.setMiPanel(miPanel);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMouseDragged() {
        System.out.println("mouseDragged");
        MouseEvent evento = null;
        DeMovimiento instance = null;
        instance.mouseDragged(evento);
        //fail("The test case is a prototype.");
    }
    
}
