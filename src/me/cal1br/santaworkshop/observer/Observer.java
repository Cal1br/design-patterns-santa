package me.cal1br.santaworkshop.observer;

import me.cal1br.santaworkshop.toy.Toy;

public interface Observer {
    void update(Class<? extends Toy> toyToMake);
}
