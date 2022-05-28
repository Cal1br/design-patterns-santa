package me.cal1br.santaworkshop.command;

import me.cal1br.santaworkshop.entity.MagicBoard;
import me.cal1br.santaworkshop.toy.BikeToy;

public class MakeBikesCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Magic words: \"I need bikes\"");
        MagicBoard.INSTANCE.changeState(BikeToy.class);
    }
}
