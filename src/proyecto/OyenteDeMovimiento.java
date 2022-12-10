package proyecto;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class OyenteDeMovimiento extends MouseMotionAdapter {

    Panel MiPanel;

    public OyenteDeMovimiento(Panel p) {
        MiPanel = p;

    }

    @Override
    public void mouseDragged(MouseEvent evento) {

        Graphics2D g2d;
        if (MiPanel.getRectangulo() || MiPanel.getBorrar()) {
            if (MiPanel.getFigura() != null) {
                g2d = (Graphics2D) MiPanel.getGraphics();
                g2d.setXORMode(MiPanel.getBackground());
                g2d.setColor(MiPanel.getColorActual());
                g2d.draw(MiPanel.getFigura());
            }
            MiPanel.setp2(evento.getPoint());
            MiPanel.setFigura(MiPanel.crearRectangulo(MiPanel.getp1(), MiPanel.getp2()));
            g2d = (Graphics2D) MiPanel.getGraphics();
            g2d.setXORMode(MiPanel.getBackground());
            g2d.setColor(MiPanel.getColorActual());
            g2d.draw(MiPanel.getFigura());
        } else {
            if (MiPanel.getLinea()) {
                if (MiPanel.getFigura() != null) {
                    g2d = (Graphics2D) MiPanel.getGraphics();
                    g2d.setXORMode(MiPanel.getBackground());
                    g2d.setColor(MiPanel.getColorActual());
                    g2d.draw(MiPanel.getFigura());
                }
                MiPanel.setp2(evento.getPoint());
                MiPanel.setFigura(MiPanel.crearLinea(MiPanel.getp1(), MiPanel.getp2()));
                g2d = (Graphics2D) MiPanel.getGraphics();
                g2d.setXORMode(MiPanel.getBackground());
                g2d.setColor(MiPanel.getColorActual());
                g2d.draw(MiPanel.getFigura());
            }
        }
    }
}

