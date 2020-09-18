package effectivejava.chapter9.item61;
import java.util.*;

/**
 * Broken comparator - can you spot the flaw? - Page 229 - 230
 * @author Meepwn
 */
public class BrokenComparator {

    public static void main(String[] args) {

        // Broken Comparator - Page 229
        Comparator<Integer> brokenNaturalOrder =
                (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

       // Fixed Comparator - Page 230
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            // Auto-unboxing
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result1 = brokenNaturalOrder.compare(new Integer(42), new Integer(42));
        int result2 = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println(result1);
        System.out.println(result2);
    }

}
