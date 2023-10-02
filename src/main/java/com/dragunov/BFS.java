package com.dragunov;

import com.dragunov.entities.*;

import java.util.*;

public class BFS {
    //Кратчайший путь от start к goal

    private <T extends  Creature, V extends Entity> Map <Coordinates, Coordinates> bfs(T start, V goal, Field map) {

        Coordinates startCrd = start.getCoordinates();

        Column[] upCrd = Column.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue<Coordinates> qCrd = new ArrayDeque<>();
        qCrd.add(startCrd);

        Map<Coordinates, Coordinates> visited = new HashMap<>();
        visited.put(startCrd, null);

        while (!qCrd.isEmpty()) {
            node = qCrd.poll();
            if (node == null) {
                break;
            } else {
                if (goal == null){
                    break;
                }
                if (node.equals(goal.getCoordinates())) {
                    break;
                }
                if (map.getValue(startCrd) instanceof Boatman) {
                    if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                            || (map.getValue(node) instanceof Shark) || (map.getValue(node) instanceof House)
                            || (map.getValue(node) instanceof Cancer)) {
                        continue;
                    }
                }
                if (map.getValue(startCrd) instanceof Shark) {
                    if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                            || (map.getValue(node) instanceof Cancer) || (map.getValue(node) instanceof House)) {
                        continue;
                    }
                }
                //initialize left
                    if ((node.getVertical().ordinal() - 1 != -1)) {
                    left = new Coordinates(node.getHorizontal(), upCrd[node.getVertical().ordinal() - 1]);
                }
                //initialize right
                if ((node.getVertical().ordinal() + 1 != 13)) {
                    right = new Coordinates(node.getHorizontal(), upCrd[node.getVertical().ordinal() + 1]);
                }
                //initialize up
                if ((node.getHorizontal() - 1 != 0)) {
                    up = new Coordinates(node.getHorizontal() - 1, upCrd[node.getVertical().ordinal()]);
                }
                //initialize down
                if ((node.getHorizontal() + 1 != 11)) {
                    down = new Coordinates(node.getHorizontal() + 1, upCrd[node.getVertical().ordinal()]);
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
        }
        return visited;
    }
    //Очередь из ближайших искомых координат
    public  <T extends  Creature> Queue<Coordinates> qGoal(T start, Field map) {

        Coordinates startCrd = start.getCoordinates();
        Queue <Coordinates> result = new LinkedList<>();
        Column[] upValues = Column.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new ArrayDeque<>();
        qCrd.add(startCrd);

        Map<Coordinates, Coordinates> visited = new HashMap<>();
        visited.put(startCrd, null);

        while (!qCrd.isEmpty()) {

            node = qCrd.poll();
        if (map.getValue(startCrd) instanceof Boatman) {
            if (map.getValue(node) instanceof Cancer) {
                result.add(node);
            }
        } else if (map.getValue(startCrd) instanceof Shark) {
            if (map.getValue(node) instanceof Boatman) {
                result.add(node);
            }
        }
            if (map.getValue(startCrd) instanceof Boatman) {
                if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                        || (map.getValue(node) instanceof Shark) || (map.getValue(node) instanceof House)) {
                    continue;
                }
            }
            if (map.getValue(startCrd) instanceof Shark) {
                if ((map.getValue(node) instanceof Palm) || (map.getValue(node) instanceof Sand)
                        || (map.getValue(node) instanceof Cancer) || (map.getValue(node) instanceof House)) {
                    continue;
                }
            }
            //initialize left
            if ((node.getVertical().ordinal() - 1 != -1)) {
                left = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() - 1]);
            }
            //initialize right
            if ((node.getVertical().ordinal() + 1 != 13)) {
                right = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() + 1]);
            }
            //initialize up
            if ((node.getHorizontal() - 1 != 0)) {
                up = new Coordinates(node.getHorizontal() - 1 ,upValues[node.getVertical().ordinal()]);
            }
            //initialize down
            if ((node.getHorizontal() + 1 != 11)) {
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
    //Извлечь следующую координату из очереди ближайших искомых координат
    public <T extends Creature> Coordinates nextQPoll(T start, Field map){
        Queue<Coordinates> allGoal = qGoal(start, map);
        return allGoal.poll();
    }
    //
    public <T extends Creature, V extends Entity> Stack<Coordinates> shortCut(T start, Field map){
        Stack<Coordinates> patch = new Stack<>();
        V goal = (V) map.getValue(nextQPoll(start, map));
        Map<Coordinates, Coordinates> visited = bfs(start, goal, map);
        //ArrayList<Coordinates> result = new ArrayList<>();
        if (goal == null) {
            return patch;
        } else {
            Coordinates curNode = goal.getCoordinates();
            patch.add(curNode);
            while (!curNode.equals(start.getCoordinates())) {
                curNode = visited.get(curNode);
                patch.push(curNode);
            }
        }
        return patch;
    }
    public List<Boatman> getHrbList(Field map){

        Coordinates startCrd = new Coordinates(1, Column.A);
        List <Boatman> result = new ArrayList<>();
        Column[] upValues = Column.values();
        Coordinates node;

        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        Queue <Coordinates> qCrd = new ArrayDeque<>();
        qCrd.add(startCrd);

        Map<Coordinates, Coordinates> visited = new HashMap<>();
        visited.put(startCrd, null);

        while (!qCrd.isEmpty()) {

            node = qCrd.poll();
                if (map.getValue(node) instanceof Boatman) {
                    result.add((Boatman) map.getValue(node));
                }


            //initialize left
            if ((node.getVertical().ordinal() - 1 != -1)) {
                left = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() - 1]);
            }
            //initialize right
            if ((node.getVertical().ordinal() + 1 != 13)) {
                right = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() + 1]);
            }
            //initialize up
            if ((node.getHorizontal() - 1 != 0)) {
                up = new Coordinates(node.getHorizontal() - 1 ,upValues[node.getVertical().ordinal()]);
            }
            //initialize down
            if ((node.getHorizontal() + 1 != 11)) {
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
}
