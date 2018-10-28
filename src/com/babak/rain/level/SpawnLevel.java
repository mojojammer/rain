package com.babak.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.babak.rain.level.tile.Tile;

public class SpawnLevel extends Level {

	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load level file!");
		}

	}

	// Grass = 0x04f520
	// Flower = 0xff0505
	// Rock = 0xa5a5a5
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0x04f520)
				tiles[i] = Tile.grass;
			if (levelPixels[i] == 0xff0505)
				tiles[i] = Tile.flower;
			if (levelPixels[i] == 0xa5a5a5)
				tiles[i] = Tile.rock;
		}

	}
}
