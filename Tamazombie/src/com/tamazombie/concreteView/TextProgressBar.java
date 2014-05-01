package com.tamazombie.concreteView;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.tamazombie.abstractView.ITextProgressBar;
import com.tamazombie.portableGame.MyLibgdxGame;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 01/05/14
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public final class TextProgressBar implements ITextProgressBar {
    private Label _label;
    private String _text;
    private int _min;
    private int _max;
    private int _value;


    public TextProgressBar() {
        _min = 0;
        _max = 100;
        _value = _min;
        _text = "";

        Label.LabelStyle labelStyle = new Label.LabelStyle(MyLibgdxGame.Font, Color.BLACK);
        _label = new Label(_text + _min + "/" + _max, labelStyle);
    }


    private void refreshLabel(){
        _label.setText(_text + _min + "/" + _max);
    }

    @Override
    public void setText(String text) {
        _text = text;
        refreshLabel();
    }

    @Override
    public void setMin(int min) {
        if (_max <= min)
            return;
        _min = min;
        refreshLabel();
    }

    @Override
    public void setMax(int max) {
        if (max <= _min)
            return;
        _max = max;
        refreshLabel();
    }

    @Override
    public void setValue(int value) {
        if (value < _min)
            _value = _min;
        else if (value > _max)
            _value = _max;
        else
            _value = value;

        refreshLabel();
    }

    @Override
    public void setPosition(Vector2 position) {
        _label.setPosition(position.x, position.y);
    }

    @Override
    public void setPosition(int x, int y) {
        setPosition(new Vector2(x, y));
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        _label.draw(spriteBatch, 1f);
    }
}
