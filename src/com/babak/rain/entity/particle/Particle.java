package com.babak.rain.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.babak.rain.graphics.Sprite;
import com.babak.rain.entity.Entity;
import com.babak.rain.graphics.Screen;

public class Particle extends Entity {

    private List<Particle> particles = new ArrayList<Particle>();
    private Sprite sprite;

    private int life;

    protected double xx, yy, xa, ya;

    public Particle(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.xx = x;
        this.yy = y;
        this.life = life;
        sprite = Sprite.particle_normal;

        this.xa = random.nextGaussian();
        this.ya = random.nextGaussian();
    }

    public Particle(int x, int y, int life, int amount) {
        this(x, y, life); 
        // Doesn't create a new object just calls a function - in this case the relevant constructor
        // We also call this before the loop as we've already created a particle
        // - would be a waste to enter the loop and create another first (hence amount-1)

        for (int i = 0; i < amount -1; i++) {
            particles.add(new Particle(x, y, life));
        }
        particles.add(this); // add the original this from above (first call in this constructor)
    }        

    public void update(){
        this.xx += xa;
        this.yy += ya;
        
    }

    public void render (Screen screen){
        screen.renderSprite((int)xx, (int)yy, sprite, true);
    }
}
