package effectivejava.chapter11.item81;
import java.util.concurrent.*;

/**
 * Concurrent canonicalizing map atop ConcurrentMap - Pages 275
 * @author Meepwn
 */
@SuppressWarnings("unused")
public class Intern {

    /** Concurrent canonicalizing map atop ConcurrentMap - not optimal */
    private static final ConcurrentMap<String, String> MAP =
            new ConcurrentHashMap<>();

//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return previousValue == null ? s : previousValue;
//    }

    /** Concurrent canonicalizing map atop ConcurrentMap - faster! */
    public static String intern(String s) {
        String result = MAP.get(s);
        if (result == null) {
            result = MAP.putIfAbsent(s, s);
            if (result == null) {
                result = s;
            }
        }
        return result;
    }
}