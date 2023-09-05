package com.dragunov;
import com.dragunov.entities.*;

import java.util.HashMap;
import java.util.Map;

//Карта, содержит в себе коллекцию для хранения существ
//и их расположения.
public class Maps {
    Map <Coordinates, Entity> entities = new HashMap<>();

    Herbivore herbivore = new Herbivore(new Coordinates(1, Vertical.A),1 ,10);
    Tree tree3 = new Tree(new Coordinates(4, Vertical.C));
    Predator predator = new Predator(new Coordinates(3, Vertical.J),2,10,10);
    Grass grass = new Grass(new Coordinates(2, Vertical.D));
    Grass grass1 = new Grass(new Coordinates(4, Vertical.E));
    Grass grass2 = new Grass(new Coordinates(4, Vertical.A));
    Grass grass3 = new Grass(new Coordinates(1, Vertical.G));

    Rock rock = new Rock(new Coordinates(1, Vertical.E));
    Rock rock1 = new Rock(new Coordinates(2, Vertical.E));
    Rock rock2 = new Rock(new Coordinates(3, Vertical.E));

    Tree tree = new Tree(new Coordinates(3, Vertical.B));
    Tree tree1 = new Tree(new Coordinates(3, Vertical.A));
    Tree tree2 = new Tree(new Coordinates(3, Vertical.C));

    public void setDefaultPosition () {
        entities.put(herbivore.getCoordinates(), herbivore);
        entities.put(tree3.getCoordinates(), tree3);
        entities.put(predator.getCoordinates(), predator);

        entities.put(grass.getCoordinates(), grass);
        entities.put(grass1.getCoordinates(), grass1);
        entities.put(grass2.getCoordinates(),grass2);
        entities.put(grass3.getCoordinates(),grass3);

        entities.put(rock.getCoordinates(), rock);
        entities.put(rock1.getCoordinates(), rock1);
        entities.put(rock2.getCoordinates(), rock2);

        entities.put(tree.getCoordinates(), tree);
        entities.put(tree1.getCoordinates(), tree1);
        entities.put(tree2.getCoordinates(), tree2);
    }


    public Entity getValue (Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeFromMap (Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public void addToMap (Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void setAllEarth () {
        Vertical[] types = Vertical.values();
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                Earth earth = new Earth(new Coordinates(i,types[j]));
                //если данная клетка не занята -> установить землю
                if (!entities.containsKey(new Coordinates(i,types[j]))) {
                    entities.put(new Coordinates(i, types[j]), earth);
                }
            }
        }
    }
}
