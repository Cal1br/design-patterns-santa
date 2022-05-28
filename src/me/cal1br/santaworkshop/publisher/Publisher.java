package me.cal1br.santaworkshop.publisher;

import me.cal1br.santaworkshop.observer.Observer;

public interface Publisher {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}
