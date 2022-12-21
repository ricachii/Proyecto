
package oyente;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import pizarra.MiPanel;

/**
 *
 * @author ricar
 */
public class DeMovimiento extends MouseMotionAdapter{
    private MiPanel miPanel;

    public MiPanel getMiPanel() {
        return miPanel;
    }

    public void setMiPanel(MiPanel miPanel) {
        this.miPanel = miPanel;
    }

    public DeMovimiento(MiPanel miPanel) {
        this.miPanel = miPanel;
    }
    
    @Override
    public void mouseDragged(MouseEvent evento) {
        // La definición de esta variable puede tener conflicto con otra
        Graphics2D g2d = null;
        if (getMiPanel().isRectangulo()) {
            if (getMiPanel().getFigura() != null) {
                g2d = (Graphics2D) getMiPanel().getGraphics();
                g2d.setXORMode(getMiPanel().getBackground());
                g2d.setColor(getMiPanel().getColorActual());
                g2d.draw(getMiPanel().getFigura());
            }
            getMiPanel().setPuntoY(evento.getPoint());
            getMiPanel().setFigura(getMiPanel().crearRectangulo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
            g2d = (Graphics2D) getMiPanel().getGraphics();
            g2d.setXORMode(getMiPanel().getBackground());
            g2d.setColor(getMiPanel().getColorActual());
            g2d.draw(getMiPanel().getFigura());
        }
        else {
            if (getMiPanel().isLinea()) {
                if (getMiPanel().getFigura() != null) {
                    g2d = (Graphics2D) getMiPanel().getGraphics();
                    g2d.setXORMode(getMiPanel().getBackground());
                    g2d.setColor(getMiPanel().getColorActual());
                    g2d.draw(getMiPanel().getFigura());
                } 
                getMiPanel().setPuntoY(evento.getPoint());
                getMiPanel().setFigura(getMiPanel().crearLinea(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                g2d = (Graphics2D) getMiPanel().getGraphics();
                g2d.setXORMode(getMiPanel().getBackground());
                g2d.setColor(getMiPanel().getColorActual());
                g2d.draw(getMiPanel().getFigura());                  
            }
            else {
                if (getMiPanel().isBorrar()) {
                    float punteo[] = {10.0f,2.0f};
                    BasicStroke pincel = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 3.0f, punteo, 10.0f);
                    if (getMiPanel().getFigura() != null) {
                        g2d = (Graphics2D) getMiPanel().getGraphics();
                        g2d.setStroke(pincel);
                        g2d.setXORMode(getMiPanel().getBackground());
                        g2d.setColor(getMiPanel().getColorActual());
                        g2d.draw(getMiPanel().getFigura());
                    }
                    getMiPanel().setPuntoY(evento.getPoint());
                    getMiPanel().setFigura(getMiPanel().crearRectangulo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                    g2d = (Graphics2D) getMiPanel().getGraphics();
                    g2d.setStroke(pincel);
                    g2d.setXORMode(getMiPanel().getBackground());
                    g2d.setColor(getMiPanel().getColorActual());
                    g2d.draw(getMiPanel().getFigura());
                } 
                else {
                    if (getMiPanel().isAgregarTexto()) {
                        if (getMiPanel().getFigura() != null) {
                            g2d = (Graphics2D) getMiPanel().getGraphics();
                            g2d.setXORMode(getMiPanel().getBackground());
                            g2d.setColor(getMiPanel().getColorActual());
                            g2d.draw(getMiPanel().getFigura());
                        } 
                        getMiPanel().setPuntoY(evento.getPoint());
                        getMiPanel().setFigura(getMiPanel().agregarTexto(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                        g2d = (Graphics2D) getMiPanel().getGraphics();
                        g2d.setXORMode(getMiPanel().getBackground());
                        g2d.setColor(getMiPanel().getColorActual());
                        g2d.draw(getMiPanel().getFigura());                  
                    }
                    else {
                        if (getMiPanel().isSeleccionar()) {
                            float punteo[] = {10.0f,2.0f};
                            BasicStroke pincel = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 3.0f, punteo, 10.0f);
                            if (getMiPanel().getFigura() != null) {
                                g2d = (Graphics2D) getMiPanel().getGraphics();
                                g2d.setStroke(pincel);
                                g2d.setXORMode(getMiPanel().getBackground());
                                g2d.setColor(getMiPanel().getColorActual());
                                g2d.draw(getMiPanel().getFigura());
                            }
                            getMiPanel().setPuntoY(evento.getPoint());
                            getMiPanel().setFigura(getMiPanel().crearRectangulo(getMiPanel().getPuntoX(), getMiPanel().getPuntoY()));
                            g2d = (Graphics2D) getMiPanel().getGraphics();
                            g2d.setStroke(pincel);
                            g2d.setXORMode(getMiPanel().getBackground());
                            g2d.setColor(getMiPanel().getColorActual());
                            g2d.draw(getMiPanel().getFigura());
                        }                         
                    }                
                }
            }  
        }
    }
}
