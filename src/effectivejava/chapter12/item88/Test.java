package effectivejava.chapter12.item88;

import java.util.Date;

/**
 * @author Meepwn
 * @date 2020/09/22 11:30
 * @description
 */
public class Test {

    public static void main(String[] args) {

        MutablePeriod mutablePeriod = new MutablePeriod();
        Period period = mutablePeriod.period;
        Date end = mutablePeriod.end;

        end.setYear(78);
        System.out.println(period);

        end.setYear(69);
        System.out.println(period);

    }

}
