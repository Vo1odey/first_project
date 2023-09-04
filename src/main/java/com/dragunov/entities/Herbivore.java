package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {

static Queue <Coordinates> qGrass = new LinkedList<>();
static List <Coordinates> visited = new ArrayList<>();
    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");
    }
    public Herbivore(){}

    @Override
    public String toString() {
        return picture;
    }

    public void makeMove(Maps maps, Herbivore herbivore) {

    }
}
