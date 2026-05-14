package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.objects.PersonObject;
import ru.samsung.gamestudio.objects.EarthObject;

public class GameScreen extends ScreenAdapter {

    private MyGdxGame game;

    private PersonObject player;
    private EarthObject ground;

    public GameScreen(MyGdxGame game) {
        this.game = game;

        player = new PersonObject();
        ground = new EarthObject();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 1);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);

        game.batch.begin();
        ground.draw(game.batch);
        player.draw(game.batch);
        game.batch.end();
    }
}