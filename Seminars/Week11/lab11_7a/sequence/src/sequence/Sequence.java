package sequence;

import selector.Selector;

public class Sequence { // outer class
    // Holds a sequence of Objects.
    private Object[] obs;
    private int next = 0;

    public Sequence(int size) {
        obs = new Object[size];
    }
    public void add(Object x) {
        if(next < obs.length) {
            obs[next] = x;
            next++;
        }
    }
    private class Sselector implements Selector {
        // inner class манипулира преместване от първия към последния
        int i = 0;
        public boolean end() {
            return i == obs.length;
        }
        public Object current() {
            return obs[i];
        }
        public void next() {
            if(i < obs.length) i++;
        }
    }

    private class Rselector implements Selector {

        int i = obs.length - 1;
        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return obs[i];
        }

        @Override
        public void next() {
            if(i >= 0) i--;
        }
    }
    public Selector getSelector() {
        return new Sselector();
    }

    public Selector getRselector() {
        return new Rselector();
    }
} // end of Sequence.java

