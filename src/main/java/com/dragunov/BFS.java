package com.dragunov;

import com.dragunov.entities.*;

import java.util.*;

public class BFS {

    public <T extends  Creature, V extends Entity> Map <Coordinates, Coordinates> bfs(T start, V goal, Maps map) {
        Coordinates startCrd = start.getCoordinates();      //текущие координаты существа

        Vertical[] upCrd = Vertical.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue<Coordinates> qCrd = new ArrayDeque<>();     //очередь следующих к посещению координат
        qCrd.add(startCrd);

        Map<Coordinates, Coordinates> visited = new HashMap<>();    //посещенные координаты
        visited.put(startCrd, null);

        while (!qCrd.isEmpty()) {
            node = qCrd.poll();

            if (node.equals(goal.getCoordinates())) {
                break;
            }
            if (map.getValue(startCrd) instanceof Herbivore) {
                if ((map.getValue(node) instanceof Rock) || (map.getValue(node) instanceof Tree)
                        ) {
                    continue;
                }
            }
            if (map.getValue(startCrd) instanceof Predator) {
                if ((map.getValue(node) instanceof Rock) || (map.getValue(node) instanceof Tree)
                        || (map.getValue(node) instanceof Grass)) {
                    continue;
                }
            }
            //initialize left
            if ((node.getVertical().ordinal() - 1 != -1)) {
                left = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() - 1]);
            }
            //initialize right
            if ((node.getVertical().ordinal() + 1 != 8)) {
                right = new Coordinates(node.getHorizontal() ,upCrd[node.getVertical().ordinal() + 1]);
            }
            //initialize up
            if ((node.getHorizontal() - 1 != 0)) {
                up = new Coordinates(node.getHorizontal() - 1 ,upCrd[node.getVertical().ordinal()]);
            }
            //initialize down
            if ((node.getHorizontal() + 1 != 9)) {
                down = new Coordinates(node.getHorizontal() + 1 ,upCrd[node.getVertical().ordinal()]);
            }

            //qLeft
            if ((left != null) && (!visited.containsKey(left))) {
                qCrd.add(left);
                visited.put(left, node);
            }
            //qRight
            if ((right != null) && (!visited.containsKey(right))) {
                qCrd.add(right);
                visited.put(right, node);
            }
            //qUp
            if ((up != null) && (!visited.containsKey(up))) {
                qCrd.add(up);
                visited.put(up, node);
            }
            //qDown
            if ((down != null) && (!visited.containsKey(down))) {
                qCrd.add(down);
                visited.put(down, node);
            }
        }
        return visited;
    }
    public <T extends  Creature> Queue<Coordinates> qGoal(T start, Maps map) {

        Coordinates startCrd = start.getCoordinates();      //текущие координаты существа
        Queue <Coordinates> result = new LinkedList<>();
        Vertical[] upValues = Vertical.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new ArrayDeque<>();     //очередь следующих к посещению координат
        qCrd.add(startCrd);

        Map<Coordinates, Coordinates> visited = new HashMap<>();    //посещенные координаты
        visited.put(startCrd, null);

        while (!qCrd.isEmpty()) {

            node = qCrd.poll();
        if (map.getValue(startCrd) instanceof Herbivore) {
            if (map.getValue(node) instanceof Grass) {
                result.add(node);
            }
        } else if (map.getValue(startCrd) instanceof Predator) {
            if (map.getValue(node) instanceof Herbivore) {
                result.add(node);
            }
        }
            if (map.getValue(startCrd) instanceof Herbivore) {
                if ((map.getValue(node) instanceof Rock) || (map.getValue(node) instanceof Tree)
                        || (map.getValue(node) instanceof Predator)) {
                    continue;
                }
            }
            if (map.getValue(startCrd) instanceof Predator) {
                if ((map.getValue(node) instanceof Rock) || (map.getValue(node) instanceof Tree)
                        || (map.getValue(node) instanceof Grass)) {
                    continue;
                }
            }
            //initialize left
            if ((node.getVertical().ordinal() - 1 != -1)) {
                left = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() - 1]);
            }
            //initialize right
            if ((node.getVertical().ordinal() + 1 != 8)) {
                right = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() + 1]);
            }
            //initialize up
            if ((node.getHorizontal() - 1 != 0)) {
                up = new Coordinates(node.getHorizontal() - 1 ,upValues[node.getVertical().ordinal()]);
            }
            //initialize down
            if ((node.getHorizontal() + 1 != 9)) {
                down = new Coordinates(node.getHorizontal() + 1 ,upValues[node.getVertical().ordinal()]);
            }

            //qLeft
            if ((left != null) && (!visited.containsKey(left))) {
                qCrd.add(left);
                visited.put(left, node);
            }
            //qRight
            if ((right != null) && (!visited.containsKey(right))) {
                qCrd.add(right);
                visited.put(right, node);
            }
            //qUp
            if ((up != null) && (!visited.containsKey(up))) {
                qCrd.add(up);
                visited.put(up, node);
            }
            //qDown
            if ((down != null) && (!visited.containsKey(down))) {
                qCrd.add(down);
                visited.put(down, node);
            }
        }

        return result;
    }
    public <T extends Creature> Coordinates nextQPoll(T start, Maps map){
        Queue<Coordinates> allGoal = qGoal(start, map);
        return allGoal.poll();
    }
    public <T extends Creature, V extends Entity> ArrayList<Coordinates> shortCut(T start, Maps map){
        V goal = (V) map.getValue(nextQPoll(start, map));
        Map<Coordinates, Coordinates> visited = bfs(start, goal, map);
        ArrayList<Coordinates> result = new ArrayList<>();

        Coordinates curNode = goal.getCoordinates();
        result.add(curNode);
        while (!curNode.equals(start.getCoordinates())) {
            curNode = visited.get(curNode);
            result.add(curNode);
        }
        return result;
    }
}
