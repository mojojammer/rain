package com.babak.rain.level.tile;

import com.babak.rain.graphics.Screen;
import com.babak.rain.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}
