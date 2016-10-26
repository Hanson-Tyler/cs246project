package com.tylerhanson.myfirstgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{

    private SpriteBatch batch;
    private BitmapFont font;
    private int screenWidth, screenHeight;
    private String message = "Press to start";
    private Texture img;
    private Sprite sprite;

    @Override
    public void create () {
        batch = new SpriteBatch();

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        font = new BitmapFont();
        font.setColor(Color.GREEN);
        font.getData().setScale(5);

        Gdx.input.setInputProcessor(this);

        img = new Texture("ship7.png");
        sprite = new Sprite(img);
    }



    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        GlyphLayout glyph = new GlyphLayout();
        glyph.setText(font, message);
        float x = screenWidth/2 - glyph.width/2;
        float y = screenHeight/2 + glyph.height/2;

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            sprite.setPosition(Gdx.input.getX() - sprite.getWidth()/2,
                    Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2);
        }
        if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            sprite.setPosition(Gdx.graphics.getWidth()/2 -sprite.getWidth()/2,
                    Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
        }

        batch.begin();
        font.draw(batch, message, x, y);
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        message = "Touch up at " + screenX + ", " + screenY;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        return false;
    }

    @Override
    public boolean scrolled(int amount) {

        return false;
    }

    
}
