package com.dragunov;
import com.dragunov.entities.*;

import java.util.*;

public class Field {

    private Map <Coordinates, Entity> entities = new HashMap<>();

    public Set<Coordinates> getKeySet(){
        return entities.keySet();
    }


    House house = new House(new Coordinates(2, Column.G));
    House house1 = new House(new Coordinates(9, Column.L));

    Boatman boatman1 = new Boatman(new Coordinates(1, Column.A),1 ,10);
    Boatman boatman2 = new Boatman(new Coordinates(7, Column.J),1, 10);
    Boatman boatman3 = new Boatman(new Coordinates(4, Column.A),1, 10);

    Shark shark = new Shark(new Coordinates(3, Column.J),2,10,5);

    Cancer cancer1 = new Cancer(new Coordinates(3, Column.F));
    Cancer cancer2 = new Cancer(new Coordinates(9, Column.E));
    Cancer cancer3 = new Cancer(new Coordinates(10, Column.M));
    Cancer cancer4 = new Cancer(new Coordinates(8, Column.J));
    Cancer cancer5 = new Cancer(new Coordinates(9, Column.A));
    Cancer cancer6 = new Cancer(new Coordinates(7, Column.H));
    Cancer cancer7 = new Cancer(new Coordinates(1, Column.M));

    Palm palm = new Palm(new Coordinates(1, Column.E));
    Palm palm1 = new Palm(new Coordinates(2, Column.E));
    Palm palm2 = new Palm(new Coordinates(3, Column.E));
    Palm palm3 = new Palm(new Coordinates(7, Column.B));
    Palm palm4 = new Palm(new Coordinates(8, Column.B));
    Palm palm5 = new Palm(new Coordinates(9, Column.B));
    Palm palm6 = new Palm(new Coordinates(9, Column.C));
    Palm palm7 = new Palm(new Coordinates(1, Column.F));
    Palm palm8 = new Palm(new Coordinates(2, Column.F));
    Palm palm9 = new Palm(new Coordinates(1, Column.G));
    Palm palm10 = new Palm(new Coordinates(1, Column.D));
    Palm palm11 = new Palm(new Coordinates(10, Column.L));
    Palm palm12 = new Palm(new Coordinates(10, Column.K));
    Palm palm13 = new Palm(new Coordinates(9, Column.K));
    Palm palm14 = new Palm(new Coordinates(10, Column.J));
    //Rock rock15 = new Rock(new Coordinates(3, Vertical.M));
    //Rock rock16 = new Rock(new Coordinates(4, Vertical.M));
    //Rock rock17 = new Rock(new Coordinates(5, Vertical.M));
    Palm palm18 = new Palm(new Coordinates(3, Column.L));
    Palm palm19 = new Palm(new Coordinates(4, Column.K));
    Palm palm20 = new Palm(new Coordinates(4, Column.J));
    Palm palm21 = new Palm(new Coordinates(5, Column.K));
    Palm palm22 = new Palm(new Coordinates(6, Column.L));
    //Rock rock23 = new Rock(new Coordinates(7, Vertical.M));
    Palm palm24 = new Palm(new Coordinates(4, Column.L));
    Palm palm25 = new Palm(new Coordinates(5, Column.L));
    //Rock rock26 = new Rock(new Coordinates(6, Vertical.M));

    Sand sand0 = new Sand(new Coordinates(3, Column.B));
    Sand sand1 = new Sand(new Coordinates(3, Column.A));
    //Tree tree2 = new Tree(new Coordinates(3, Vertical.C));
    Sand sand3 = new Sand(new Coordinates(4, Column.C));
    Sand sand4 = new Sand(new Coordinates(4, Column.B));
    Sand sand5 = new Sand(new Coordinates(2, Column.A));
    Sand sand6 = new Sand(new Coordinates(10, Column.A));
    Sand sand7 = new Sand(new Coordinates(10, Column.B));
    Sand sand8 = new Sand(new Coordinates(10, Column.C));
    Sand sand9 = new Sand(new Coordinates(8, Column.C));
    Sand sand10 = new Sand(new Coordinates(10, Column.D));
    Sand sand11 = new Sand(new Coordinates(9, Column.D));
    Sand sand12 = new Sand(new Coordinates(10, Column.E));
    Sand sand13 = new Sand(new Coordinates(6, Column.E));
    Sand sand14 = new Sand(new Coordinates(5, Column.F));
    Sand sand15 = new Sand(new Coordinates(7, Column.F));
    Sand sand16 = new Sand(new Coordinates(6, Column.F));
    Sand sand17 = new Sand(new Coordinates(5, Column.G));
    Sand sand18 = new Sand(new Coordinates(4, Column.G));
    Sand sand19 = new Sand(new Coordinates(6, Column.G));
    Sand sand20 = new Sand(new Coordinates(7, Column.G));
    Sand sand21 = new Sand(new Coordinates(8, Column.G));
    Sand sand22 = new Sand(new Coordinates(5, Column.H));
    Sand sand23 = new Sand(new Coordinates(6, Column.H));
    Sand sand24 = new Sand(new Coordinates(6, Column.I));
    Sand sand25 = new Sand(new Coordinates(8, Column.F));


    public void setDefaultPosition () {
        entities.put(house.getCoordinates(), house);
        entities.put(house1.getCoordinates(), house1);

        entities.put(boatman1.getCoordinates(), boatman1);
        entities.put(boatman2.getCoordinates(), boatman2);
        entities.put(boatman3.getCoordinates(), boatman3);

        entities.put(shark.getCoordinates(), shark);

        entities.put(cancer1.getCoordinates(), cancer1);
        entities.put(cancer2.getCoordinates(), cancer2);
        entities.put(cancer3.getCoordinates(), cancer3);
        entities.put(cancer4.getCoordinates(), cancer4);
        entities.put(cancer5.getCoordinates(), cancer5);
        entities.put(cancer6.getCoordinates(), cancer6);
        entities.put(cancer7.getCoordinates(), cancer7);

        entities.put(palm.getCoordinates(), palm);
        entities.put(palm1.getCoordinates(), palm1);
        entities.put(palm2.getCoordinates(), palm2);
        entities.put(palm3.getCoordinates(), palm3);
        entities.put(palm4.getCoordinates(), palm4);
        entities.put(palm5.getCoordinates(), palm5);
        entities.put(palm6.getCoordinates(), palm6);
        entities.put(palm7.getCoordinates(), palm7);
        entities.put(palm8.getCoordinates(), palm8);
        entities.put(palm9.getCoordinates(), palm9);
        entities.put(palm10.getCoordinates(), palm10);
        entities.put(palm11.getCoordinates(), palm11);
        entities.put(palm12.getCoordinates(), palm12);
        entities.put(palm13.getCoordinates(), palm13);
        entities.put(palm14.getCoordinates(), palm14);
        //entities.put(rock15.getCoordinates(), rock15);
        //entities.put(rock16.getCoordinates(), rock16);
        //entities.put(rock17.getCoordinates(), rock17);
        entities.put(palm18.getCoordinates(), palm18);
        entities.put(palm19.getCoordinates(), palm19);
        entities.put(palm20.getCoordinates(), palm20);
        entities.put(palm21.getCoordinates(), palm21);
        entities.put(palm22.getCoordinates(), palm22);
        //entities.put(rock23.getCoordinates(), rock23);
        entities.put(palm24.getCoordinates(), palm24);
        entities.put(palm25.getCoordinates(), palm25);
        //entities.put(rock26.getCoordinates(), rock26);


        entities.put(sand0.getCoordinates(), sand0);
        entities.put(sand1.getCoordinates(), sand1);
        //entities.put(tree2.getCoordinates(), tree2);
        entities.put(sand3.getCoordinates(), sand3);
        entities.put(sand4.getCoordinates(), sand4);
        entities.put(sand5.getCoordinates(), sand5);
        entities.put(sand6.getCoordinates(), sand6);
        entities.put(sand7.getCoordinates(), sand7);
        entities.put(sand8.getCoordinates(), sand8);
        entities.put(sand9.getCoordinates(), sand9);
        entities.put(sand10.getCoordinates(), sand10);
        entities.put(sand11.getCoordinates(), sand11);
        entities.put(sand12.getCoordinates(), sand12);
        entities.put(sand13.getCoordinates(), sand13);
        entities.put(sand14.getCoordinates(), sand14);
        entities.put(sand15.getCoordinates(), sand15);
        entities.put(sand16.getCoordinates(), sand16);
        entities.put(sand17.getCoordinates(), sand17);
        entities.put(sand18.getCoordinates(), sand18);
        entities.put(sand19.getCoordinates(), sand19);
        entities.put(sand20.getCoordinates(), sand20);
        entities.put(sand21.getCoordinates(), sand21);
        entities.put(sand22.getCoordinates(), sand22);
        entities.put(sand23.getCoordinates(), sand23);
        entities.put(sand24.getCoordinates(), sand24);
        entities.put(sand25.getCoordinates(), sand25);

    }

    public Entity getValue (Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeFromMap (Coordinates coordinates) {
        entities.remove(coordinates, entities.get(coordinates));
    }

    public void mapPut(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void setAllEarth () {
        Column[] types = Column.values();
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                Water water = new Water(new Coordinates(i,types[j]));
                //если данная клетка не занята -> установить землю
                if (!entities.containsKey(new Coordinates(i,types[j]))) {
                    entities.put(new Coordinates(i, types[j]), water);
                }
            }
        }
    }
}
