package me.cal1br.santaworkshop.factory;

import me.cal1br.santaworkshop.toy.BikeToy;

public class BikeFactory extends AbstractFactory<BikeToy> {

    public BikeFactory() {
        super(BikeToy.class, BikeFactory.class);
    }

    @Override
    public BikeToy create() {
        return new BikeToy();
    }
}
