package com.dragunov;

import com.dragunov.entities.*;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SearchForGrass {
    public static ArrayList <Coordinates> BFS (Maps maps, Herbivore herbivore) {

        ArrayList <Coordinates> result = new ArrayList<>(); //список координат всех сыров
        ArrayList <Coordinates> visited = new ArrayList<>(); //список посещенных координат
        Queue<Coordinates> qCrd = new LinkedList<>(); //очередь из всех координат на поле

        Vertical[] verticals = Vertical.values();
        Coordinates nextCoordinates = null; //следующая координата

        Coordinates plusA = null;
        Coordinates minusA = null;
        Coordinates plusOne = null;
        Coordinates minusOne = null;

        qCrd.add(herbivore.getCoordinates()); //узел источник добавлен в очередь
        while (!qCrd.isEmpty()) {
            nextCoordinates = qCrd.poll(); //извлечь первый элемент из очереди
            if (maps.entities.get(nextCoordinates) instanceof Grass) { //проверить не является ли узел целевым
                        result.add(nextCoordinates);
                }

            visited.add(nextCoordinates);   //пометить текущие координаты посещенными

            // все преемники текущего узла, ...
            // ... которые ещё не были посещены ...
            // ... добавить в конец очереди...
            // ... и пометить как посещённые
            if (!(maps.entities.get(nextCoordinates) instanceof Tree) && !(maps.entities.get(nextCoordinates) instanceof Rock)) {
            //--A
            if (((nextCoordinates.getVertical().ordinal() - 1) != -1)) {
                    minusA = new Coordinates(nextCoordinates.getHorizontal(),
                            verticals[nextCoordinates.getVertical().ordinal() - 1]);
                }

            //++A
            if (((nextCoordinates.getVertical().ordinal() + 1) != 8)) {
                    plusA = new Coordinates(nextCoordinates.getHorizontal(),
                            verticals[nextCoordinates.getVertical().ordinal() + 1]);
            }
            //--1
            if (((nextCoordinates.getHorizontal() - 1) != 0)) {
                    minusOne = new Coordinates(nextCoordinates.getHorizontal() - 1,
                            verticals[nextCoordinates.getVertical().ordinal()]);
            }
            //++1
            if (((nextCoordinates.getHorizontal() + 1) != 9)) {
                    plusOne = new Coordinates(nextCoordinates.getHorizontal() + 1,
                            verticals[herbivore.getCoordinates().getVertical().ordinal()]);
            }
            if (minusA != null && (!visited.contains(minusA))) {
                qCrd.add(minusA);
                visited.add(minusA);
            }
            if (plusA != null && (!visited.contains(plusA))) {
                qCrd.add(plusA);
                visited.add(plusA);
            }
            if (minusOne != null && (!visited.contains(minusOne))) {
                qCrd.add(minusOne);
                visited.add(minusOne);
            }
            if (plusOne != null && (!visited.contains(plusOne))) {
                qCrd.add(plusOne);
                visited.add(plusOne);
            }
            }
        }
        System.out.println(result);
        return result;
    }
}