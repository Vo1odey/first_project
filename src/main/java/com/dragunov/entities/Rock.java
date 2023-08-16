package com.dragunov.entities;
import com.dragunov.*;

//Статичный объект. Entities.Rock - камень.
public class Rock extends Entity {
    public Rock (Coordinates coordinates) {
        super(coordinates,"\uD83E\uDEA8");
    }

    @Override
    public String toString() {
        return picture;
    }
}

