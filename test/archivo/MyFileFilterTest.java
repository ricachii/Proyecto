
package archivo;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricar
 */
public class MyFileFilterTest {
    
    public MyFileFilterTest() {
    }

    @Test
    public void testAccept() {
        System.out.println("accept");
        File f = new File("dasdasda.sdf");
        MyFileFilter instance = new MyFileFilter("gsdfg","dsfgds");
        boolean expResult = true;
        boolean result = instance.accept(f);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MyFileFilter instance = new MyFileFilter("gsdfg","dsfgds");
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetExtension() {
        System.out.println("getExtension");
        MyFileFilter instance = new MyFileFilter("gsdfg","dsfgds");
        String expResult = "gsdfg";
        String result = instance.getExtension();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
