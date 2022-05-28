package me.cal1br.santaworkshop.command;

import me.cal1br.santaworkshop.entity.MagicBoard;
import me.cal1br.santaworkshop.toy.DollToy;

public class MakeDollsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Magic words: \"I need dolls\"");
        MagicBoard.INSTANCE.changeState(DollToy.class);
    }
}
