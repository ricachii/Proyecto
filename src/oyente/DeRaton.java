
package oyente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pizarra.MiPanel;

/**
 * Clase oyente de los clic sobre mouse
 * @author Nicolas
 */
public class DeRaton extends MouseAdapter {
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
    * Constructor de clase DeRaton
    * @param miPanel Objeto que contiene los dibujos
    * 
    */     
    public DeRaton(MiPanel miPanel) {
        this.miPanel = miPanel;
    }
    
    @Override
    public void mousePressed(MouseEvent evento) {
        getMiPanel().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        getMiPanel().setPuntoX(evento.getPoint());

        if (getMiPanel().isBorrar() || getMiPanel().isSeleccionar()) {
            getMiPanel().setColorAnterior(getMiPanel().getColorActual());
            getMiPanel().setRellenoAnterior(getMiPanel().isRelleno()); 
            getMiPanel().setColorActual(Color.LIGHT_GRAY);
        }     
    }

    @Override
    public void mouseReleased(MouseEvent evento) {
        
        if (getMiPanel().isRectangulo() || getMiPanel().isLinea() || getMiPanel().isBorrar() || getMiPanel().isAgregarTexto())
            getMiPanel().setMoverRecorte(false);
        getMiPanel().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        
        if (getMiPanel().isRectangulo()) {
            getMiPanel().setPuntoY(evento.getPoint());
            if (getMiPanel().getPuntoY() != null) {
                getMiPanel().setFigura(getMiPanel().crearRectangulo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                getMiPanel().repaint();
            }
        }
        else {
            if (getMiPanel().isLinea()) {
                getMiPanel().setPuntoY(evento.getPoint());
                getMiPanel().setFigura(getMiPanel().crearLinea(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                getMiPanel().repaint();
            }
            else {
                if (getMiPanel().isBorrar()) {
                    getMiPanel().setPuntoY(evento.getPoint());

                    getMiPanel().setColorActual(Color.WHITE);
                    getMiPanel().setRelleno(true);
                    getMiPanel().setFigura(getMiPanel().borrarAlgo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                    getMiPanel().repaint();
                }
                else {
                    if (getMiPanel().isAgregarTexto()) {
                        getMiPanel().setPuntoY(evento.getPoint());

                        getMiPanel().setFigura(getMiPanel().agregarTexto(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                        getMiPanel().repaint();                    
                    }
                    else {
                        if (getMiPanel().isSeleccionar() && !getMiPanel().isMoverRecorte()) {
                            getMiPanel().setPuntoY(evento.getPoint());
                            System.out.println("2. Este es mi área");
                            getMiPanel().setFigura(getMiPanel().seleccionarAlgo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                            // getMiPanel().setColorActual(Color.WHITE);
                            // getMiPanel().setRelleno(true);                            
                            getMiPanel().repaint();                    
                        }
                        else {
                            if (getMiPanel().isMoverRecorte()) {
                                System.out.println("5. Solte botón mouse");
                            }
                        }
                    }
                }
            }
        }
    }    
}
