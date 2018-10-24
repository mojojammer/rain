package com.babak.rain.entity.mob;

import com.babak.rain.graphics.Screen;
import com.babak.rain.graphics.Sprite;
import com.babak.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0)
			move(xa, ya);
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0)
			sprite = sprite.player_forward;
		if (dir == 1) {
			sprite = sprite.player_side;
			flip = 1;
		}
		if (dir == 2)
			sprite = sprite.player_back;
		if (dir == 3)
			sprite = Sprite.player_side;
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}
