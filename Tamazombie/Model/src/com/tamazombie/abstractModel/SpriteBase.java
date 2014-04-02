package com.tamazombie.abstractModel;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 14/03/14
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public abstract class SpriteBase extends Sprite implements ISprite {
    protected Texture _texture;
    protected Color _color = new Color(1, 1, 1, 1);
    protected float _x, _y;
    protected float _width, _height;
    protected float _originX, _originY;
    protected float _rotation;
    protected float _scaleX = 1, _scaleY = 1;


    /** Creates an uninitialized sprite. The sprite will need a texture region and bounds set before it can be drawn. */
    public SpriteBase () {
    }

    /** Creates a sprite with width, height, and texture region equal to the size of the texture. */
    public SpriteBase (Texture texture) {
        this(texture, texture.getWidth(), texture.getHeight());
    }

    /** Creates a sprite with width, height, and texture region equal to the specified size.
     * @param srcWidth The width of the texture region. May be negative to flip the sprite when drawn.
     * @param srcHeight The height of the texture region. May be negative to flip the sprite when drawn. */
    public SpriteBase(Texture texture, int srcWidth, int srcHeight) {
        if (texture == null)
            throw new IllegalArgumentException("texture cannot be null.");
        _texture = texture;
        setSize(Math.abs(srcWidth), Math.abs(srcHeight));
        setOrigin(_width / 2, _height / 2);
    }

    // Note the region is copied.
    /** Creates a sprite based on a specific TextureRegion, the new sprite's region is a copy of the parameter region - altering one
     * does not affect the other */
    public SpriteBase (TextureRegion region) {
        setSize(region.getRegionWidth(), region.getRegionHeight());
        setOrigin(_width / 2, _height / 2);
    }

    /** Creates a sprite with width, height, and texture region equal to the specified size, relative to specified sprite's texture
     * region.
     * @param srcWidth The width of the texture region. May be negative to flip the sprite when drawn.
     * @param srcHeight The height of the texture region. May be negative to flip the sprite when drawn. */
    public SpriteBase(int srcWidth, int srcHeight) {
        setSize(Math.abs(srcWidth), Math.abs(srcHeight));
        setOrigin(_width / 2, _height / 2);
    }

    /** Creates a sprite that is a copy in every way of the specified sprite. */
    public SpriteBase (Sprite sprite) {
        set(sprite);
    }



    /** Returns the color of this sprite. Changing the returned color will have no affect, {@link #setColor(Color)} or
     * {@link #setColor(float, float, float, float)} must be used. */
    @Override
    public Color getColor() {
        return _color;
    }

    /** @return the rotation of the sprite in degrees */
    @Override
    public float getRotation() {
        return _rotation;
    }

    @Override
    public float getX() {
        return _x;
    }

    @Override
    public float getY() {
        return _y;
    }

    /** @return the width of the sprite, not accounting for scale. */
    @Override
    public float getWidth() {
        return _width;
    }

    /** @return the height of the sprite, not accounting for scale. */
    @Override
    public float getHeight() {
        return _height;
    }

    /** The origin influences {@link #setPosition(float, float)}, {@link #setRotation(float)} and the expansion direction of scaling
     * {@link #setScale(float, float)} */
    @Override
    public float getOriginX() {
        return _originX;
    }

    /** The origin influences {@link #setPosition(float, float)}, {@link #setRotation(float)} and the expansion direction of scaling
     * {@link #setScale(float, float)} */
    @Override
    public float getOriginY() {
        return _originY;
    }

    /** X scale of the sprite, independent of size set by {@link #setSize(float, float)} */
    @Override
    public float getScaleX() {
        return _scaleX;
    }

    /** Y scale of the sprite, independent of size set by {@link #setSize(float, float)} */
    @Override
    public float getScaleY() {
        return _scaleY;
    }



    @Override
    public void draw (SpriteBatch spriteBatch) {
        spriteBatch.setColor(_color);
        spriteBatch.draw(_texture, _x, _y, _width / 2, _height / 2, _width, _height, _scaleX, _scaleY, _rotation, 0, 0, (int)_width, (int)_height, false, false);
        spriteBatch.setColor(Color.WHITE);
    }

    /** Make this sprite a copy in every way of the specified sprite */
    @Override
    public void set(Sprite sprite) {
        if (sprite == null) throw new IllegalArgumentException("sprite cannot be null.");
        _texture = sprite.getTexture();
        _x = sprite.getX();
        _y = sprite.getY();
        _width = sprite.getWidth();
        _height = sprite.getHeight();
        _originX = sprite.getOriginX();
        _originY = sprite.getOriginY();
        _rotation = sprite.getRotation();
        _scaleX = sprite.getScaleX();
        _scaleY = sprite.getScaleY();
        _color.set(sprite.getColor());
    }

    @Override
    public void setTexture(Texture texture){
        _texture = texture;
        _width = texture.getWidth();
        _height = texture.getHeight();
    }

    /** Sets the position and size of the sprite when drawn, before scaling and rotation are applied. If origin, rotation, or scale
     * are changed, it is slightly more efficient to set the bounds after those operations. */
    @Override
    public void setBounds(float x, float y, float width, float height) {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    /** Sets the size of the sprite when drawn, before scaling and rotation are applied. If origin, rotation, or scale are changed,
     * it is slightly more efficient to set the size after those operations. If both position and size are to be changed, it is
     * better to use {@link #setBounds(float, float, float, float)}. */
    @Override
    public void setSize(float width, float height) {
        _width = width;
        _height = height;
    }

    /** Sets the position where the sprite will be drawn. If origin, rotation, or scale are changed, it is slightly more efficient
     * to set the position after those operations. If both position and size are to be changed, it is better to use
     * {@link #setBounds(float, float, float, float)}. */
    @Override
    public void setPosition(float x, float y) {
        translate(x - _x, y - _y);
    }

    /** Sets the x position where the sprite will be drawn. If origin, rotation, or scale are changed, it is slightly more efficient
     * to set the position after those operations. If both position and size are to be changed, it is better to use
     * {@link #setBounds(float, float, float, float)}. */
    @Override
    public void setX(float x) {
        translateX(x - _x);
    }

    /** Sets the y position where the sprite will be drawn. If origin, rotation, or scale are changed, it is slightly more efficient
     * to set the position after those operations. If both position and size are to be changed, it is better to use
     * {@link #setBounds(float, float, float, float)}. */
    @Override
    public void setY(float y) {
        translateY(y - _y);
    }

    /** Sets the color used to tint this sprite. Default is {@link Color#WHITE}. */
    @Override
    public void setColor(Color tint) {
        _color = new Color(tint.r, tint.g, tint.b, tint.a);
    }

    /**
     * Set the color
     * @see {@link #setColor(float, float, float, float)}. */
    @Override
    public void setColor(float r, float g, float b, float a) {
        _color = new Color(r, g, b, a);
    }

    /** Set the color
     * @see {@link #setColor(float)}. */
    @Override
    public void setColor(float color) {
        _color = new Color(color, color, color, 1);
    }

    /** Sets the x position relative to the current position where the sprite will be drawn. If origin, rotation, or scale are
     * changed, it is slightly more efficient to translate after those operations. */
    @Override
    public void translateX(float xAmount) {
        _x += xAmount;
    }

    /** Sets the y position relative to the current position where the sprite will be drawn. If origin, rotation, or scale are
     * changed, it is slightly more efficient to translate after those operations. */
    @Override
    public void translateY(float yAmount) {
        _y += yAmount;
    }

    /** Sets the position relative to the current position where the sprite will be drawn. If origin, rotation, or scale are
     * changed, it is slightly more efficient to translate after those operations. */
    @Override
    public void translate(float xAmount, float yAmount) {
        _x += xAmount;
        _y += yAmount;
    }

    /** Sets the origin in relation to the sprite's position for scaling and rotation. */
    @Override
    public void setOrigin(float originX, float originY) {
        _originX = originX;
        _originY = originY;
    }

    /** Sets the rotation of the sprite in degrees. Rotation is centered on the origin set in {@link #setOrigin(float, float)} */
    @Override
    public void setRotation(float degrees) {
        _rotation = degrees;
    }

    /** Sets the sprite's rotation in degrees relative to the current rotation. Rotation is centered on the origin set in
     * {@link #setOrigin(float, float)} */
    @Override
    public void rotate(float degrees) {
        if(degrees == 0)
            return;
        _rotation += degrees;
    }

    /** Sets the sprite's scale for both X and Y uniformly. The sprite scales out from the origin. This will not affect the values
     * returned by {@link #getWidth()} and {@link #getHeight()} */
    @Override
    public void setScale(float scaleXY) {
        _scaleX = scaleXY;
        _scaleY = scaleXY;
    }

    /** Sets the sprite's scale for both X and Y. The sprite scales out from the origin. This will not affect the values returned by
     * {@link #getWidth()} and {@link #getHeight()} */
    @Override
    public void setScale(float scaleX, float scaleY) {
        _scaleX = scaleX;
        _scaleY = scaleY;
    }

    /** Sets the sprite's scale relative to the current scale. for example: original scale 2 -> sprite.scale(4) -> final scale 6.
     * The sprite scales out from the origin. This will not affect the values returned by {@link #getWidth()} and
     * {@link #getHeight()} */
    @Override
    public void scale(float amount) {
        _scaleX += amount;
        _scaleY += amount;
    }

    /**
     * Check if the pixel (x, y) is inside the Sprite
     * @param x X value of pixel
     * @param y Y value of pixel
     * @return Return true if the pixel is inside the Sprite
     */
    @Override
    public boolean intersect(int x, int y){
        float _scaleWidth = getWidth() * _scaleX;
        float _scaleHeight = getHeight() * _scaleY;

        return (x > getX() && x < getX() + _scaleWidth && y > getY() && y < getY() + _scaleHeight);
    }
}
