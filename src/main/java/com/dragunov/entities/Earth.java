package com.dragunov.entities;

import com.dragunov.Coordinates;

public class Earth extends Entity{

    public Earth(Coordinates coordinates) {
        super(coordinates, "\uD83D\uDFE6️");
    }

    @Override
    public String toString() {
        return picture;
    }
}
