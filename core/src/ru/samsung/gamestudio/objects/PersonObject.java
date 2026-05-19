package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PersonObject {

    private Texture texture;
    private float x, y;
    private float width = 300;
    private float height = 500;
    private float speed = 5;

    Texture[] framesArray;

    public PersonObject() {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        framesArray = new Texture[]{
                new Texture("player.png"),
                new Texture("playerRUN1.png"),
                new Texture("playerRUN2.png"),
        };
    }


    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }

     public void jump(){
         y+= 50;
     }
    public void update(float delta) {

    }
    int frameCounter;

    public void draw(Batch batch) {
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }
}