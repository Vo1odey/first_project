package com.dragunov.entities;
import com.dragunov.*;

//Статичный объект. Entities.Rock - камень.
public class Palm extends Entity {
    public Palm(Coordinates coordinates) {
        super(coordinates,"\uD83C\uDF34");
    }

    @Override
    public String toString() {
        return picture;
    }
}

