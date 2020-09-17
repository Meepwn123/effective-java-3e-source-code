package effectivejava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Frequency table examples showing improper and proper use of stream (Page 177 - 11)
 * @author Meepwn
 */
public class Freq {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        // Uses the streams API but not the paradigm -- Don't do this! (Page 177)
        Map<String, Long> freq = new HashMap<>(16);
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word ->
                    freq.merge(word.toLowerCase(), 1L, Long::sum)
            );
        }

        // Proper use of streams to initialize a frequency table (Page 178)
        Map<String, Long> freq2;
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq2 = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq2);

        // Pipeline to get a top-ten list of words from a frequency table (Page 178)
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
