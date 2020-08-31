package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Point;

import java.util.concurrent.atomic.*;

/**
 * Trivial subclass of Point - doesn't add a value component (Page 39)
 *
 * @author Meepwn
 */
@SuppressWarnings("unused")
public class CounterPoint extends Point {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        COUNTER.incrementAndGet();
    }

    public static int numberCreated() {
        return COUNTER.get();
    }
}
