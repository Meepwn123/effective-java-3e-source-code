package effectivejava.chapter9.item59;
import java.util.*;

/**
 * Random number generation is hard! - Page 224 - 225
 * @author Meepwn
 */
public class RandomBug {

    /** Common but deeply flawed! */
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (random(n) < n/2) {
                low++;
            }
        }
        System.out.println(low);
    }
}
