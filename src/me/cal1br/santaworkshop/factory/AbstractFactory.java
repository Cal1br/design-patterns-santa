package me.cal1br.santaworkshop.factory;

import me.cal1br.santaworkshop.toy.Toy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFactory<T extends Toy> {

    AbstractFactory(Class<T> typeToken, Class<? extends AbstractFactory<T>> factoryToken) {
        Provider.INSTANCE.container.putIfAbsent(typeToken, factoryToken);
    }

    public abstract T create();

    /**
     * A Factory provider. It holds the different {@link AbstractFactory} implementations
     * and returns them when asked.
     */
    public enum Provider {
        INSTANCE;

        static {
            //Normally an app would create concrete implementations at the initialization stage,
            //but for this example we are going to create the factories manually
            new BikeFactory();
            new DollFactory();
        }

        //We use type tokens because strings are poor substitutes of data types. See Effective Java 3rd e. Item 62
        private final Map<Class<? extends Toy>, Class<? extends AbstractFactory>> container = new HashMap<>();

        public AbstractFactory getFactory(Class<? extends Toy> token) {
            try {
                return Provider.INSTANCE.container.get(token).getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
                //Normally we would use slf4j but this is a project without dependencies.
                System.out.println("There was an ERROR getting a factory for " + token + ".\n" +
                        "Couldn't instantiate factory!");
                //no recovery from this
                throw new RuntimeException();
            }
        }
    }
}
