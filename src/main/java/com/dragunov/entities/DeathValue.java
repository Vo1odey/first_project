package com.dragunov.entities;

public class DeathValue extends Entity {
    DeathValue(){
        super();
        picture = "\uD83D\uDC80";
    }

    @Override
    public String toString() {
        return picture;
    }
}
