package com.dragunov.entities;
import com.dragunov.*;

//Статичный объект. Entities.Rock - камень.
public class Rock extends Entity {
    public Rock (Coordinates coordinates) {
        super(coordinates,"\uD83C\uDF34");
    }

    @Override
    public String toString() {
        return picture;
    }
}

