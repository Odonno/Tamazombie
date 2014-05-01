package com.tamazombie.concreteView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.tamazombie.abstractView.ITextProgressBar;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 01/05/14
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public final class TextProgressBar implements ITextProgressBar {
    private Label _labelName;
    private Label _labelValue;
    private boolean _valueVisible = true;
    private String _text;
    private int _min;
    private int _max;
    private int _value;

    public TextProgressBar(String text) {
        _min = 0;
        _max = 100;
        _value = _min;
        _text = text;

        _labelName = new Label(_text, new Label.LabelStyle());
        _labelValue = new Label(_min + "/" + _max, new Label.LabelStyle());
    }

    public TextProgressBar(String text, int min, int max) {
        _min = min;
        _max = max;
        _value = _min;
        _text = text;

        _labelName = new Label(_text, new Label.LabelStyle());
        _labelValue = new Label(_min + "/" + _max, new Label.LabelStyle());
    }

    public TextProgressBar(String text, int min, int max, int value) {
        _min = min;
        _max = max;
        _value = value;
        _text = text;

        _labelName = new Label(_text, new Label.LabelStyle());
        _labelValue = new Label(_value + "/" + _max, new Label.LabelStyle());
    }


    private void refreshText() {
        _labelName.setText(_text);
    }

    private void refreshValue(){
        _labelValue.setText(_value + "/" + _max);
    }

    @Override
    public void setText(String text) {
        _text = text;
        refreshText();
    }

    @Override
    public void setMin(int min) {
        if (_max <= min)
            return;
        _min = min;
        refreshValue();
    }

    @Override
    public void setMax(int max) {
        if (max <= _min)
            return;
        _max = max;
        refreshValue();
    }

    @Override
    public void setValue(int value) {
        if (value < _min)
            _value = _min;
        else if (value > _max)
            _value = _max;
        else
            _value = value;

        refreshValue();
    }

    @Override
    public void setPosition(Vector2 position) {
        _labelName.setPosition(position.x, position.y);
        _labelValue.setPosition(_labelName.getX() + _labelName.getWidth(), position.y);
    }

    @Override
    public void setPosition(int x, int y) {
        setPosition(new Vector2(x, y));
    }

    @Override
    public void Draw(SpriteBatch spriteBatch) {
        _labelName.draw(spriteBatch, 1f);
        _labelValue.draw(spriteBatch, 1f);
    }
}
