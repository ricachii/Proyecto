
package archivo;

import java.io.File;

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