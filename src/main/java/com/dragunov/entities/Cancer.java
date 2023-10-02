package com.dragunov.entities;
import com.dragunov.Coordinates;

public class Cancer extends Entity {
    public Cancer(Coordinates coordinates) {
        super(coordinates,"\uD83E\uDD9E");
    }

    @Override
    public Coordinates getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public String toString() {
        return picture;
    }
}

