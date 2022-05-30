package me.cal1br.santaworkshop.entity;

import me.cal1br.santaworkshop.factory.AbstractFactory;
import me.cal1br.santaworkshop.observer.Observer;
import me.cal1br.santaworkshop.toy.Toy;

import java.util.concurrent.atomic.AtomicLong;

public class Elf implements Observer {

    //AtomicLong for possible concurrency
    private static final AtomicLong idCounter = new AtomicLong();

    long id;

    public Elf() {
        this.id = idCounter.getAndIncrement();
    }

    public static Long getNumberOfElves() {
        return idCounter.get();
    }

    @Override
    public void update(final Class<? extends Toy> toyToMake) {

        final Toy toy = AbstractFactory.Provider.INSTANCE
                .getFactory(toyToMake)
                .create();
        Workshop.INSTANCE.addToyToStorage(toy);
    }
}
