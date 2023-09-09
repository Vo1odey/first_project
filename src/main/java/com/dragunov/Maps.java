package com.dragunov;
import com.dragunov.entities.*;

import java.util.HashMap;
import java.util.Map;

//Карта, содержит в себе коллекцию для хранения существ
//и их расположения.
public class Maps {
    Map <Coordinates, Entity> entities = new HashMap<>();

    Herbivore herbivore = new Herbivore(new Coordinates(1, Vertical.A),1 ,10);
    Herbivore herbivore1 = new Herbivore(new Coordinates(7,Vertical.J),1, 10);
    Herbivore herbivore2 = new Herbivore(new Coordinates(5,Vertical.A),1, 10);
    Tree tree3 = new Tree(new Coordinates(4, Vertical.C));
    Predator predator = new Predator(new Coordinates(3, Vertical.J),2,10,10);
    //Grass grass = new Grass(new Coordinates(2, Vertical.D));
    Grass grass1 = new Grass(new Coordinates(4, Vertical.E));
    Grass grass2 = new Grass(new Coordinates(4, Vertical.A));
    Grass grass3 = new Grass(new Coordinates(1, Vertical.G));
    Grass grass4 = new Grass(new Coordinates(8, Vertical.J));
    Grass grass5 = new Grass(new Coordinates(8, Vertical.A));

    Rock rock = new Rock(new Coordinates(1, Vertical.E));
    Rock rock1 = new Rock(new Coordinates(2, Vertical.E));
    Rock rock2 = new Rock(new Coordinates(3, Vertical.E));
    //Rock rock3 = new Rock(new Coordinates(6, Vertical.B));
    Rock rock4 = new Rock(new Coordinates(7, Vertical.B));
    Rock rock5 = new Rock(new Coordinates(8, Vertical.B));



    Tree tree = new Tree(new Coordinates(3, Vertical.B));
    Tree tree1 = new Tree(new Coordinates(3, Vertical.A));
    Tree tree2 = new Tree(new Coordinates(3, Vertical.C));

    public void setDefaultPosition () {
        entities.put(herbivore.getCoordinates(), herbivore);
        entities.put(herbivore1.getCoordinates(), herbivore1);
        entities.put(herbivore2.getCoordinates(), herbivore2);
        entities.put(tree3.getCoordinates(), tree3);
        entities.put(predator.getCoordinates(), predator);

        //entities.put(grass.getCoordinates(), grass);
        entities.put(grass1.getCoordinates(), grass1);
        entities.put(grass2.getCoordinates(),grass2);
        entities.put(grass3.getCoordinates(),grass3);
        entities.put(grass4.getCoordinates(), grass4);
        entities.put(grass5.getCoordinates(), grass5);

        entities.put(rock.getCoordinates(), rock);
        entities.put(rock1.getCoordinates(), rock1);
        entities.put(rock2.getCoordinates(), rock2);
        //entities.put(rock3.getCoordinates(), rock3);
        entities.put(rock4.getCoordinates(), rock4);
        entities.put(rock5.getCoordinates(), rock5);

        entities.put(tree.getCoordinates(), tree);
        entities.put(tree1.getCoordinates(), tree1);
        entities.put(tree2.getCoordinates(), tree2);
    }


    public Entity getValue (Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeFromMap (Coordinates coordinates) {
        entities.remove(coordinates, entities.get(coordinates));
    }

    public void addToMap (Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void setAllEarth () {
        Vertical[] types = Vertical.values();
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 13; j++) {
                Earth earth = new Earth(new Coordinates(i,types[j]));
                //если данная клетка не занята -> установить землю
                if (!entities.containsKey(new Coordinates(i,types[j]))) {
                    entities.put(new Coordinates(i, types[j]), earth);
                }
            }
        }
    }
}
