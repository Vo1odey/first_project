package com.dragunov;

//Главный класс приложения включает в себя:
//Карту, счетчик ходов, рендерер поля,
//Action - список действий, исполняемых перед стартом симуляции
//или на каждом ходу

public class Simulation {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Maps maps = new Maps();

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
        GenerateEntity generate = new GenerateEntity();
        while (true) {
            try {

                Simulation.nextTurn(map);
                map.predator.makeMove(map.predator, map);


                    map.herbivore1.makeMove(map.herbivore1, map);


                    map.herbivore2.makeMove(map.herbivore2, map);


                    map.herbivore3.makeMove(map.herbivore3, map);


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