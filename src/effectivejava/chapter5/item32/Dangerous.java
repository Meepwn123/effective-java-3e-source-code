package effectivejava.chapter5.item32;

import java.util.List;

/**
 * It is unsafe to store a value in a generic varargs array parameter (Page 125)
 *
 * @author Meepwn
 */
public class Dangerous {

    /**
     * Mixing generics and varargs can violate type safety!
     */
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);

        Object[] objects = stringLists;
        // Heap pollution
        objects[0] = intList;

        // ClassCastException
        String s = stringLists[0].get(0);
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
