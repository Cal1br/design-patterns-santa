package me.cal1br.santaworkshop.entity;


import me.cal1br.santaworkshop.command.Command;
import me.cal1br.santaworkshop.command.MakeBikesCommand;
import me.cal1br.santaworkshop.command.MakeDollsCommand;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Enum singleton, see Effective Java 3rd e. Item 3
public enum SantaClaus {
    INSTANCE;

    final Random random = ThreadLocalRandom.current();

    //    MagicBoard board;
    public void makeToys() {
        System.out.println("Good morning! Time to make toys!");
        thinkOfToy().execute();

    }

    private Command thinkOfToy() {
        if (random.nextInt(100) > 50) {
            return new MakeBikesCommand();
        }
        return new MakeDollsCommand();
    }
}
