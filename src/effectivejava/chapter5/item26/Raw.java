package effectivejava.chapter5.item26;

import java.util.*;

/**
 * Fails at runtime - unsafeAdd method uses a raw type (List)!  (Page 119)
 *
 * @author Meepwn
 */
public class Raw {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        // Has compiler-generated cast
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}

