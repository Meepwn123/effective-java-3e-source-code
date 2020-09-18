package effectivejava.chapter9.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Printing the contents of a URL with transferTo, added in Java 9 (Page 226)
 * @author Meepwn
 */
public class Curl {

    public static void main(String[] args) throws IOException {
        String url = "http://www.baidu.com";
        try (InputStream in = new URL(url).openStream()) {
            in.transferTo(System.out);
        }
    }
}
