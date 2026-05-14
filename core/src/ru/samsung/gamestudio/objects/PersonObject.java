package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PersonObject {

    private Texture texture;
    private float x, y;
    private float width = 300;
    private float height = 500;

    public PersonObject() {
        texture = new Texture("player.png");

        x = 2;
        y = 0;
    }


    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }

    public void update(float delta) {

    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }
}