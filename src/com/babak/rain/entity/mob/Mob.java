package com.babak.rain.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.babak.rain.entity.Entity;
import com.babak.rain.entity.projectile.Projectile;
import com.babak.rain.entity.projectile.WizardProjectile;
import com.babak.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2; // 0=north, 1=east, 2=south 3=east
	protected boolean moving = false;

	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	public void move(int xa, int ya) {
		System.out.println("Size: " + projectiles.size());
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

	protected void shoot(int x, int y, double dir) {
		// dir *= 180 / Math.PI;
		Projectile p = new WizardProjectile(x, y, dir);
		projectiles.add(p);
		level.add(p);

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int c = 0; c < 4; c++) { // c stands for corner - checking all 4
										// corners
			// the c%2 or c/2 gives us 0,0/1,0/0,1/1,1 and we use the +(*a)-b
			// (last part) to set the glitch area
			// int xt = ((x + xa) + c % 2 * 32 - 16) >> 4; // This gives us the
			// sprite box (remember it's centred at -16,-16
			// int yt = ((y + ya) + c / 2 * 32 - 16) >> 4; // and the pink
			// surround is not drawn(!)
			int xt = ((x + xa) + c % 2 * 14 - 8) >> 4;
			int yt = ((y + ya) + c / 2 * 12 + 3) >> 4;
			if (level.getTile(xt, yt).solid())
				solid = true;
		}
		return solid;
	}

	public void render() {

	}

}
