package com.dragunov.entities;

import com.dragunov.Coordinates;

public class Water extends Entity{

    public Water(Coordinates coordinates) {
        super(coordinates, "\uD83D\uDFE6️");
    }

    @Override
    public String toString() {
        return picture;
    }
}
