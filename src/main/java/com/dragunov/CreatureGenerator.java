package com.dragunov;

import com.dragunov.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CreatureGenerator {
    BFS bfs = new BFS();
    public <T extends Creature> void generateGoalEntity(T start, Field map){
        Random random = new Random();
        Column[] columns = Column.values();
        Queue<Coordinates> q = bfs.qGoal(start,map);
        int count = q.size();
        if (map.getValue(start.getCoordinates()) instanceof Boatman) {
            if (count < 3) {
                Coordinates coordinates = new Coordinates(random.nextInt(10), columns[random.nextInt(13)]);
                while (!(map.getValue(coordinates) instanceof Water)) {
                    coordinates = new Coordinates(random.nextInt(10), columns[random.nextInt(13)]);
                }
                Cancer cancerX = new Cancer(coordinates);
                map.mapPut(cancerX.getCoordinates(), cancerX);
            }
        }
        List <Coordinates> randomValues = new ArrayList<>();
        randomValues.add(new Coordinates(2, Column.H));
        randomValues.add(new Coordinates(8, Column.L));

        Coordinates randomSpawn = randomValues.get(random.nextInt(2));

        if (map.getValue(start.getCoordinates()) instanceof Shark) {
            int countHrb = bfs.getHrbList(map).size();
            if (countHrb < 3) {
                map.mapPut(randomSpawn,
                        (new Boatman(randomSpawn,1, 10)));
            }
        }
    }
}
