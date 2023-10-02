package com.dragunov.entities;
import com.dragunov.*;
//Статичный объект. Entities.Tree - дерево.
public class Sand extends Entity {
    public Sand(Coordinates coordinates) {
        super(coordinates,"\uD83D\uDFE8");
    }

    @Override
    public String toString() {
        return picture;
    }
}
