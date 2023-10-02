package com.dragunov;

import com.dragunov.entities.*;

import java.util.*;

public class BFS {
    private <T extends  Creature, V extends Entity> Map <Coordinates, Coordinates> bfs(T start, V goal, Field map) {
        Column[] columnValues = Column.values();

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue<Coordinates> qCoordinates = new ArrayDeque<>();
        Coordinates startCoordinates = start.getCoordinates();
        qCoordinates.add(startCoordinates);

        Map<Coordinates, Coordinates> visited = new HashMap<>();
        visited.put(startCoordinates, null);

        Coordinates node;
        while (!qCoordinates.isEmpty()) {
            node = qCoordinates.poll();
            if (node == null) {
                break;
            } else {
                if (goal == null){
                    break;
                }
                if (node.equals(goal.getCoordinates())) {
                    break;
                }
                if (map.getValue(startCoordinates) instanceof Boatman) {
                    if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                            || (map.getValue(node) instanceof Shark) || (map.getValue(node) instanceof House)) {
                        continue;
                    }
                }
                if (map.getValue(startCoordinates) instanceof Shark) {
                    if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                            || (map.getValue(node) instanceof House)) {
                        continue;
                    }
                }
                //initialize left
                    if ((node.getY().ordinal() - 1 != -1)) {
                    left = new Coordinates(node.getX(), columnValues[node.getY().ordinal() - 1]);
                }
                //initialize right
                if ((node.getY().ordinal() + 1 != 13)) {
                    right = new Coordinates(node.getX(), columnValues[node.getY().ordinal() + 1]);
                }
                //initialize up
                if ((node.getX() - 1 != 0)) {
                    up = new Coordinates(node.getX() - 1, columnValues[node.getY().ordinal()]);
                }
                //initialize down
                if ((node.getX() + 1 != 11)) {
                    down = new Coordinates(node.getX() + 1, columnValues[node.getY().ordinal()]);
                }

                //qLeft
                if ((left != null) && (!visited.containsKey(left))) {
                    qCoordinates.add(left);
                    visited.put(left, node);
                }
                //qRight
                if ((right != null) && (!visited.containsKey(right))) {
                    qCoordinates.add(right);
                    visited.put(right, node);
                }
                //qUp
                if ((up != null) && (!visited.containsKey(up))) {
                    qCoordinates.add(up);
                    visited.put(up, node);
                }
                //qDown
                if ((down != null) && (!visited.containsKey(down))) {
                    qCoordinates.add(down);
                    visited.put(down, node);
                }
            }
        }
        return visited;
    }

    public  <T extends  Creature> Queue<Coordinates> nearTarget(T start, Field map) {
        Queue <Coordinates> result = new LinkedList<>();
        Column[] columnValues = Column.values();

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCoordinates = new ArrayDeque<>();
        Coordinates startCoordinate = start.getCoordinates();
        qCoordinates.add(startCoordinate);

        Set<Coordinates> visited = new HashSet<>();
        visited.add(startCoordinate);

        Coordinates node;
        while (!qCoordinates.isEmpty()) {

            node = qCoordinates.poll();
        if (map.getValue(startCoordinate) instanceof Boatman) {
            if (map.getValue(node) instanceof Cancer) {
                result.add(node);
            }
        } else if (map.getValue(startCoordinate) instanceof Shark) {
            if (map.getValue(node) instanceof Boatman) {
                result.add(node);
            }
        }
            if (map.getValue(startCoordinate) instanceof Boatman) {
                if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                        || (map.getValue(node) instanceof Shark) || (map.getValue(node) instanceof House)) {
                    continue;
                }
            }
            if (map.getValue(startCoordinate) instanceof Shark) {
                if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                        || (map.getValue(node) instanceof House)) {
                    continue;
                }
            }
            //initialize left
            if ((node.getY().ordinal() - 1) != -1) {
                left = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() - 1]);
            }
            //initialize right
            if ((node.getY().ordinal() + 1) != 13) {
                right = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() + 1]);
            }
            //initialize up
            if ((node.getX() - 1) != 0) {
                up = new Coordinates(node.getX() - 1 ,columnValues[node.getY().ordinal()]);
            }
            //initialize down
            if ((node.getX() + 1) != 11) {
                down = new Coordinates(node.getX() + 1 ,columnValues[node.getY().ordinal()]);
            }

            //qLeft
            if ((left != null) && (!visited.contains(left))) {
                qCoordinates.add(left);
                visited.add(left);
            }
            //qRight
            if ((right != null) && (!visited.contains(right))) {
                qCoordinates.add(right);
                visited.add(right);
            }
            //qUp
            if ((up != null) && (!visited.contains(up))) {
                qCoordinates.add(up);
                visited.add(up);
            }
            //qDown
            if ((down != null) && (!visited.contains(down))) {
                qCoordinates.add(down);
                visited.add(down);
            }
        }
        return result;
    }

    public <T extends Creature> Coordinates poll(T start, Field map) {
        Queue<Coordinates> goals = nearTarget(start, map);
        return goals.poll();
    }

    public <T extends Creature, V extends Entity> Stack<Coordinates> destination(T start, Field map) {
        V goal = (V) map.getValue(poll(start, map));
        Map<Coordinates, Coordinates> path = bfs(start, goal, map);
        Stack<Coordinates> result = new Stack<>();
        Coordinates step;
        if (goal == null) {
            return result;
        } else {
            step = goal.getCoordinates();
            result.add(step);
            while (!step.equals(start.getCoordinates())) {
                step = path.get(step);
                result.push(step);
            }
        }
        return result;
    }
    public List<Boatman> getAllBoatmen(Field map){
        List <Boatman> result = new ArrayList<>();
        Column[] columnValues = Column.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCoordinates = new ArrayDeque<>();
        Coordinates start = new Coordinates(1, Column.A);
        qCoordinates.add(start);

        Set<Coordinates> visited = new HashSet<>();
        visited.add(start);

        while (!qCoordinates.isEmpty()) {
            node = qCoordinates.poll();
                if (map.getValue(node) instanceof Boatman) {
                    result.add((Boatman) map.getValue(node));
                }

            //initialize left
            if ((node.getY().ordinal() - 1 != -1)) {
                left = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() - 1]);
            }
            //initialize right
            if ((node.getY().ordinal() + 1 != 13)) {
                right = new Coordinates(node.getX() ,columnValues[node.getY().ordinal() + 1]);
            }
            //initialize up
            if ((node.getX() - 1 != 0)) {
                up = new Coordinates(node.getX() - 1 ,columnValues[node.getY().ordinal()]);
            }
            //initialize down
            if ((node.getX() + 1 != 11)) {
                down = new Coordinates(node.getX() + 1 ,columnValues[node.getY().ordinal()]);
            }

            //qLeft
            if ((left != null) && (!visited.contains(left))) {
                qCoordinates.add(left);
                visited.add(left);
            }
            //qRight
            if ((right != null) && (!visited.contains(right))) {
                qCoordinates.add(right);
                visited.add(right);
            }
            //qUp
            if ((up != null) && (!visited.contains(up))) {
                qCoordinates.add(up);
                visited.add(up);
            }
            //qDown
            if ((down != null) && (!visited.contains(down))) {
                qCoordinates.add(down);
                visited.add(down);
            }
        }
        return result;
    }
}
