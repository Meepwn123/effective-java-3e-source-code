package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.*;


/**
 * Builder pattern for class hierarchies (Page 14)
 * <p>
 * Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies,
 * not just builders
 *
 * @author Meepwn
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        // See Item 50
        toppings = builder.toppings.clone();
    }
}
