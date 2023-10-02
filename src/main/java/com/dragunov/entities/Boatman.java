package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Field;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Boatman extends Creature {
    BFS bfs = new BFS();
    CreatureGenerator createNewBoatman = new CreatureGenerator();

    public Boatman(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "\uD83D\uDEA3");
    }
    public Boatman getBoatman(Boatman boatman){
        return boatman;
    }
    public Boatman(){}
    @Override
    public String toString() {
        return picture;
    }

    public void makeMove (Field map) {
        List<Boatman> boatmen = bfs.getAllBoatmen(map);
        Queue<Boatman> qBoatmen = new LinkedList<>(boatmen);
        Stack<Coordinates> pathToCancer;
        Boatman nextBoatman;

        while (!qBoatmen.isEmpty()){
            nextBoatman = qBoatmen.poll();
            lookForCancer(nextBoatman, map);
            if (map.getValue(nextBoatman.getCoordinates()) instanceof Boatman) {
                createNewBoatman.generateGoalEntity(nextBoatman, map);
                pathToCancer = bfs.destination(nextBoatman, map);
                if (!pathToCancer.isEmpty()) {
                    pathToCancer.pop();
                    if (map.getValue(pathToCancer.peek()) instanceof Boatman) {
                        continue;
                    }
                    map.removeFromMap(nextBoatman.getCoordinates());
                    nextBoatman.setCoordinates(pathToCancer.pop());
                    map.mapPut(nextBoatman.getCoordinates(), nextBoatman);
                }
            }
        }
    }

    public void lookForCancer(Boatman boatman, Field map){
        Coordinates left;
        Coordinates right;
        Coordinates up;
        Coordinates down;

        Queue <Coordinates> lookAround = new LinkedList<>();
        Column[] columnValues = Column.values();
        Coordinates node = boatman.getCoordinates();

        //look left
        if ((node.getY().ordinal() - 1) != -1) {
            left = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() - 1]);
            lookAround.add(left);
        }
        //look right
        if ((node.getY().ordinal() + 1) != 13) {
            right = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() + 1]);
            lookAround.add(right);
        }
        //look up
        if ((node.getX() - 1) != 0) {
            up = new Coordinates(node.getX() - 1 ,columnValues[node.getY().ordinal()]);
            lookAround.add(up);
        }
        //look down
        if ((node.getX() + 1) != 11) {
            down = new Coordinates(node.getX() + 1 ,columnValues[node.getY().ordinal()]);
            lookAround.add(down);
        }

        Coordinates goal;
        while (!lookAround.isEmpty()) {
            goal = lookAround.poll();
            if (map.getValue(goal) instanceof Cancer) {
                map.removeFromMap(goal);
            }
        }
    }
}
