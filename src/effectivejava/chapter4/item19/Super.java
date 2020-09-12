package effectivejava.chapter4.item19;

/**
 *
 * !! NEVER DO THIS !!
 *
 * Class whose constructor invokes an overridable method. (Page 84)
 * @author Meepwn
 */
public class Super {
    /** Broken - constructor invokes an overridable method */
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
