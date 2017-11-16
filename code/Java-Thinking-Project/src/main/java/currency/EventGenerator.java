package currency;

public class EventGenerator extends IntGenerator {

    private int currentEventValue = 0;

    @Override
    public int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EventGenerator());
    }
}
