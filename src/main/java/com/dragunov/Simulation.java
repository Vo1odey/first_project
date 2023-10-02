package com.dragunov;

import com.dragunov.entities.Boatman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulation {
    static boolean question = true;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Simulation simulation = new Simulation();
        Field field = new Field();
        field.setDefaultPosition();

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
                case "s" -> {
                    while (simulation.pauseSimulation()) {
                        simulation.startSimulation(field);
                    }
                }
                case "q" -> {
                    System.out.println("Выход.");
                    question = false;
                }
                case "r" -> {
                    System.out.println("Описание:");
                    System.out.println("\t\uD83D\uDFE6️ - вода\t\t\uD83D\uDEA3 - лодочник\t\uD83C\uDFE0 - дом лодочника");
                    System.out.println("\t\uD83C\uDF34 - пальма\t\t\uD83E\uDD88 - акула");
                    System.out.println("\t\uD83D\uDFE8 - песок\t\t\uD83E\uDD9E - рак");
                    System.out.println();
                    System.out.println("\t\uD83D\uDFE8 \uD83C\uDF34 - препятствия;");
                    System.out.println();
                    System.out.println("\t\uD83D\uDEA3 плавает по \uD83D\uDFE6 ищет на карте \uD83E\uDD9E;");
                    System.out.println("\t\uD83E\uDD88 плавает по \uD83D\uDFE6 ищет на карте \uD83D\uDEA3;");
                    System.out.println();
                    System.out.println("Во время запуска:");
                    System.out.println("\tq - Выход;");
                    System.out.println("\tp - Пауза.");
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }

    static void nextTurn(Field map){
        map.addWater();
        MapConsoleRenderer.mapRendering(map);
    }

    void startSimulation(Field map){
        Boatman boatman = new Boatman();
        Simulation.nextTurn(map);
        map.shark.makeMove(map.shark, map);
        boatman.makeMove(map);
    }

    boolean pauseSimulation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "c";
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(900);
                if (System.in.available() > 0) {
                    input = reader.readLine();
                    break;
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        switch (input) {
            case "q" -> {
                System.out.println("Выход.");
                question = false;
                return false;
            }
            case "p" -> {
                System.out.println("Пауза.");
                System.out.println("\t1) C - продолжить;");
                System.out.println("\t2) Q - выход.");
                input = reader.readLine();
                if (input.equals("q")) {
                    question = false;
                    return false;}
            }
        }
    return true;
    }
}