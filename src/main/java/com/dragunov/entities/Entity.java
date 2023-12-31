package com.dragunov.entities;
import com.dragunov.*;

abstract public class Entity {
    String picture;
    Coordinates coordinates;

    public Entity (Coordinates coordinates, String picture) {
        this.picture = picture;
        this.coordinates = coordinates;
    }
    public Entity(){
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates.setCoordinates(coordinates);
    }

    public Coordinates getCoordinates () {
        return coordinates;
    }

}