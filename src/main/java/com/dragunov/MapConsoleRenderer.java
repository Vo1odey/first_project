package com.dragunov;

import com.dragunov.entities.Entity;
import java.util.ArrayList;

public class MapConsoleRenderer {
    static void mapRendering(Field field) {
        ArrayList<String> CreaturesCrd = new ArrayList<>();
        ArrayList<String> Pictures = new ArrayList<>();
        Column[] columnValues = Column.values();

        for (Coordinates key : field.getKeySet()) {
            Entity value = field.getValue(key);
            CreaturesCrd.add(String.valueOf(key));
            Pictures.add(value.toString());
        }

            int a;
            System.out.println("\t    A   B   C   D   E   F   G   H   I   J   K   L   M");
            for (int i = 1; i < 11; i++) {
                System.out.print("\t" + i + "\t");
                for (Column type : columnValues) {
                    for (a = 0; a < CreaturesCrd.size(); a++) {
                        if ((i + "" + type).equals(CreaturesCrd.get(a))) {
                            System.out.print(Pictures.get(a) + "\t");
                        }
                    }
                }
                System.out.println();
            }
        System.out.println();
    }
}

