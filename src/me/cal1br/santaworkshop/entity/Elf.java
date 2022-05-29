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

    @Override
    public void notify(final Class<? extends Toy> toyToMake) {

        final Toy toy = AbstractFactory.Provider.INSTANCE
                .getFactory(toyToMake)
                .create();
        System.out.println("Created one " + toy + " by elf id: " + id);
    }
}
