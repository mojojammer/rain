package com.babak.rain.entity.mob;

import com.babak.rain.entity.Entity;
import com.babak.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2; // 0=north, 1=east, 2=south 3=east
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int c = 0; c < 4; c++) { // c stands for corner - checking all 4 corners
			int xt = ((x + xa) + c % 2 * 14 - 8) >> 4; // the c%2 or c/2 gives us 0,0/1,0/0,1/1,1 and we use the +(*a)-b
														// (last part) to set the glitch area
			int yt = ((y + ya) + c / 2 * 12 + 3) >> 4;
			if (level.getTile(xt, yt).solid())
				solid = true;
		}
		return solid;
	}

	public void render() {

	}

}
