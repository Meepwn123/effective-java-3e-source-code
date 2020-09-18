package effectivejava.chapter8.item55;

import java.util.*;

/**
 * Using Optional<T> as a return type (Pages 209 - 210)
 * @author Meepwn
 */
public class Max {

    /** Returns maximum value in collection - throws exception if empty (Page 209) */
    public static <E extends Comparable<E>> E max1(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    /** Returns maximum value in collection as an Optional<E> (Page 209) */
    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    /** Returns max val in collection as Optional<E> - uses stream (Page 210) */
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        System.out.println(max(words));

        // Using an optional to provide a chosen default value (Page 210)
        String lastWordInLexicon = max(words).orElse("No words...");
        System.out.println(lastWordInLexicon);
    }
}
