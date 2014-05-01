package com.tamazombie.concreteView;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public void Draw(SpriteBatch spriteBatch) {
        _labelName.draw(spriteBatch, 1f);
        _labelValue.draw(spriteBatch, 1f);
    }
}
