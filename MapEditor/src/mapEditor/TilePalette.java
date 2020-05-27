package mapEditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class TilePalette extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = -1160070051380608887L;
	private final MapWindowFrame windowFrame;
	private int currentTile = 2;
	private static int TILE_LINE_BREAK = 3;

	public TilePalette(final MapWindowFrame frame) {
		this.windowFrame = frame;
		setPreferredSize(new Dimension(4 * 32, (frame.getCurrentMap().getTilesetList().size() / 4) * 32));
		// prevents flickering
		setDoubleBuffered(true);
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				setTileID(e.getX(), e.getY());
			}
		});
	}

	@Override
	public void paintComponent(final Graphics g) {
		final int totalTileNumber = windowFrame.getCurrentMap().getTilesetList().size();
		int line = 0;
		int column = 0;
		for (int i = 0; i < totalTileNumber; i++) {
			final BufferedImage bufferedTileImage = windowFrame.getCurrentMap().getTilesetList().get(i);
			g.drawImage(bufferedTileImage, column * 32, line * 32, this);
			// after four tiles, there is a line break (0..3) thus == 3(TILE_LINE_BREAK)
			if ((i % 4) == TILE_LINE_BREAK) {
				line++;
				column = 0;
			} else {
				column++;
			}
		}
	}

	public void setTileID(int x, int y) {
		int column = x / 32;
		int row = y / 32;
		int tileID = row * 4 + column;
		if (tileID < windowFrame.getCurrentMap().getTilesetList().size()) {
			currentTile = tileID;
		}
	}

	public MapWindowFrame getFrame() {
		return windowFrame;
	}

	public int getCurrentTile() {
		return currentTile;
	}

}
