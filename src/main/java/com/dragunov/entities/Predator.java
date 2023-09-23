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
        super(coordinates, speed, hp, "\uD83E\uDD88");
        this.attack = attack;
    }
    public Predator(){}
    int count = 0;
    BFS bfs = new BFS();
    GenerateEntity generate = new GenerateEntity();

    @Override
    public String toString() {
        return picture;
    }
    public void makeMove (Predator predator, Maps map) {
        try {
        if ((map.getValue(predator.getCoordinates()) instanceof Predator)){
        generate.generateGoalEntity(predator, map);
        attack(predator, map);
        Stack<Coordinates> patch = bfs.shortCut(predator, map);
        if (patch.size() != 2) {
            patch.pop();
            map.removeFromMap(predator.getCoordinates());
            predator.setCoordinates(patch.pop());
            map.mapPut(predator.getCoordinates(), predator);
        }
            }
        } catch (EmptyStackException e) {
            makeMove();
        }
    }
    private void attack(Predator predator, Maps map) {
        Coordinates goal = bfs.nextQPoll(predator,map);

        Queue <Coordinates> qCrd = new LinkedList<>();
        Vertical[] upCrd = Vertical.values();
        Coordinates node = predator.getCoordinates();

        Coordinates left = null;
        Coordinates leftUp = null;
        Coordinates leftDown = null;

        Coordinates right = null;
        Coordinates rightUp = null;
        Coordinates rightDown = null;

        Coordinates up = null;
        Coordinates down = null;

        //initialize left
        if ((node.getVertical().ordinal() - 1 != -1)) {
            left = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(left);
        }
        //initialize leftUp ^<-
        if ((node.getVertical().ordinal() - 1 != -1) && (node.getHorizontal() - 1 != 0)) {
            leftUp = new Coordinates(node.getHorizontal() - 1, upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(leftUp);
        }

        //initialize leftDown v<-
        if ((node.getVertical().ordinal() - 1 != -1) && (node.getHorizontal() + 1 != 11)) {
            leftDown = new Coordinates(node.getHorizontal() + 1, upCrd[node.getVertical().ordinal() - 1]);
            qCrd.add(leftDown);
        }

        //initialize rightUp ->^
        if ((node.getVertical().ordinal() + 1 != 13) && (node.getHorizontal() - 1 != 0)) {
            rightUp = new Coordinates(node.getHorizontal() - 1 , upCrd[node.getVertical().ordinal() + 1]);
            qCrd.add(rightUp);
        }

        //initialize rightDown ->V
        if ((node.getVertical().ordinal() + 1 != 13) && (node.getHorizontal() + 1 != 11)) {
            rightDown = new Coordinates(node.getHorizontal() + 1 , upCrd[node.getVertical().ordinal() + 1]);
            qCrd.add(rightDown);
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
            qCrd.poll();
            if (map.getValue(qCrd.peek()) instanceof Herbivore herbivore) {
                herbivore.setHp(herbivore.getHp() - predator.attack);
                //System.out.println(herbivore.getHp() + " Attack!");
                if (herbivore.getHp() <= 0) {
                    map.removeFromMap(goal);
                    map.mapPut(goal, new DeathValue());
                    count++;
                    //System.out.println("Om nom nom! " + count + " mouse");
                }
            }
        }
    }
}

