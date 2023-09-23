package com.dragunov;
import com.dragunov.entities.*;

import java.util.*;

//Карта, содержит в себе коллекцию для хранения существ
//и их расположения.
public class Maps {

    private Map <Coordinates, Entity> entities = new HashMap<>();

    public Set<Coordinates> getKeySet(){
        return entities.keySet();
    }


    MouseHouse mouseHouse = new MouseHouse(new Coordinates(2, Vertical.G));
    MouseHouse mouseHouse1 = new MouseHouse(new Coordinates(9, Vertical.L));

    Herbivore herbivore1 = new Herbivore(new Coordinates(1, Vertical.A),1 ,10);
    Herbivore herbivore2 = new Herbivore(new Coordinates(7,Vertical.J),1, 10);
    Herbivore herbivore3 = new Herbivore(new Coordinates(4,Vertical.A),1, 10);

    Predator predator = new Predator(new Coordinates(3, Vertical.J),2,10,5);

    Grass grass1 = new Grass(new Coordinates(3, Vertical.F));
    Grass grass2 = new Grass(new Coordinates(9, Vertical.E));
    Grass grass3 = new Grass(new Coordinates(10, Vertical.M));
    Grass grass4 = new Grass(new Coordinates(8, Vertical.J));
    Grass grass5 = new Grass(new Coordinates(9, Vertical.A));
    Grass grass6 = new Grass(new Coordinates(7, Vertical.H));
    Grass grass7 = new Grass(new Coordinates(1, Vertical.M));

    Rock rock = new Rock(new Coordinates(1, Vertical.E));
    Rock rock1 = new Rock(new Coordinates(2, Vertical.E));
    Rock rock2 = new Rock(new Coordinates(3, Vertical.E));
    Rock rock3 = new Rock(new Coordinates(7, Vertical.B));
    Rock rock4 = new Rock(new Coordinates(8, Vertical.B));
    Rock rock5 = new Rock(new Coordinates(9, Vertical.B));
    Rock rock6 = new Rock(new Coordinates(9, Vertical.C));
    Rock rock7 = new Rock(new Coordinates(1, Vertical.F));
    Rock rock8 = new Rock(new Coordinates(2, Vertical.F));
    Rock rock9 = new Rock(new Coordinates(1, Vertical.G));
    Rock rock10 = new Rock(new Coordinates(1, Vertical.D));
    Rock rock11 = new Rock(new Coordinates(10, Vertical.L));
    Rock rock12 = new Rock(new Coordinates(10, Vertical.K));
    Rock rock13 = new Rock(new Coordinates(9, Vertical.K));
    Rock rock14 = new Rock(new Coordinates(10, Vertical.J));
    //Rock rock15 = new Rock(new Coordinates(3, Vertical.M));
    //Rock rock16 = new Rock(new Coordinates(4, Vertical.M));
    //Rock rock17 = new Rock(new Coordinates(5, Vertical.M));
    Rock rock18 = new Rock(new Coordinates(3, Vertical.L));
    Rock rock19 = new Rock(new Coordinates(4, Vertical.K));
    Rock rock20 = new Rock(new Coordinates(4, Vertical.J));
    Rock rock21 = new Rock(new Coordinates(5, Vertical.K));
    Rock rock22 = new Rock(new Coordinates(6, Vertical.L));
    //Rock rock23 = new Rock(new Coordinates(7, Vertical.M));
    Rock rock24 = new Rock(new Coordinates(4, Vertical.L));
    Rock rock25 = new Rock(new Coordinates(5, Vertical.L));
    //Rock rock26 = new Rock(new Coordinates(6, Vertical.M));

    Tree tree0 = new Tree(new Coordinates(3, Vertical.B));
    Tree tree1 = new Tree(new Coordinates(3, Vertical.A));
    //Tree tree2 = new Tree(new Coordinates(3, Vertical.C));
    Tree tree3 = new Tree(new Coordinates(4, Vertical.C));
    Tree tree4 = new Tree(new Coordinates(4, Vertical.B));
    Tree tree5 = new Tree(new Coordinates(2, Vertical.A));
    Tree tree6 = new Tree(new Coordinates(10, Vertical.A));
    Tree tree7 = new Tree(new Coordinates(10, Vertical.B));
    Tree tree8 = new Tree(new Coordinates(10, Vertical.C));
    Tree tree9 = new Tree(new Coordinates(8, Vertical.C));
    Tree tree10 = new Tree(new Coordinates(10, Vertical.D));
    Tree tree11 = new Tree(new Coordinates(9, Vertical.D));
    Tree tree12 = new Tree(new Coordinates(10, Vertical.E));
    Tree tree13 = new Tree(new Coordinates(6, Vertical.E));
    Tree tree14 = new Tree(new Coordinates(5, Vertical.F));
    Tree tree15 = new Tree(new Coordinates(7, Vertical.F));
    Tree tree16 = new Tree(new Coordinates(6, Vertical.F));
    Tree tree17 = new Tree(new Coordinates(5, Vertical.G));
    Tree tree18 = new Tree(new Coordinates(4, Vertical.G));
    Tree tree19 = new Tree(new Coordinates(6, Vertical.G));
    Tree tree20 = new Tree(new Coordinates(7, Vertical.G));
    Tree tree21 = new Tree(new Coordinates(8, Vertical.G));
    Tree tree22 = new Tree(new Coordinates(5, Vertical.H));
    Tree tree23 = new Tree(new Coordinates(6, Vertical.H));
    Tree tree24 = new Tree(new Coordinates(6, Vertical.I));
    Tree tree25 = new Tree(new Coordinates(8, Vertical.F));


    public void setDefaultPosition () {
        entities.put(mouseHouse.getCoordinates(), mouseHouse);
        entities.put(mouseHouse1.getCoordinates(), mouseHouse1);

        entities.put(herbivore1.getCoordinates(), herbivore1);
        entities.put(herbivore2.getCoordinates(), herbivore2);
        entities.put(herbivore3.getCoordinates(), herbivore3);

        entities.put(predator.getCoordinates(), predator);

        entities.put(grass1.getCoordinates(), grass1);
        entities.put(grass2.getCoordinates(),grass2);
        entities.put(grass3.getCoordinates(),grass3);
        entities.put(grass4.getCoordinates(), grass4);
        entities.put(grass5.getCoordinates(), grass5);
        entities.put(grass6.getCoordinates(), grass6);
        entities.put(grass7.getCoordinates(), grass7);

        entities.put(rock.getCoordinates(), rock);
        entities.put(rock1.getCoordinates(), rock1);
        entities.put(rock2.getCoordinates(), rock2);
        entities.put(rock3.getCoordinates(), rock3);
        entities.put(rock4.getCoordinates(), rock4);
        entities.put(rock5.getCoordinates(), rock5);
        entities.put(rock6.getCoordinates(), rock6);
        entities.put(rock7.getCoordinates(), rock7);
        entities.put(rock8.getCoordinates(), rock8);
        entities.put(rock9.getCoordinates(), rock9);
        entities.put(rock10.getCoordinates(), rock10);
        entities.put(rock11.getCoordinates(), rock11);
        entities.put(rock12.getCoordinates(), rock12);
        entities.put(rock13.getCoordinates(), rock13);
        entities.put(rock14.getCoordinates(), rock14);
        //entities.put(rock15.getCoordinates(), rock15);
        //entities.put(rock16.getCoordinates(), rock16);
        //entities.put(rock17.getCoordinates(), rock17);
        entities.put(rock18.getCoordinates(), rock18);
        entities.put(rock19.getCoordinates(), rock19);
        entities.put(rock20.getCoordinates(), rock20);
        entities.put(rock21.getCoordinates(), rock21);
        entities.put(rock22.getCoordinates(), rock22);
        //entities.put(rock23.getCoordinates(), rock23);
        entities.put(rock24.getCoordinates(), rock24);
        entities.put(rock25.getCoordinates(), rock25);
        //entities.put(rock26.getCoordinates(), rock26);


        entities.put(tree0.getCoordinates(), tree0);
        entities.put(tree1.getCoordinates(), tree1);
        //entities.put(tree2.getCoordinates(), tree2);
        entities.put(tree3.getCoordinates(), tree3);
        entities.put(tree4.getCoordinates(), tree4);
        entities.put(tree5.getCoordinates(), tree5);
        entities.put(tree6.getCoordinates(), tree6);
        entities.put(tree7.getCoordinates(), tree7);
        entities.put(tree8.getCoordinates(), tree8);
        entities.put(tree9.getCoordinates(), tree9);
        entities.put(tree10.getCoordinates(), tree10);
        entities.put(tree11.getCoordinates(), tree11);
        entities.put(tree12.getCoordinates(), tree12);
        entities.put(tree13.getCoordinates(), tree13);
        entities.put(tree14.getCoordinates(), tree14);
        entities.put(tree15.getCoordinates(), tree15);
        entities.put(tree16.getCoordinates(), tree16);
        entities.put(tree17.getCoordinates(), tree17);
        entities.put(tree18.getCoordinates(), tree18);
        entities.put(tree19.getCoordinates(), tree19);
        entities.put(tree20.getCoordinates(), tree20);
        entities.put(tree21.getCoordinates(), tree21);
        entities.put(tree22.getCoordinates(), tree22);
        entities.put(tree23.getCoordinates(), tree23);
        entities.put(tree24.getCoordinates(), tree24);
        entities.put(tree25.getCoordinates(), tree25);

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
        Vertical[] types = Vertical.values();
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                Earth earth = new Earth(new Coordinates(i,types[j]));
                //если данная клетка не занята -> установить землю
                if (!entities.containsKey(new Coordinates(i,types[j]))) {
                    entities.put(new Coordinates(i, types[j]), earth);
                }
            }
        }
    }
}
