package com.dragunov.entities;

import com.dragunov.Coordinates;

public class MouseHouse extends Entity{
    public MouseHouse (Coordinates coordinates){
        super(coordinates, "\uD83C\uDF11");
    }
    @Override
    public String toString() {
        return picture;
    }
}
