package me.cal1br.santaworkshop.observer;

import me.cal1br.santaworkshop.toy.Toy;

public interface Observer {
    void notify(Class<? extends Toy> toyToMake); //event or command ? todo
}
