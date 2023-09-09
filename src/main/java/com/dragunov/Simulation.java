package com.dragunov;

import com.dragunov.entities.*;

import java.util.ArrayList;

//Главный класс приложения включает в себя:
//Карту, счетчик ходов, рендерер поля,
//Action - список действий, исполняемых перед стартом симуляции
//или на каждом ходу

public class Simulation {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Maps maps = new Maps();
        BFS bfs = new BFS();
        maps.setDefaultPosition();



            simulation.startSimulation(maps);


    }
    //Просимулировать и отрендерить следующий ход
    static void nextTurn(Maps maps){
        maps.setAllEarth();
        MapConsoleRenderer.mapRendering(maps);
    }
    //Запустить бесконечный цикл симуляции и рендеринга
    void startSimulation(Maps map){
        while (true) {
            try {
                Simulation.nextTurn(map);
                map.predator.makeMove(map.predator, map);
                if (map.entities.get(map.herbivore.getCoordinates()) instanceof Herbivore) {
                    map.herbivore.makeMove(map.herbivore, map);
                }
                if (map.entities.get(map.herbivore1.getCoordinates()) instanceof Herbivore) {
                    map.herbivore1.makeMove(map.herbivore1, map);
                }
                if (map.entities.get(map.herbivore2.getCoordinates()) instanceof Herbivore) {
                    map.herbivore2.makeMove(map.herbivore2, map);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

        }
    }
    //Приостановить бесконечный цикл симуляции и рендеринга
    void pauseSimulation(){

    }
    void rendererMap(){

    }
}