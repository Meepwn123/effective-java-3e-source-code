package effectivejava.chapter2.item3.field;

import java.io.Serializable;

/**
 * Singleton with public final field  (Page 17)
 *
 * @author Meepwn
 */
public class Elvis implements Serializable {

    public static transient final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private Object readResolve() {
        // return the one true Elvis
        // and let the garbage collector take care of the Elvis impersonator.
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}