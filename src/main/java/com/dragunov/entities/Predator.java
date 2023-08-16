package com.dragunov.entities;
import com.dragunov.*;

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
    @Override
    public String toString() {
        return picture;
    }

    @Override
    void makeMove() {
        //Ищет травоядное, либо атакует
    }
}