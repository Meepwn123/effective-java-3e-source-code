package effectivejava.chapter8.item50;

import java.util.Date;

/**
 * Two attacks on the internals of an "immutable" period (195 - 196)
 * @author Meepwn
 */
public class Attacks {
    public static void main(String[] args) {
        // 1. Attack the internals of a Period instance  (Page 195)
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies internals of p!
        end.setYear(78);
        System.out.println(p);

        // 2.Second attack on the internals of a Period instance  (Page 196)
        start = new Date();
        end = new Date();
        p = new Period(start, end);
        // Modifies internals of p!
        p.end().setYear(78);
        System.out.println(p);
    }
}
