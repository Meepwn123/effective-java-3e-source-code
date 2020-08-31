package effectivejava.chapter3.item14;
import java.util.*;

/**
 * The benefits of implementing Comparable (Page 58)
 * @author Meepwn
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
