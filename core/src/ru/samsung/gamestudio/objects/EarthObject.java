package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EarthObject {

    private Texture texture;
    private float x, y;
    private float width = 800;
    private float height = 100;

    public EarthObject() {
        texture = new Texture("ground.png");

        x = 0;
        y = 0;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }
}