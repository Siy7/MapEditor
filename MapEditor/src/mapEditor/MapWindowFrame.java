package mapEditor;

import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.JFrame;

public class MapWindowFrame extends JFrame implements Serializable {

	/**
	 * generated serial version UID
	 */
	private static final long serialVersionUID = 3898539388886809354L;
	private Map currentMap;
	private TilePalette tilePalette;

	public MapWindowFrame() throws Exception {
		this.requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final int mapArray[][] = new int[100][100];
		final String mapName = "Our first map!";
		final String tilesetFilename = "Tileset.png";
		currentMap = new Map(mapArray, tilesetFilename, mapName);
		tilePalette = new TilePalette(this);
		setTitle("Karteneditor");
		setLayout(new BorderLayout());
		add(tilePalette, BorderLayout.WEST);
		setSize(1024, 768);
	}

	public Map getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(final Map currentMap) {
		this.currentMap = currentMap;
	}

	public TilePalette getTilePalette() {
		return tilePalette;
	}

	public void setTilePalette(final TilePalette tilePalette) {
		this.tilePalette = tilePalette;
	}
}
