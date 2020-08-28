package effectivejava.chapter2.item8;

/**
 * Well-behaved client of resource with cleaner safety-net (Page 29)
 * @author Meepwn
 */
public class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        }
    }
}
