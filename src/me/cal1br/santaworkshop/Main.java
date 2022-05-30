package me.cal1br.santaworkshop;

import me.cal1br.santaworkshop.entity.Elf;
import me.cal1br.santaworkshop.entity.MagicBoard;
import me.cal1br.santaworkshop.entity.SantaClaus;
import me.cal1br.santaworkshop.entity.Workshop;

public class Main {

    public static void main(String[] args) {
        final SantaClaus santaClaus = SantaClaus.INSTANCE;
        final Elf elf0 = new Elf();
        final Elf elf1 = new Elf();
        final Elf elf2 = new Elf();

        MagicBoard.INSTANCE.subscribe(elf0);
        MagicBoard.INSTANCE.subscribe(elf1);
        MagicBoard.INSTANCE.subscribe(elf2);

        santaClaus.makeToys();

        System.out.println("\nFinal Statistics:" +
                "\nEmployed elves: " + Elf.getNumberOfElves() +
                "\nCreated toys: " + Workshop.INSTANCE.checkoutToys());
    }
}

