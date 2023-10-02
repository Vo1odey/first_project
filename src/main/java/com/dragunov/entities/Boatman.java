package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Field;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Boatman extends Creature {
    BFS bfs = new BFS();
    CreatureGenerator generate = new CreatureGenerator();

    public Boatman(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "\uD83D\uDEA3");
    }
    public Boatman getHerbivore(Boatman boatman){
        return boatman;
    }
    public Boatman(){}
    @Override
    public String toString() {
        return picture;
    }

    public void makeMove (Field map) {
        List<Boatman> hrbList = bfs.getHrbList(map);
        Boatman boatman;
        Queue<Boatman> qHrb = new LinkedList<>(hrbList);

        while (!qHrb.isEmpty()){
            boatman = qHrb.poll();
            eat(boatman, map);
            if ((map.getValue(boatman.getCoordinates()) instanceof Boatman)) {
                generate.generateGoalEntity(boatman, map);
                Stack<Coordinates> patch = bfs.shortCut(boatman, map);
                if (!patch.isEmpty()) {
                    patch.pop();
                    if (map.getValue(patch.peek()) instanceof Boatman) {
                        //System.out.println("Не ходить на мышь!");
                        patch.pop();
                    }
                    map.removeFromMap(boatman.getCoordinates());
                    boatman.setCoordinates(patch.pop());
                    map.mapPut(boatman.getCoordinates(), boatman);
                }
            }
        }
    }
    public void fearPredator (Boatman boatman, Field map) {
        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new LinkedList<>();
        Column[] upCrd = Column.values();
        Coordinates node = boatman.getCoordinates();
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
            if (map.getValue(qCrd.poll()) instanceof Shark) {
                System.out.println("there's a cat nearby!");

            }
        }
    }
    public void eat (Boatman boatman, Field map){
        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new LinkedList<>();
        Column[] upCrd = Column.values();
        Coordinates node = boatman.getCoordinates();
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
            if (map.getValue(goal) instanceof Cancer) {
                map.removeFromMap(goal);

            }
        }
    }
}
