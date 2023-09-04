package com.dragunov;
import com.dragunov.entities.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Карта, содержит в себе коллекцию для хранения существ
//и их расположения.
public class Maps {
    Map <Coordinates, Entity> entities = new HashMap<>();


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

    public void setDefaultPosition () {

    }
}
