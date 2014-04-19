package com.tamazombie.abstractModel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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
    public Color getColor();
    public float getRotation();
    public float getX();
    public float getY();
    public float getWidth();
    public float getHeight();
    public float getOriginX();
    public float getOriginY();
    public float getScaleX();
    public float getScaleY();

    public void draw(SpriteBatch spriteBatch);
    public void set(Sprite sprite);
    public void setTexture(Texture texture);
    public void setBounds(float x, float y, float width, float height);
    public void setSize(float width, float height);
    public void setPosition(float x, float y);
    public void setX(float x);
    public void setY(float y);
    public void setColor(Color tint);
    public void setColor(float r, float g, float b, float a);
    public void setColor(float color);
    public void translateX(float xAmount);
    public void translateY(float yAmount);
    public void translate(float xAmount, float yAmount);
    public void setOrigin(float originX, float originY);
    public void setRotation(float degrees);
    public void rotate(float degrees);
    public void setScale(float scaleXY);
    public void setScale(float scaleX, float scaleY);
    public void scale(float amount);

    public boolean intersect(int x, int y);
}
