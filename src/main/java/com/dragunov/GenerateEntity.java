package com.dragunov;

import com.dragunov.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class GenerateEntity {
    //Maps map = new Maps();
    BFS bfs = new BFS();

    public <T extends Creature, V extends Entity> void generateGoalEntity(T start, Maps map){
        List <Herbivore> hrbList = new ArrayList<>();
        Queue<Coordinates> queue;

        Random random = new Random();
        Vertical[] verticals = Vertical.values();
        Queue<Coordinates> q = bfs.qGoal(start,map);
        int count = q.size();
        if (map.getValue(start.getCoordinates()) instanceof Herbivore) {
            if (count < 3) {
                Coordinates coordinates = new Coordinates(random.nextInt(10), verticals[random.nextInt(13)]);
                while (!(map.getValue(coordinates) instanceof Earth)) {
                    coordinates = new Coordinates(random.nextInt(10), verticals[random.nextInt(13)]);
                }
                Grass grassX = new Grass(coordinates);
                map.mapPut(grassX.getCoordinates(), grassX);
            }
        }
        List <Coordinates> randomValues = new ArrayList<>();
        randomValues.add(new Coordinates(2, Vertical.H));
        randomValues.add(new Coordinates(8, Vertical.L));

        Coordinates randomSpawn = randomValues.get(random.nextInt(2));

        if (map.getValue(start.getCoordinates()) instanceof Predator) {
            int countHrb = bfs.getHrbList(map).size();
            if (countHrb < 3) {
                map.mapPut(randomSpawn,
                        (new Herbivore(randomSpawn,1, 10)));
            }
        }
    }
}
