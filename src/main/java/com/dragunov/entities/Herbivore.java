package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {

    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");
    }
    public Herbivore(){}

    @Override
    public String toString() {
        return picture;
    }

    public void makeMove(Maps maps, Herbivore herbivore) {
        List <Coordinates> fromCrd = new ArrayList<>();      //координаты ОТКУДА мы пришли
        List <Coordinates> visited = new ArrayList<>();    //посещенные координаты
        Queue <Coordinates> qCrd = new LinkedList<>();     //очередь следующих к посещению координат

        visited.add(herbivore.getCoordinates());         //стартовые координаты = посещенные


        // Пометить посещенными текущие координаты
        // Добавить в очередь соседние координаты
        // Посмотреть не являются ли они сыром или препятствием
        // Если координата = сыр -> восстановить от сыра путь к мышке
        // Для этого нужно знать из какой координаты мы пришли
    }
}
