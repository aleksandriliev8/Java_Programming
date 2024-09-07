package data.model;

import java.util.Random;
public enum CanRandomize {

    RAND(new Random());
    public final Random GENERATOR;
    CanRandomize(Random generator) {
        this.GENERATOR = generator;
    }
}
