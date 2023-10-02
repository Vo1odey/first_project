package com.dragunov.entities;

import com.dragunov.Coordinates;

public class House extends Entity{
    public House(Coordinates coordinates){
        super(coordinates, "\uD83C\uDFE0");
    }
    @Override
    public String toString() {
        return picture;
    }
}
