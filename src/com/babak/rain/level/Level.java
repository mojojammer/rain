package com.babak.rain.level;

import com.babak.rain.graphics.Screen;
import com.babak.rain.level.tile.Tile;

public class Level {

	protected Tile[] tiles;
	protected int width, height;
	protected int[] tilesInt;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
		System.out.println("Tile::generateLevel");
	}

	protected void loadLevel(String path) {
	}

	public void update() {
	}

	private void time() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		// xScroll/yScroll is position of the player contrary to how it looks /16 is scaling by tiles not // pixels
		// which is what we want - i.e. setting pins to tiles (e.g. position 32,0 is pixels, we want 2,0 - the
		// tile) - using tile precision NOT pixel position
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				// getTile(x, y).render(x, y, screen);
				if (x + y * 16 < 0 || x + y * 16 >= 256) {
					Tile.voidTile.render(x, y, screen);
					continue;
				}
				tiles[x + y * 16].render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tilesInt[x + y * width] == 0)
			return Tile.grass;
		if (tilesInt[x + y * width] == 1)
			return Tile.rock;
		if (tilesInt[x + y * width] == 2)
			return Tile.flower;
		return Tile.voidTile;
	}

}
