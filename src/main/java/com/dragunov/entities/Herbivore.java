package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {
    BFS bfs = new BFS();
    GenerateEntity generate = new GenerateEntity();

    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");
    }
    public Herbivore getHerbivore(Herbivore herbivore){
        return herbivore;
    }
    public Herbivore(){}
    @Override
    public String toString() {
        return picture;
    }


    public void makeMove (Herbivore herbivore, Maps map){
        List <Herbivore> hrbList = new ArrayList<>();
        Queue<Coordinates> queue;
        //fearPredator(herbivore, map);
        //eat(herbivore, map);
        if ((map.getValue(herbivore.getCoordinates()) instanceof Herbivore)){
            generate.generateGoalEntity(herbivore, map);
            Stack<Coordinates> patch = bfs.shortCut(herbivore, map);
        if (!patch.isEmpty()) {
            patch.pop();
            if (map.getValue(patch.peek()) instanceof Herbivore){
                patch.pop();
            }
            map.removeFromMap(herbivore.getCoordinates());
            herbivore.setCoordinates(patch.pop());
            map.mapPut(herbivore.getCoordinates(), herbivore);
            }
        }
    }
    public void fearPredator (Herbivore herbivore, Maps map) {
        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new LinkedList<>();
        Vertical[] upCrd = Vertical.values();
        Coordinates node = herbivore.getCoordinates();
        //initialize left
        if ((node.getVertical().ordinal() - 1 != -1)) {
            left = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(left);
        }
        //initialize right
        if ((node.getVertical().ordinal() + 1 != 13)) {
            right = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() + 1]);
            qCrd.add(right);
        }
        //initialize up
        if ((node.getHorizontal() - 1 != 0)) {
            up = new Coordinates(node.getHorizontal() - 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(up);
        }
        //initialize down
        if ((node.getHorizontal() + 1 != 11)) {
            down = new Coordinates(node.getHorizontal() + 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(down);
        }
        while (!qCrd.isEmpty()) {
            if (map.getValue(qCrd.poll()) instanceof Predator) {
                System.out.println("there's a cat nearby!");

            }
        }
    }
    public void eat (Herbivore herbivore, Maps map){
        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new LinkedList<>();
        Vertical[] upCrd = Vertical.values();
        Coordinates node = herbivore.getCoordinates();
        Coordinates goal;
        //initialize left
        if ((node.getVertical().ordinal() - 1 != -1)) {
            left = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(left);
        }
        //initialize right
        if ((node.getVertical().ordinal() + 1 != 13)) {
            right = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() + 1]);
            qCrd.add(right);
        }
        //initialize up
        if ((node.getHorizontal() - 1 != 0)) {
            up = new Coordinates(node.getHorizontal() - 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(up);
        }
        //initialize down
        if ((node.getHorizontal() + 1 != 11)) {
            down = new Coordinates(node.getHorizontal() + 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(down);
        }
        while (!qCrd.isEmpty()) {
            goal = qCrd.poll();
            if (map.getValue(goal) instanceof Grass) {
                map.removeFromMap(qCrd.poll());
            }
        }
    }
}
