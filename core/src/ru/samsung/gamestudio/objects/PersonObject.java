package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PersonObject {

    private Texture texture;
    private float x, y;
    private float width = 100;
    private float height = 100;

    public PersonObject() {
        texture = new Texture("player.png");

        x = 200;
        y = 200;
    }

    public void update(float delta) {

    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }
}


