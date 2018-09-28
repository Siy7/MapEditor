package mapEditor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TilePalette extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = -1160070051380608887L;
	private final MapWindowFrame frame;
	private int currentTile;
	private static int TILE_LINE_BREAK = 3;

	public TilePalette(final MapWindowFrame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(4 * 32, (frame.getCurrentMap().getTilesetList().size() / 4) * 32));
		// prevents flickering
		setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(final Graphics g) {
		final int totalTileNumber = frame.getCurrentMap().getTilesetList().size();
		int line = 0;
		int column = 0;
		for (int i = 0; i < totalTileNumber; i++) {
			final BufferedImage bufferedTileImage = frame.getCurrentMap().getTilesetList().get(i);
			g.drawImage(bufferedTileImage, column, line, this);
			// after four tiles, there is a line break (0..3) thus == 3(TILE_LINE_BREAK)
			if ((i % 4) == TILE_LINE_BREAK) {
				line++;
				column++;
			} else {
				column++;
			}
		}
	}

	public MapWindowFrame getFrame() {
		return frame;
	}

	public int getCurrentTile() {
		return currentTile;
	}

}
