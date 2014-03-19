package com.tamazombie.abstractModel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 14/03/14
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public interface ISprite {
    Color getColor();
    float getRotation();
    float getX();
    float getY();
    float getWidth();
    float getHeight();
    float getOriginX();
    float getOriginY();
    float getScaleX();
    float getScaleY();

    void draw (SpriteBatch spriteBatch);
    void set (Sprite sprite);
    void setBounds(float x, float y, float width, float height);
    void setSize(float width, float height);
    void setPosition(float x, float y);
    void setX(float x);
    void setY(float y);
    void setColor(Color tint);
    void setColor(float r, float g, float b, float a);
    void setColor(float color);
    void translateX(float xAmount);
    void translateY(float yAmount);
    void translate(float xAmount, float yAmount);
    void setOrigin(float originX, float originY);
    void setRotation(float degrees);
    void rotate(float degrees);
    void setScale(float scaleXY);
    void setScale(float scaleX, float scaleY);
    void scale(float amount);
}
