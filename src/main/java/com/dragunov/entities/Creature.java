package com.dragunov.entities;
import com.dragunov.*;

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
    public Integer getHp(){
        return hp;
    }
    public void setHp(Integer hp){
        this.hp = hp;
    }
    void makeMove(){

    }
}
