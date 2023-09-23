package com.dragunov;

//Главный класс приложения включает в себя:
//Карту, счетчик ходов, рендерер поля,
//Action - список действий, исполняемых перед стартом симуляции
//или на каждом ходу

import com.dragunov.entities.Herbivore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulation {
    static boolean question = true;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Simulation simulation = new Simulation();
        Maps maps = new Maps();
        maps.setDefaultPosition();

        while (question) {
            System.out.println("-----------------");
            System.out.println("\tСИМУЛЯЦИЯ");
            System.out.println("-----------------");
            System.out.println("Меню:");
            System.out.println("\t1)S - запустить бесконечный цикл симуляции;");
            System.out.println("\t2)Q - выход;");
            System.out.println("\t3)R - описание.");
            System.out.println("-----------------");
            String answer = reader.readLine();
            switch (answer) {
                case "s":
                    while (simulation.pauseSimulation()) {
                        simulation.startSimulation(maps);
                    }
                    break;
                case "q":
                    System.out.println("Выход.");
                    question = false;
                    break;
                case "r":
                    System.out.println("Описание:");
                    System.out.println();
                    System.out.println();
                    System.out.println();
            }
        }
    }
    //Просимулировать и отрендерить следующий ход
    static void nextTurn(Maps map){
        map.setAllEarth();
        MapConsoleRenderer.mapRendering(map);
    }
    //Запустить бесконечный цикл симуляции и рендеринга
    void startSimulation(Maps map){
        Herbivore herbivore = new Herbivore();
        Simulation.nextTurn(map);
        map.predator.makeMove(map.predator, map);
        herbivore.makeMove(map);
    }

    //Приостановить бесконечный цикл симуляции и рендеринга
    boolean pauseSimulation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = "c";
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(1200);
                if (System.in.available() > 0) {
                    c = reader.readLine();
                    break;
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        switch (c) {
            case "q" -> {
                System.out.println("Выход.");
                question = false;
                return false;
            }
            case "p" -> {
                System.out.println("Пауза.");
                System.out.println("\t1) C - продолжить;");
                System.out.println("\t2) Q - выход.");
                c = reader.readLine();
                if (c.equals("q")) {
                    question = false;
                    return false;}
            }
        }
    return true;
    }
}