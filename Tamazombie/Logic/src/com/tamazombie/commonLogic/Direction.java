package com.tamazombie.commonLogic;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 21/03/14
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 */
public enum Direction {
    Left("Left", -1, 0),
    Right("Right", 1, 0),
    Top("Top", 0, 1),
    Down("Down", 0, -1);

    private String _direction = "";
    private int _x;
    private int _y;

    Direction(String direction, int x, int y){
        _direction = direction;
        _x = x;
        _y = y;
    }

    @Override
    public String toString(){
        return _direction;
    }

    public int GetX(){
        return _x;
    }

    public int GetY(){
        return _y;
    }
}
