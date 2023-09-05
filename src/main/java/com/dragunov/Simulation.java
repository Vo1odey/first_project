package com.dragunov;

import com.dragunov.entities.*;

import java.util.ArrayList;

//Главный класс приложения включает в себя:
//Карту, счетчик ходов, рендерер поля,
//Action - список действий, исполняемых перед стартом симуляции
//или на каждом ходу

public class Simulation {
    public static void main(String[] args) {
        Maps maps = new Maps();
        maps.setDefaultPosition();

        Simulation.startSimulation(maps, maps.herbivore);
    }
    //Просимулировать и отрендерить следующий ход
    static void nextTurn(Maps maps){
        maps.setAllEarth();
        MapConsoleRenderer.mapRendering(maps);
    }
    //Запустить бесконечный цикл симуляции и рендеринга
    static void startSimulation(Maps maps, Herbivore herbivore){
        while (true) {
            try {
                Simulation.nextTurn(maps);
                herbivore.makeMove(herbivore, maps.grass3);
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