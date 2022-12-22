
package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricar
 */
public class MiPanelTest {
    
    public MiPanelTest() {
    }

    @Test
    public void testGetPuntoX() {
        System.out.println("getPuntoX");
        MiPanel instance = new MiPanel();
        Point expResult = instance.getPuntoX();
        Point result = instance.getPuntoX();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetPuntoX() {
        System.out.println("setPuntoX");
        Point puntoX = null;
        MiPanel instance = new MiPanel();
        instance.setPuntoX(puntoX);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetPuntoY() {
        System.out.println("getPuntoY");
        MiPanel instance = new MiPanel();
        Point expResult = null;
        Point result = instance.getPuntoY();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetPuntoY() {
        System.out.println("setPuntoY");
        Point puntoY = null;
        MiPanel instance = new MiPanel();
        instance.setPuntoY(puntoY);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsRectangulo() {
        System.out.println("isRectangulo");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isRectangulo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRectangulo() {
        System.out.println("setRectangulo");
        boolean rectangulo = false;
        MiPanel instance = new MiPanel();
        instance.setRectangulo(rectangulo);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsLinea() {
        System.out.println("isLinea");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isLinea();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetLinea() {
        System.out.println("setLinea");
        boolean linea = false;
        MiPanel instance = new MiPanel();
        instance.setLinea(linea);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsBorrar() {
        System.out.println("isBorrar");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isBorrar();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetBorrar() {
        System.out.println("setBorrar");
        boolean borrar = false;
        MiPanel instance = new MiPanel();
        instance.setBorrar(borrar);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetAgregarTexto() {
        System.out.println("setAgregarTexto");
        boolean agregarTexto = false;
        MiPanel instance = new MiPanel();
        instance.setAgregarTexto(agregarTexto);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsSeleccionar() {
        System.out.println("isSeleccionar");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isSeleccionar();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetSeleccionar() {
        System.out.println("setSeleccionar");
        boolean seleccionar = false;
        MiPanel instance = new MiPanel();
        instance.setSeleccionar(seleccionar);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsRelleno() {
        System.out.println("isRelleno");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isRelleno();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRelleno() {
        System.out.println("setRelleno");
        boolean relleno = false;
        MiPanel instance = new MiPanel();
        instance.setRelleno(relleno);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsMoverRecorte() {
        System.out.println("isMoverRecorte");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isMoverRecorte();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMoverRecorte() {
        System.out.println("setMoverRecorte");
        boolean moverRecorte = false;
        MiPanel instance = new MiPanel();
        instance.setMoverRecorte(moverRecorte);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetColorActual() {
        System.out.println("getColorActual");
        MiPanel instance = new MiPanel();
        Color expResult = null;
        Color result = instance.getColorActual();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetColorActual() {
        System.out.println("setColorActual");
        Color colorActual = null;
        MiPanel instance = new MiPanel();
        instance.setColorActual(colorActual);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetColorAnterior() {
        System.out.println("getColorAnterior");
        MiPanel instance = new MiPanel();
        Color expResult = null;
        Color result = instance.getColorAnterior();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetColorAnterior() {
        System.out.println("setColorAnterior");
        Color colorAnterior = null;
        MiPanel instance = new MiPanel();
        instance.setColorAnterior(colorAnterior);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsRellenoAnterior() {
        System.out.println("isRellenoAnterior");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isRellenoAnterior();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRellenoAnterior() {
        System.out.println("setRellenoAnterior");
        boolean rellenoAnterior = false;
        MiPanel instance = new MiPanel();
        instance.setRellenoAnterior(rellenoAnterior);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetFigura() {
        System.out.println("getFigura");
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.getFigura();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsAgregarTexto() {
        System.out.println("isAgregarTexto");
        MiPanel instance = new MiPanel();
        boolean expResult = false;
        boolean result = instance.isAgregarTexto();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetFigura() {
        System.out.println("setFigura");
        Shape figura = null;
        MiPanel instance = new MiPanel();
        instance.setFigura(figura);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetMiImagen() {
        System.out.println("getMiImagen");
        MiPanel instance = new MiPanel();
        BufferedImage expResult = null;
        BufferedImage result = instance.getMiImagen();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMiImagen() {
        System.out.println("setMiImagen");
        BufferedImage miImagen = null;
        MiPanel instance = new MiPanel();
        instance.setMiImagen(miImagen);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetRecorte() {
        System.out.println("getRecorte");
        MiPanel instance = new MiPanel();
        BufferedImage expResult = null;
        BufferedImage result = instance.getRecorte();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetRecorte() {
        System.out.println("setRecorte");
        BufferedImage recorte = null;
        MiPanel instance = new MiPanel();
        instance.setRecorte(recorte);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetAntesDeRecorte() {
        System.out.println("getAntesDeRecorte");
        MiPanel instance = new MiPanel();
        BufferedImage expResult = null;
        BufferedImage result = instance.getAntesDeRecorte();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetAntesDeRecorte() {
        System.out.println("setAntesDeRecorte");
        BufferedImage antesDeRecorte = null;
        MiPanel instance = new MiPanel();
        instance.setAntesDeRecorte(antesDeRecorte);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetG2d() {
        System.out.println("getG2d");
        MiPanel instance = new MiPanel();
        Graphics2D expResult = null;
        Graphics2D result = instance.getG2d();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetG2d() {
        System.out.println("setG2d");
        Graphics2D g2d = null;
        MiPanel instance = new MiPanel();
        instance.setG2d(g2d);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetTexto() {
        System.out.println("getTexto");
        MiPanel instance = new MiPanel();
        String expResult = "";
        String result = instance.getTexto();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetTexto() {
        System.out.println("setTexto");
        String texto = "";
        MiPanel instance = new MiPanel();
        instance.setTexto(texto);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        MiPanel instance = new MiPanel();
        instance.paintComponent(g);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testResetAtributes() {
        System.out.println("resetAtributes");
        MiPanel instance = new MiPanel();
        instance.resetAtributes();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testResetAll() {
        System.out.println("resetAll");
        MiPanel instance = new MiPanel();
        instance.resetAll();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCrearGraphics2D() {
        System.out.println("crearGraphics2D");
        MiPanel instance = new MiPanel();
        Graphics2D expResult = null;
        Graphics2D result = instance.crearGraphics2D();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCrearRectangulo() {
        System.out.println("crearRectangulo");
        Point p1 = null;
        Point p2 = null;
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.crearRectangulo(p1, p2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCrearLinea() {
        System.out.println("crearLinea");
        Point p1 = null;
        Point p2 = null;
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.crearLinea(p1, p2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testBorrarAlgo() {
        System.out.println("borrarAlgo");
        Point p1 = null;
        Point p2 = null;
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.borrarAlgo(p1, p2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarTexto() {
        System.out.println("agregarTexto");
        Point p1 = null;
        Point p2 = null;
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.agregarTexto(p1, p2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSeleccionarAlgo() {
        System.out.println("seleccionarAlgo");
        Point p1 = null;
        Point p2 = null;
        MiPanel instance = new MiPanel();
        Shape expResult = null;
        Shape result = instance.seleccionarAlgo(p1, p2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRescatarImagen() {
        System.out.println("rescatarImagen");
        MiPanel instance = new MiPanel();
        instance.rescatarImagen();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testPintarEnOffscreen() {
        System.out.println("pintarEnOffscreen");
        Graphics2D g2 = null;
        MiPanel instance = new MiPanel();
        instance.pintarEnOffscreen(g2);
        //fail("The test case is a prototype.");
    }
    
}
