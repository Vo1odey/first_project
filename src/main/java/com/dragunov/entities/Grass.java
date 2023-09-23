package com.dragunov.entities;
import com.dragunov.Coordinates;
import com.dragunov.Maps;

import java.util.*;

// Ресурс для травоядных. Entities.Grass - трава.
public class Grass extends Entity {
    public Grass (Coordinates coordinates) {
        super(coordinates,"\uD83E\uDD9E");

    }
    public Grass(){

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

