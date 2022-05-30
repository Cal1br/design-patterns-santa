package me.cal1br.santaworkshop.entity;

import me.cal1br.santaworkshop.toy.Toy;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Workshop {
    INSTANCE;

    private final List<Toy> storage = new LinkedList<>();

    public boolean addToyToStorage(Toy toy) {
        return this.storage.add(toy);
    }

    /**
     * A function for checking out how many toys have been created so far.
     * @return Represents a map of representing the number of created toys mapped by class name
     */
    public Map<String, Integer> checkoutToys() {
        return storage.stream().collect(Collectors.toMap(k -> k.getClass().getSimpleName(), v -> 1, Integer::sum));
    }
}
