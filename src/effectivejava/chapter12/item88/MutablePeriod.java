package effectivejava.chapter12.item88;


import java.io.*;
import java.util.Date;

/**
 * @author Meepwn
 * @date 2020/09/22 11:06
 * @description
 */
public class MutablePeriod {

    /** A period instance */
    public final Period period;
    /** period's start field, to which we shouldn't have access */
    public final Date end;
    /** period's end field, to which we shouldn't have access */
    public final Date start;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // serialize a valid Period Instance
            out.writeObject(new Period(new Date(), new Date()));

            /*
             * Append rogue "previous object refs" for internal Date fields in Period.
             * For details, see "Java Object Serialization Specification" Section 6.4
             */
            // Ref #5
            byte[] ref = {0X71, 0, 0X7e, 0, 5};

            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            // Deserialize Period and "stolen" Date references
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            this.period = (Period)in.readObject();
            this.start = (Date)in.readObject();
            this.end = (Date)in.readObject();

        } catch (IOException | ClassNotFoundException exception) {
            throw new AssertionError(exception);
        }
    }

}
