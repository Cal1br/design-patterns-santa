package me.cal1br.santaworkshop.entity;

import me.cal1br.santaworkshop.observer.Observer;
import me.cal1br.santaworkshop.publisher.Publisher;
import me.cal1br.santaworkshop.toy.Toy;

import java.util.LinkedList;
import java.util.List;

//Enum singleton, see Effective Java 3rd e. Item 3
public enum MagicBoard implements Publisher {
    INSTANCE;

    private final List<Observer> subscribers = new LinkedList<>();
    private Class<? extends Toy> state;

    @Override
    public void subscribe(final Observer observer) {
        this.subscribers.add(observer);
    }


    @Override
    public void unsubscribe(final Observer observer) {
        this.subscribers.remove(observer);
    }

    /**
     * Changes state of the object and notifies subscribers
     */
    public void changeState(Class<? extends Toy> toy) {
        this.state = toy;
        this.notifySubscribers();
    }

    private void notifySubscribers() {
        for (final Observer subscriber : subscribers) {
            subscriber.update(state);
        }
    }
}
