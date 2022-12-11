
package proyecto;

import java.io.File;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


class MyFileFilter extends javax.swing.filechooser.FileFilter {
        private String extension;
        private String description;

        public MyFileFilter(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }
        @Override
        public boolean accept(File f) {
            return f.getName().toLowerCase().endsWith("."+extension) || f.isDirectory();
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        public String getExtension() {
            return extension;
        }
    }
