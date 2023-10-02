package com.dragunov.entities;
import com.dragunov.Coordinates;

// Ресурс для травоядных. Entities.Grass - трава.
public class Cancer extends Entity {
    public Cancer(Coordinates coordinates) {
        super(coordinates,"\uD83E\uDD9E");

    }
    public Cancer(){

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

