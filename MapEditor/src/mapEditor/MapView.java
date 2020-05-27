package mapEditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RepaintManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class MapView extends JPanel {
    /**
     * default serialVersionUID...
     */
    private static final long serialVersionUID = 1L;
    private final MapWindowFrame window;
    private JScrollPane scrollPane = new JScrollPane();
    private final RepaintManager manager;

    public MapView(final MapWindowFrame window) {
        this.window = window;
        scrollPane.setViewportView(this);
        setDoubleBuffered(true);
        changeMap();
        manager = RepaintManager.currentManager(window);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent  e) {
                drawTileByClick(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(final MouseEvent e) {
				drawTileByClick(e.getX(), e.getY());
			}
		});
    }

    @Override
    public void paintComponent(final Graphics g) {
        final Rectangle rect = g.getClipBounds();
        int startx = rect.x;
        int starty = rect.y;
        int endx = startx + rect.width;
        int endy = starty + rect.height;

        startx = startx / 32;
        starty = starty / 32;

        endx = endx / 32;
        endy = endy / 32;

        if (endx < window.getCurrentMap().getMapEditorArray().length) {
            endx++;
        }
        if (endy < window.getCurrentMap().getMapEditorArray()[0].length) {
            endy++;
        }
        for (int x = startx; x < endx; x++) {
            for (int y = starty; y < endy; y++) {
                final BufferedImage tile = window.getCurrentMap().getTileImage(x, y);
                g.drawImage(tile, x * 32, y * 32, this);
            }
        }
    }

    public void changeMap() {
        final int dx = window.getCurrentMap().getMapEditorArray().length;
        final int dy = window.getCurrentMap().getMapEditorArray()[0].length;
        setPreferredSize(new Dimension(dx * 32, dy * 32));
        scrollPane.setViewportView(this);
    }

    public void drawTileByClick(int x, int y) {
        x = x / 32;
        y = y / 32;
        window.getCurrentMap().getMapEditorArray()[x][y] = window.getTilePalette().getCurrentTile();
        final Rectangle r = scrollPane.getViewport().getViewRect();
        final int dx = this.scrollPane.getLocation().x + window.getInsets().left - r.x;
        final int dy = this.scrollPane.getLocation().y + window.getInsets().top - r.y;
        manager.addDirtyRegion(window, dx+x*32, dy+y*32, 32, 32);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(final JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}