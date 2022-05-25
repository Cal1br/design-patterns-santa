package me.cal1br.santaworkshop.factory;

import me.cal1br.santaworkshop.toy.Toy;

import java.util.Map;

public abstract class AbstractFactory<T extends Toy> {

    AbstractFactory(Class<T> typeToken) {
        Provider.INSTANCE.container.putIfAbsent(typeToken, this.getClass());
    }

    public abstract T create();


    public enum Provider {
        INSTANCE;
        //We use type tokens because strings are poor substitutes of data types. See Effective Java 3rd e. Item 62
        private Map<Class<? extends Toy>, Class<? extends AbstractFactory>> container;
    }
}
