package com.dragunov;

import com.dragunov.entities.Entity;
import java.util.ArrayList;



public class MapConsoleRenderer {
    static void mapRendering(Maps maps) {
        ArrayList<String> keyList = new ArrayList<>(); //координаты всех существ
        ArrayList<String> pictureList = new ArrayList<>();
        Vertical[] types = Vertical.values();

        for (Coordinates key : maps.entities.keySet()) {
            Entity value = maps.entities.get(key);
            keyList.add(String.valueOf(key));
            pictureList.add(value.toString());
        }

            int a;
            System.out.println("    A   B   C   D   E   F   G   J");
            for (int i = 1; i < 9; i++) {   //Столбик
                System.out.print(i + "\t");
                for (Vertical type : types) {   //Строка
                    for (a = 0; a < keyList.size(); a++) {
                        if ((i + "" + type).equals(keyList.get(a))) {
                            System.out.print(pictureList.get(a) + "\t");
                        }
                    }
                }
                System.out.println();
            }
        System.out.println();
    }
}

