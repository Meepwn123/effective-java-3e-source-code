package effectivejava.chapter6.item34;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * Enum type with constant-specific class bodies and data (Pages 137 - 139)
 * @author Meepwn
 */
public enum Operation {

    // 四则运算
    PLUS("+") {
        @Override
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; }

    @Override public String toString() { return symbol; }

    public abstract double apply(double x, double y);

    /** Implementing a fromString method on an enum type (Page 139) */
    private static final Map<String, Operation> STRING_TO_ENUM =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    /** Returns Operation for string, if any*/
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(STRING_TO_ENUM.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}
