package effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

/**
 * Frequency table implemented with map.merge, using lambda and method reference (Page 197)
 * @author Meepwn
 */
public class Freq {
    public static void main(String[] args) {
        Map<String, Integer> frequencyTable = new TreeMap<>();
        
        for (String s : args) {
            // Lambda
            frequencyTable.merge(s, 1, (count, incr) -> count + incr);
        }
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : args) {
            // Method reference
            frequencyTable.merge(s, 1, Integer::sum);
        }
        System.out.println(frequencyTable);

    }
}
