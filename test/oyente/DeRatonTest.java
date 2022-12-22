
package oyente;

import java.awt.event.MouseEvent;
import org.junit.Test;
import static org.junit.Assert.*;
import pizarra.MiPanel;

/**
 *
 * @author ricar
 */
public class DeRatonTest {
    
    public DeRatonTest() {
    }

    @Test
    public void testGetMiPanel() {
        System.out.println("getMiPanel");
        DeRaton instance = null;
        MiPanel expResult = null;
        MiPanel result = instance.getMiPanel();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMiPanel() {
        System.out.println("setMiPanel");
        MiPanel miPanel = null;
        DeRaton instance = null;
        instance.setMiPanel(miPanel);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent evento = null;
        DeRaton instance = null;
        instance.mousePressed(evento);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent evento = null;
        DeRaton instance = null;
        instance.mouseReleased(evento);
        //fail("The test case is a prototype.");
    }
    
}
