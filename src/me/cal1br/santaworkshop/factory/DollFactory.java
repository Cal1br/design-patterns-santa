package me.cal1br.santaworkshop.factory;

import me.cal1br.santaworkshop.toy.DollToy;

public class DollFactory extends AbstractFactory<DollToy> {

    public DollFactory() {
        super(DollToy.class, DollFactory.class);
    }

    @Override
    public DollToy create() {
        return new DollToy();
    }
}
