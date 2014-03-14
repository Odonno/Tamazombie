package com.tamazombie.commonModel;

/**
 * Created with IntelliJ IDEA.
 * User: David Bottiau
 * Date: 14/03/14
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public enum Gender {
    Male("Male"),
    Female("Female");

    private String _gender = "";

    Gender(String gender){
        _gender = gender;
    }

    @Override
    public String toString(){
        return _gender;
    }
}
