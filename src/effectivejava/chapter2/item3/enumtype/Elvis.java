package effectivejava.chapter2.item3.enumtype;

/**
 * Enum singleton - the preferred approach (Page 18)
 * @author Meepwn
 */
public enum Elvis {

    // 实例对象
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
