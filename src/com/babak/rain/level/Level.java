package com.babak.rain.level;

import com.babak.rain.graphics.Screen;
import com.babak.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {
		System.out.println("Tile::generateLevel");
	}

	private void loadLevel(String path) {

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
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0)
			return Tile.grass;
		return Tile.voidTile;
	}

}
