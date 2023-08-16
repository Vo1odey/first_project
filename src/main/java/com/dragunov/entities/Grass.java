package com.dragunov.entities;
import com.dragunov.Coordinates;
import com.dragunov.Maps;

import java.util.*;

// Ресурс для травоядных. Entities.Grass - трава.
public class Grass extends Entity {
    public Grass (Coordinates coordinates) {
        super(coordinates,"🧀");

    }
    public Grass(){

    }

    public static List <Grass> getAllGrass (Maps maps) {
        List <Grass> grasses = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> entry: maps.entities.entrySet()) {
            Entity entity = entry.getValue();
            if (entity instanceof Grass) grasses.add((Grass) entity);
        }
        return grasses;
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

