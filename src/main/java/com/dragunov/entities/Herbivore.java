package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {
    BFS bfs = new BFS();
    private List<Coordinates> patch;

    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");

    }
    public Herbivore(){}
    @Override
    public String toString() {
        return picture;
    }


    public void makeMove (Herbivore herbivore, Maps map){
            patch = bfs.shortCut(herbivore, map);
            int i = patch.size() - 1;
            map.removeFromMap(herbivore.getCoordinates());
            herbivore.setCoordinates(patch.get(i - 1));
            map.addToMap(herbivore.getCoordinates(), herbivore);
    }
}
