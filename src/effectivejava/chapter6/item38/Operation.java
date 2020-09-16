package effectivejava.chapter6.item38;

/**
 * Emulated extensible enum using an interface (Page 149)
 * @author Meepwn
 */
public interface Operation {
    double apply(double x, double y);
}
