package com.dragunov.entities;
import com.dragunov.*;
//Статичный объект. Entities.Tree - дерево.
public class Tree extends Entity {
    public Tree (Coordinates coordinates) {
        super(coordinates,"\uD83D\uDFE8");
    }

    @Override
    public String toString() {
        return picture;
    }
}
