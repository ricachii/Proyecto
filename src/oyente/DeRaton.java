
package oyente;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import pizarra.Panel;

class OyenteDeRaton extends MouseAdapter {
    Panel MiPanel;

    public OyenteDeRaton(Panel p) {
        MiPanel = p;

    }

    @Override
    public void mousePressed(MouseEvent evento) {
        MiPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        MiPanel.setp1(evento.getPoint());

        if (MiPanel.getBorrar()) {
            MiPanel.setColorAnterior(MiPanel.getColorActual());
            MiPanel.rellenoAnterior = MiPanel.relleno;
            MiPanel.setColorActual(Color.LIGHT_GRAY);
        }
    }

    @Override
    public void mouseReleased(MouseEvent evento) {
        MiPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if (MiPanel.getRectangulo()) {
            MiPanel.setp2(evento.getPoint());
            if (MiPanel.getp2() != null) {
                MiPanel.setFigura(MiPanel.crearRectangulo(MiPanel.getp1(), MiPanel.getp2()));
                MiPanel.repaint();
            }
        } else {
            if (MiPanel.getLinea()) {
                MiPanel.setp2(evento.getPoint());
                MiPanel.setFigura(MiPanel.crearLinea(MiPanel.getp1(), MiPanel.getp2()));
                MiPanel.repaint();
            } else {
                if (MiPanel.getBorrar()) {
                    MiPanel.setp2(evento.getPoint());

                    MiPanel.setColorActual(Color.WHITE);
                    MiPanel.relleno = true;

                    MiPanel.setFigura(MiPanel.borrarAlgo(MiPanel.getp1(), MiPanel.getp2()));
                    MiPanel.repaint();
                }
            }
        }
    }
}