package mapEditor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
    private MapWindowFrame frame;
    private JMenu file = new JMenu("File");
    private JMenuItem create = new JMenuItem("New Map");
    private JMenuItem load = new JMenuItem("Load Map");
    private JMenuItem save = new JMenuItem("Save Map");

    public Menu(MapWindowFrame frame) {
        this.frame = frame;
        create.addActionListener(e -> createNewMap());
        load.addActionListener(e -> loadMap());
        save.addActionListener(e -> saveMap());
        file.add(create);
        file.add(save);
        file.add(load);
        add(file);
    }
    public void loadMap() {

    }
    public void createNewMap() {

    }
    public void saveMap() {

    }
}