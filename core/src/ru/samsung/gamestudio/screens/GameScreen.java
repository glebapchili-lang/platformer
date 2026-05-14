package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
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

    private float btnSize = 150;
    private Vector3 touch = new Vector3();

    public GameScreen(MyGdxGame game) {
        this.game = game;

        player = new PersonObject();
        ground = new EarthObject();

        leftBtn = new Texture("left1.png");
        rightBtn = new Texture("right1.png");
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

        game.batch.end();
    }

    private void handleInput() {

        if (Gdx.input.isTouched()) {

            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.camera.unproject(touch);

            float x = touch.x;
            float y = touch.y;

            // левая кнопка
            if (x >= 50 && x <= 50 + btnSize &&
                    y >= 50 && y <= 50 + btnSize) {

                player.moveLeft();
            }

            // правая кнопка
            if (x >= 250 && x <= 250 + btnSize &&
                    y >= 50 && y <= 50 + btnSize) {

                player.moveRight();
            }
        }
    }

    @Override
    public void dispose() {
        leftBtn.dispose();
        rightBtn.dispose();
    }
}