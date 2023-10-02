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
        Column[] columnValues = Column.values();
        Queue<Coordinates> qGoals = bfs.nearTarget(start,map);
        int count = qGoals.size();
        if (map.getValue(start.getCoordinates()) instanceof Boatman) {
            if (count < 3) {
                Coordinates randomCoordinates = new Coordinates(random.nextInt(10),
                        columnValues[random.nextInt(13)]);
                while (!(map.getValue(randomCoordinates) instanceof Water)) {
                    randomCoordinates = new Coordinates(random.nextInt(10),
                            columnValues[random.nextInt(13)]);
                }
                Cancer cancer = new Cancer(randomCoordinates);
                map.mapPut(cancer.getCoordinates(), cancer);
            }
        }
        if (map.getValue(start.getCoordinates()) instanceof Shark) {
            List <Coordinates> leaveTheHouse = new ArrayList<>();
            leaveTheHouse.add(new Coordinates(2, Column.H));
            leaveTheHouse.add(new Coordinates(8, Column.L));
            Coordinates chooseHouse = leaveTheHouse.get(random.nextInt(2));

            int countHrb = bfs.getAllBoatmen(map).size();
            if (countHrb < 3) {
                map.mapPut(chooseHouse, (new Boatman(chooseHouse,1, 10)));
            }
        }
    }
}
