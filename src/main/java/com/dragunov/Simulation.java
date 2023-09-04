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

        Herbivore herbivore = new Herbivore(new Coordinates(1, Vertical.A),1 ,10);
        Tree tree3 = new Tree(new Coordinates(4, Vertical.C));
        Predator predator = new Predator(new Coordinates(3, Vertical.J),2,10,10);
        Grass grass = new Grass(new Coordinates(2, Vertical.D));
        Grass grass1 = new Grass(new Coordinates(4, Vertical.E));
        Grass grass2 = new Grass(new Coordinates(4,Vertical.A));
        Grass grass3 = new Grass(new Coordinates(1,Vertical.G));

        Rock rock = new Rock(new Coordinates(1, Vertical.E));
        Rock rock1 = new Rock(new Coordinates(2, Vertical.E));
        Rock rock2 = new Rock(new Coordinates(3, Vertical.E));

        Tree tree = new Tree(new Coordinates(3, Vertical.B));
        Tree tree1 = new Tree(new Coordinates(3,Vertical.A));
        Tree tree2 = new Tree(new Coordinates(3,Vertical.C));

        maps.setAllEarth();

        maps.entities.put(herbivore.getCoordinates(), herbivore);
        maps.entities.put(tree3.getCoordinates(), tree3);
        maps.entities.put(predator.getCoordinates(), predator);

        maps.entities.put(grass.getCoordinates(), grass);
        maps.entities.put(grass1.getCoordinates(), grass1);
        maps.entities.put(grass2.getCoordinates(),grass2);
        maps.entities.put(grass3.getCoordinates(),grass3);

        maps.entities.put(rock.getCoordinates(), rock);
        maps.entities.put(rock1.getCoordinates(), rock1);
        maps.entities.put(rock2.getCoordinates(), rock2);

        maps.entities.put(tree.getCoordinates(), tree);
        maps.entities.put(tree1.getCoordinates(), tree1);
        maps.entities.put(tree2.getCoordinates(), tree2);

        




        Simulation.startSimulation(maps, herbivore);


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
                herbivore.makeMove(maps, herbivore);
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