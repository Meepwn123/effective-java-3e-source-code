package effectivejava.chapter2.item7;
import java.util.*;

/**
 * Can you spot the "memory leak"?  (Pages 23-24)
 * @author Meepwn
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element,
     * roughly doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /** Corrected version of pop method (Page 24) */
    public Object safePop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        // Eliminate obsolete reference
        elements[size] = null;
        return result;
    }

    public static void main(String[] args) throws EmptyStackException {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }

        while (true) {
            System.err.println(stack.pop());
        }
    }
}
