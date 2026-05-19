package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.objects.PersonObject;
import ru.samsung.gamestudio.objects.EarthObject;

public class GameScreen extends ScreenAdapter {

    private MyGdxGame game;

    private PersonObject player;
    private EarthObject ground;

    private Texture leftBtn;
    private Texture rightBtn;

    private Texture jumpBtn;

    private float btnSize = 150;
    private Vector3 touch = new Vector3();

    public GameScreen(MyGdxGame game) {
        this.game = game;

        player = new PersonObject();
        ground = new EarthObject();

        leftBtn = new Texture("left1.png");
        rightBtn = new Texture("right1.png");
        jumpBtn = new Texture("jump1.png");
    }

    @Override
    public void render(float delta) {

        handleInput();

        ScreenUtils.clear(0, 0, 0, 1);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();

        // мир
        ground.draw(game.batch);
        player.draw(game.batch);

        // кнопки
        game.batch.draw(leftBtn, 50, 50, btnSize, btnSize);
        game.batch.draw(rightBtn, 250, 50, btnSize, btnSize);
        game.batch.draw(jumpBtn, 600, 50, btnSize, btnSize);


        game.batch.end();
    }

    private void handleInput() {



            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                player.moveLeft();
            }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                player.moveRight();
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                player.jump();
            }
        if (Gdx.input.isTouched()) {

            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.camera.unproject(touch);

            float x = touch.x;
            float y = touch.y;


            if (x >= 50 && x <= 50 + btnSize &&
                    y >= 50 && y <= 50 + btnSize) {

                player.moveLeft();
            }


            if (x >= 250 && x <= 250 + btnSize &&
                    y >= 50 && y <= 50 + btnSize) {

                player.moveRight();
            }
            if (x >= 600 && x <= 600 + btnSize &&
                    y >= 50 && y <= 50 + btnSize) {

                player.jump();
            }


        }
    }

    @Override
    public void dispose() {
        leftBtn.dispose();
        rightBtn.dispose();
        jumpBtn.dispose();
    }
}