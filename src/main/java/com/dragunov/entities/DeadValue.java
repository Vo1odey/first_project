package com.dragunov.entities;

public class DeadValue extends Entity {
    DeadValue(){
        super();
        picture = "\uD83D\uDC80";
    }

    @Override
    public String toString() {
        return picture;
    }
}
