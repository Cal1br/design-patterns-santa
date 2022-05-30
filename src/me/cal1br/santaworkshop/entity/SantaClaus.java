package me.cal1br.santaworkshop.entity;


import me.cal1br.santaworkshop.command.Command;
import me.cal1br.santaworkshop.command.MakeBikesCommand;
import me.cal1br.santaworkshop.command.MakeDollsCommand;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Enum singleton, see Effective Java 3rd e. Item 3
public enum SantaClaus {
    INSTANCE;

    public void makeToys() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Good morning! Time to make toys!");
            thinkOfToy().execute();
            employMoreElves();
            System.out.println("Night...");
        }
    }

    private Command thinkOfToy() {
        final Random random = ThreadLocalRandom.current();
        if (random.nextInt(100) > 50) {
            return new MakeBikesCommand();
        }
        return new MakeDollsCommand();
    }

    private void employMoreElves() {
        final Random random = ThreadLocalRandom.current();
        final int randomInt = random.nextInt(100);
        if (randomInt > 75) {
            System.out.println("Time to employ more elves!");
            for (int i = 100 - randomInt; i > 0; i--) {
                MagicBoard.INSTANCE.subscribe(new Elf());
            }
        }
    }
}
