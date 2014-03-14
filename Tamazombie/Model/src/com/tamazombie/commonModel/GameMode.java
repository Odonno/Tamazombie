package com.tamazombie.commonModel;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 14/03/14
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public enum GameMode {
    ZombieMode("Zombie Mode"),
    HumanMode("Human Mode");

    private String _gameMode = "";

    GameMode(String gameMode){
        _gameMode = gameMode;
    }

    @Override
    public String toString(){
        return _gameMode;
    }
}
