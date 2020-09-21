package effectivejava.chapter11.item83;

/**
 * Initialization styles - Pages 333-
 *
 * @author Meepwn
 */
@SuppressWarnings("unused")
public class Initialization {

    /**
     * Normal initialization of an instance field1 - Page 282
     */
    private final FieldType field1 = computeFieldValue();

    /**
     * Lazy initialization of instance field2 - synchronized accessor - Page 282
     */
    private FieldType field2;

    private synchronized FieldType getField2() {
        if (field2 == null) {
            field2 = computeFieldValue();
        }
        return field2;
    }

    /**
     * Lazy initialization holder class idiom for static fields - Page 282
     */
    private static class FieldHolder {
        static final FieldType FIELD = computeFieldValue();
    }

    private static FieldType getField() {
        return FieldHolder.FIELD;
    }


    /**
     * Double-check idiom for lazy initialization of instance fields - Page 282 - 283
     */
    private volatile FieldType field4;

    /**
     * NOTE: The code for this method in the first printing had a serious error (see errata for details)!
     */
    private FieldType getField4() {
        FieldType result = field4;
        // First check (no locking)
        if (result != null) {
            return result;
        }

        synchronized (this) {
            // Second check (with locking)
            if (field4 == null) {
                field4 = computeFieldValue();
            }
            return field4;
        }
    }


    /**
     * Single-check idiom - can cause repeated initialization! - Page 283
     */
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null) {
            field5 = result = computeFieldValue();
        }
        return result;
    }

    private static FieldType computeFieldValue() {
        return new FieldType();
    }
}
