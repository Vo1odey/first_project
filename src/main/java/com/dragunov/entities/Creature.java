package com.dragunov.entities;
import com.dragunov.*;

//Абстрактный класс. Существо имеет скорость (сколько клеток
//может пройти за ход), количество HP.
//Имеет абстрактный метод makeMove() - сделать ход.
//Наследники будут реализовывать этот метод каждый по-своему.
//Entities.Creature - существо.
public class Creature extends Entity {
    private Integer speed;
    private Integer hp;


    public Creature (Coordinates coordinates, int speed, int hp, String picture) {
        super(coordinates,picture);
        this.speed = speed;
        this.hp = hp;
    }
    public Creature(){}

    public Integer getSpeed(){
        return speed;
    }

    void makeMove(){

    }
}
