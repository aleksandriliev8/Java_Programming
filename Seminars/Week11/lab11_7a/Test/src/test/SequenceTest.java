package test;

import selector.Selector;
import sequence.Sequence;

import java.util.Random;

public class SequenceTest {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(8);
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            sequence.add(random.nextInt(10, 101));
        }

        System.out.println("Forwards:");
        Selector selector = sequence.getSelector();

        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }

        System.out.println("\nBackwards:");
        Selector rselector = sequence.getRselector();

        while (!rselector.end()){
            System.out.println(rselector.current());
            rselector.next();
        }
    }
}
