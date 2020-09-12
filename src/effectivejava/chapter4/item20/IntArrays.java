package effectivejava.chapter4.item20;
import java.util.*;

/**
 * Concrete implementation built atop skeletal implementation (Page 88)
 * @author Meepwn
 */
public class IntArrays {

    static List<Integer> intArrayAsList(int[] a) {

        Objects.requireNonNull(a);

        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                // Autoboxing (Item 6)
                return a[i];
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                // Auto-unboxing
                a[i] = val;
                // Autoboxing
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        List<Integer> list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
