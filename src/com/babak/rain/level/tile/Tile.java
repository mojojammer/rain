package com.babak.rain.level.tile;

import com.babak.rain.graphics.Screen;
import com.babak.rain.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}
}
