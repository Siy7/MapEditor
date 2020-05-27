package mapEditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MapWindowFrame extends JFrame {

	/**
	 * generated serial version UID
	 */
	private static final long serialVersionUID = 3898539388886809354L;
	private Map currentMap;
	private TilePalette tilePalette;
	private MapView mapView;
	private Menu menu;

	public MapWindowFrame() throws Exception {
		this.requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final int[][] mapArray = new int[100][100];
		final String mapName = "Our first map!";
		final String tilesetFilename = "Tileset1.png";

		currentMap = new Map(mapArray, tilesetFilename, mapName);
		tilePalette = new TilePalette(this);

		mapView = new MapView(this);
		menu = new Menu(this);
		setLayout(new BorderLayout());
		add(tilePalette, BorderLayout.WEST);
		add(mapView.getScrollPane(), BorderLayout.CENTER);
		add(menu, BorderLayout.NORTH);
		add(tilePalette, BorderLayout.WEST);
		setSize(1024, 768);
		setTitle("Karteneditor");
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
