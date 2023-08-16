package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {

static Queue <Coordinates> qGrass = new LinkedList<>();
static List <Coordinates> visited = new ArrayList<>();
    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");
    }
    public Herbivore(){}

    @Override
    public String toString() {
        return picture;
    }

    public void setQueueGrass(Maps maps, Herbivore herbivore){
        //найти весь сыр на карте

        ArrayList <Coordinates> allGrass = Search.BFS(maps, "Grass", herbivore.getCoordinates());
        while (!allGrass.isEmpty()) {
            if ((maps.entities.get(allGrass.get(0)) instanceof Grass) && !(qGrass.contains(allGrass.get(0)))) {
                qGrass.add(allGrass.get(0));
                allGrass.remove(0);
            } else allGrass.remove(0);
        }
    }

   public Queue<Coordinates> possibleCoordinates (Maps maps, Herbivore herbivore) {
       Vertical[] verticals = Vertical.values();
       Coordinates herbivoreCrd = herbivore.getCoordinates();
       Coordinates posibleCoordinates = null;



       Coordinates target = qGrass.peek();  //qGrass - очередь из сыра -> посмотреть первый элемент
       Queue<Coordinates> nextTurn = new LinkedList<>();  //следующий ход травоядного

        //Если А(0) сыра больше А(0) мыши & координата не выходит за пределы области ->
       //Возможные координаты = A++(1)
       //If возможная координата является землей || сыром -> добавить её в очередь хода
       //Возможная координата = A(0++) & не выходит за пределы области
       //If возможная координата !является деревом или камнем -> добавить её в очередь хода
       //Возможная координата = А(0--) & не выходит за пределы области
       //If возможная координата !является деревом или камнем -> добавить её в очередь хода

       //Пойти направо
       if ((target.getVertical().ordinal() > herbivoreCrd.getVertical().ordinal())
               && ((herbivoreCrd.getVertical().ordinal() + speed) != 8)) {
           posibleCoordinates = new Coordinates(herbivoreCrd.getHorizontal(),
                   verticals[herbivoreCrd.getVertical().ordinal() + speed]);
           if ((maps.entities.get(posibleCoordinates) instanceof Earth)
           || (maps.entities.get(posibleCoordinates) instanceof Grass)){
               nextTurn.add(posibleCoordinates);
               visited.add(posibleCoordinates);
           }

       }
        //Пойти налево ДДД
       if ((target.getVertical().ordinal() < herbivoreCrd.getVertical().ordinal())
               && ((herbivoreCrd.getVertical().ordinal() - speed) != -1)
               && !(visited.contains(posibleCoordinates))) {
           posibleCoordinates = new Coordinates(herbivoreCrd.getHorizontal(),
                   verticals[herbivoreCrd.getVertical().ordinal() - speed]);
           if ((maps.entities.get(posibleCoordinates) instanceof Earth)
                   || (maps.entities.get(posibleCoordinates) instanceof Grass)){
               nextTurn.add(posibleCoordinates);
               visited.add(posibleCoordinates);
           }
       }
       //Пойти вниз
       if ((target.getHorizontal() > herbivoreCrd.getHorizontal())
               && ((herbivoreCrd.getHorizontal() + speed) != 9)) {
           posibleCoordinates = new Coordinates(herbivoreCrd.getHorizontal() + speed,
                   verticals[herbivoreCrd.getVertical().ordinal()]);
           if ((maps.entities.get(posibleCoordinates) instanceof Earth)
                   || (maps.entities.get(posibleCoordinates) instanceof Grass)){
               nextTurn.add(posibleCoordinates);
               visited.add(posibleCoordinates);
           }
       }


       //Пойти наверх
       if ((target.getHorizontal() < herbivoreCrd.getHorizontal())
               && ((herbivoreCrd.getHorizontal() - speed) != 0)) {
           posibleCoordinates = new Coordinates(herbivoreCrd.getHorizontal() - speed,
                   verticals[herbivoreCrd.getVertical().ordinal()]);
           if ((maps.entities.get(posibleCoordinates) instanceof Earth)
                   || (maps.entities.get(posibleCoordinates) instanceof Grass)){
               nextTurn.add(posibleCoordinates);
               visited.add(posibleCoordinates);
           }
       }
       return nextTurn;
   }

    public void makeMove(Maps maps, Herbivore herbivore) {
        try {
        Coordinates target = qGrass.peek();  //qGrass - очередь из сыра -> посмотреть первый элемент
        Queue<Coordinates> nextTurn = possibleCoordinates(maps, herbivore);  //следующий ход травоядного

            if (target.equals(nextTurn.peek())) {
            qGrass.poll();

        }


        maps.entities.remove(herbivore.getCoordinates());
        herbivore.setCoordinates(nextTurn.poll());
        maps.entities.put(herbivore.getCoordinates(), herbivore);
    } catch (NullPointerException e) {
            System.out.println("End");
        }
    }
}

/*
Нужно через BFS возвращать очередь координат кратчайшего пути
от мыши до сыра.
Условие выше встает в тупик при первом препятствии.
Либо держать количество сыров больше 2ух (ничего не гарантирует).
Нужно чтобы BFS не мог ходить через препятствия.
 */