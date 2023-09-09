package com.dragunov.entities;
import com.dragunov.*;

import java.util.*;

//Хищник, наследуется от Entities.Creature. В дополнение к полям
//класса Entities.Creature, имеет силу атаки. Может потратить ход:
//Переместиться (приблизится к травоядному Entities.Herbivore)
//Атаковать травоядное. При этом кол-во HP травоядного уменьшается
//на силу атаки хищника. Если HP Entities.Herbivore == 0, оно исчезает.
public class Predator extends Creature {
    int attack;
    public Predator (Coordinates coordinates, int speed, int hp, int attack){
        super(coordinates, speed, hp, "🐱");
        this.attack = attack;
    }
    public Predator(){}
    int count = 0;
    BFS bfs = new BFS();
    static List<Coordinates> patch;
    @Override
    public String toString() {
        return picture;
    }
    public void makeMove (Predator predator, Maps map){
        eat(predator,map);
        patch = bfs.shortCut(predator, map);
        int i = patch.size() - 1;
        map.removeFromMap(predator.getCoordinates());
        predator.setCoordinates(patch.get(i - 1));
        map.addToMap(predator.getCoordinates(), predator);
    }
    public void eat (Predator predator, Maps map) {
        Coordinates goal = bfs.nextQPoll(predator,map);


        Queue <Coordinates> qCrd = new LinkedList<>();
        Vertical[] upCrd = Vertical.values();
        Coordinates node = predator.getCoordinates();
        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        //initialize left
        if ((node.getVertical().ordinal() - 1 != -1)) {
            left = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(left);
        }
        //initialize right
        if ((node.getVertical().ordinal() + 1 != 8)) {
            right = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() + 1]);
            qCrd.add(right);
        }
        //initialize up
        if ((node.getHorizontal() - 1 != 0)) {
            up = new Coordinates(node.getHorizontal() - 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(up);
        }
        //initialize down
        if ((node.getHorizontal() + 1 != 9)) {
            down = new Coordinates(node.getHorizontal() + 1 ,upCrd[node.getVertical().ordinal()]);
            qCrd.add(down);
        }

        while (!qCrd.isEmpty()) {
            if (map.getValue(qCrd.poll()).equals(map.getValue(goal))) {
                map.removeFromMap(goal);
                count++;
                System.out.println("                                                        Om nom nom! " + count);
            }
        }
    }
}

