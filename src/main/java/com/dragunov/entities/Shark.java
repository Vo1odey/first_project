package com.dragunov.entities;
import com.dragunov.*;

import java.util.*;

public class Shark extends Creature {
    int attack;
    public Shark(Coordinates coordinates, int speed, int hp, int attack){
        super(coordinates, speed, hp, "\uD83E\uDD88");
        this.attack = attack;
    }
    int count = 0;
    BFS bfs = new BFS();
    CreatureGenerator generate = new CreatureGenerator();

    @Override
    public String toString() {
        return picture;
    }
    public void makeMove (Shark shark, Field map) {
        try {
        if ((map.getValue(shark.getCoordinates()) instanceof Shark)){
        generate.generateGoalEntity(shark, map);
        attack(shark, map);
        Stack<Coordinates> patch = bfs.destination(shark, map);
        if (patch.size() != 2) {
            patch.pop();
            map.remove(shark.getCoordinates());
            shark.setCoordinates(patch.pop());
            map.put(shark.getCoordinates(), shark);
        }
            }
        } catch (EmptyStackException e) {
            makeMove();
        }
    }
    private void attack(Shark shark, Field map) {
        Coordinates goal = bfs.poll(shark,map);

        Queue <Coordinates> qCrd = new LinkedList<>();
        Column[] upCrd = Column.values();
        Coordinates node = shark.getCoordinates();

        Coordinates left;
        Coordinates leftUp;
        Coordinates leftDown;

        Coordinates right;
        Coordinates rightUp;
        Coordinates rightDown;

        Coordinates up;
        Coordinates down;

        //initialize left
        if ((node.getY().ordinal() - 1 != -1)) {
            left = new Coordinates(node.getX() ,upCrd[node.getY().ordinal() - 1]);
            qCrd.add(left);
        }
        //initialize leftUp ^<-
        if ((node.getY().ordinal() - 1 != -1) && (node.getX() - 1 != 0)) {
            leftUp = new Coordinates(node.getX() - 1, upCrd[node.getY().ordinal() - 1]);
            qCrd.add(leftUp);
        }

        //initialize leftDown v<-
        if ((node.getY().ordinal() - 1 != -1) && (node.getX() + 1 != 11)) {
            leftDown = new Coordinates(node.getX() + 1, upCrd[node.getY().ordinal() - 1]);
            qCrd.add(leftDown);
        }

        //initialize rightUp ->^
        if ((node.getY().ordinal() + 1 != 13) && (node.getX() - 1 != 0)) {
            rightUp = new Coordinates(node.getX() - 1 , upCrd[node.getY().ordinal() + 1]);
            qCrd.add(rightUp);
        }

        //initialize rightDown ->V
        if ((node.getY().ordinal() + 1 != 13) && (node.getX() + 1 != 11)) {
            rightDown = new Coordinates(node.getX() + 1 , upCrd[node.getY().ordinal() + 1]);
            qCrd.add(rightDown);
        }

        //initialize right
        if ((node.getY().ordinal() + 1 != 13)) {
            right = new Coordinates(node.getX() ,upCrd[node.getY().ordinal() + 1]);
            qCrd.add(right);
        }
        //initialize up
        if ((node.getX() - 1 != 0)) {
            up = new Coordinates(node.getX() - 1 ,upCrd[node.getY().ordinal()]);
            qCrd.add(up);
        }
        //initialize down
        if ((node.getX() + 1 != 11)) {
            down = new Coordinates(node.getX() + 1 ,upCrd[node.getY().ordinal()]);
            qCrd.add(down);
        }

        while (!qCrd.isEmpty()) {
            qCrd.poll();
            if (map.getValue(qCrd.peek()) instanceof Boatman boatman) {
                boatman.setHp(boatman.getHp() - shark.attack);
                if (boatman.getHp() <= 0) {
                    map.remove(goal);
                    map.put(goal, new DeadValue());
                    count++;
                }
            }
        }
    }
}

