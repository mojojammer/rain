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

    public Particle(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life;
        sprite = Sprite.particle_normal;
        particles.add(this);
    }

    public Particle(int x, int y, int life, int amount) {
        this(x, y, life); 
        // Doesn't create a new object just calls a function - in this case the relevant constructor
        // We also call this before the loop as we've already created a particle
        // - would be a waste to enter the loop and create another first (hence amount-1)

        for (int i = 0; i < amount -1; i++) {
            particles.add(new Particle(x, y, life));
        }
    }        

    public void update(){

    }

    public void render (Screen screen){

    }
}
