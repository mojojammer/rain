package com.babak.rain.level;

import com.babak.rain.graphics.Screen;

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

	}

	private void loadLevel(String path) {

	}

	public void update() {

	}

	private void tim() {

	}

	public void render(int xScroll, int yScroll, Screen screen) { // xScroll/yScroll is position of the player
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4; // contrary to how it looks /16 is scaling by tiles not pixels which is
												// what we want - i.e. setting pins to tiles (e.g. position 32,0 is
												// pixels, we want 2,0 - the tile) - using tile precision
												// NOT pixel position
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
	}

}
