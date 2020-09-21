package effectivejava.chapter11.item79;

/**
 * Set observer callback interface - Page 266
 * @author Meepwn
 */
@FunctionalInterface
public interface SetObserver<E> {
    /**
     * Invoked when an element is added to the observable set
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set, E element);
}
