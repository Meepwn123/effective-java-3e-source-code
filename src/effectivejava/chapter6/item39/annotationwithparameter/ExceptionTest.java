package effectivejava.chapter6.item39.annotationwithparameter;

// Annotation type with a parameter (Page 154 - 155)
import java.lang.annotation.*;
/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to succeed.
 * @author Meepwn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
