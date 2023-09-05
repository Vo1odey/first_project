package com.dragunov.entities;
import com.dragunov.*;
import com.dragunov.Maps;


import java.util.*;


//Травоядное, наследуется от Entities.Creature. Стремится найти траву
//(Entities.Grass), может потратить свой ход на движение в сторону
//травы, либо на её поглощение.
public class Herbivore extends Creature {

    public Herbivore (Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp, "🐭");
    }
    public Herbivore(){}
    @Override
    public String toString() {
        return picture;
    }

    public void makeMove(Herbivore herbivore, Grass grass) {
        Coordinates hrbCrd = herbivore.getCoordinates();      //текущие координаты существа

        Vertical[] upValues = Vertical.values();
        Coordinates node;


        Coordinates left = null;
        Coordinates right = null;
        Coordinates up = null;
        Coordinates down = null;

        List <Coordinates> fromCrd = new ArrayList<>();      //координаты ОТКУДА мы пришли
        List <Coordinates> visited = new ArrayList<>();    //посещенные координаты
        Queue <Coordinates> qCrd = new LinkedList<>();     //очередь следующих к посещению координат

        fromCrd.add(hrbCrd);        //Стартовые координаты = ОТКУДА
        qCrd.add(hrbCrd);

        while (!qCrd.isEmpty()) {

            node = qCrd.poll();

                if (node.equals(grass.getCoordinates())) {
                    System.out.println(node + "!!!");
                    System.out.println(fromCrd);
                }

            visited.add(node);

            //LEFT
            if ((node.getVertical().ordinal() - 1 != -1) && !(visited.contains(left))) {
                left = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() - 1]);
                qCrd.add(left);
                visited.add(left);

            }
            //RIGHT
            if ((node.getVertical().ordinal() + 1 != 8) && !(visited.contains(right))) {
                right = new Coordinates(node.getHorizontal() ,upValues[node.getVertical().ordinal() +1 ]);
                qCrd.add(right);
                visited.add(right);

            }
            //UP
            if ((node.getHorizontal() - 1 != 0) && !(visited.contains(up))) {
                up = new Coordinates(node.getHorizontal() - 1 ,upValues[node.getVertical().ordinal()]);
                qCrd.add(up);
                visited.add(up);

            }
            //DOWN
            if ((node.getHorizontal() + 1 != 9) && !(visited.contains(down))) {
                down = new Coordinates(node.getHorizontal() + 1 ,upValues[node.getVertical().ordinal()]);
                qCrd.add(down);
                visited.add(down);

            }
        }
    }
}
/*
BFS(start_node, goal_node) {
 for(all nodes i) visited[i] = false; // изначально список посещённых узлов пуст
 queue.push(start_node);              // начиная с узла-источника
 while(! queue.empty() ) {            // пока очередь не пуста
  node = queue.pop();                 // извлечь первый элемент в очереди
  if(node == goal_node) {
   return true;                       // проверить, не является ли текущий узел целевым
  }
  visited[node] = true;               // пометить текущую ноду посещенной
  foreach(child in expand(node)) {    // все преемники текущего узла, ...
   if(visited[child] == false) {      // ... которые ещё не были посещены ...
    queue.push(child);                // ... добавить в конец очереди...
    visited[child] = true;            // ... и пометить как посещённые
   }
  }
 }
 return false;                        // Целевой узел недостижим
}
*/