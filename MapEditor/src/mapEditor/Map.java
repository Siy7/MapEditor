package mapEditor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import helper.ErrorCode;
import helper.MapEditorException;

public class Map {
	private final int[][] mapEditorArray;
	private final List<BufferedImage> tilesetList = new ArrayList<>();

	public List<BufferedImage> getTilesetList() {
		return tilesetList;
	}

	private String mapName;
	private String tilesetFilename;
	private static final Logger LOGGER = Logger.getLogger(Map.class.getName());

	public Map(final int[][] mapEditorArray, final String tilesetFilename, final String mapName)
			throws MapEditorException {
		if ((tilesetFilename == null) || (mapName == null) || (mapEditorArray.length == 0)) {
			throw new MapEditorException("one ore more necessary map values are null or 0", ErrorCode.ERROR_0);
		}
		this.mapEditorArray = mapEditorArray;
		this.setTilesetFilename(tilesetFilename);
		this.setMapName(mapName);
		try {
			final BufferedImage tilesetImage = ImageIO.read(new File(tilesetFilename));
			final int height = tilesetImage.getHeight() / 32;
			final int width = tilesetImage.getWidth() / 32;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					final BufferedImage bufferedImageTile = tilesetImage.getSubimage(i * 32, j * 32, 32, 32);
					this.tilesetList.add(bufferedImageTile);
				}
			}
		} catch (final IOException e) {
			LOGGER.info(e.getMessage());
			System.err.println("Tileset " + tilesetFilename + " nicht gefunden.");
		}
	}

	public BufferedImage getTileImage(final int x, final int y) {
		final int tile = mapEditorArray[x][y];
		return tilesetList.get(tile);
	}

	public void setTile(final int x, final int y, final int tileID) {
		this.mapEditorArray[x][y] = tileID;
	}

	public String getTilesetFilename() {
		return tilesetFilename;
	}

	public void setTilesetFilename(final String tilesetFilename) {
		this.tilesetFilename = tilesetFilename;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(final String mapName) {
		this.mapName = mapName;
	}

}
