package mapEditor;

import java.lang.reflect.Constructor;

import javax.swing.JDialog;

public class MapDialog extends JDialog {
    MapWindowFrame frame;

    public MapDialog(MapWindowFrame frame) {
        super(frame, "Create Map");
        this.frame = frame;
    }
}