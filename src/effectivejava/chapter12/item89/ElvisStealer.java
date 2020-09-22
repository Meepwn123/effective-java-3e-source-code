package effectivejava.chapter12.item89;

import effectivejava.chapter12.item89.enumsingleton.Elvis;

import java.io.Serializable;

/**
 * @author Meepwn
 * @date 2020/09/22 11:53
 * @description stealer
 */
public class ElvisStealer implements Serializable {

    static Elvis impersonator;

    private Elvis payload;

    private Object readObject() {
        // save a reference to the "unresolved" Elvis instance
        impersonator = payload;
        // return object of correct type for
        return new String[] {"changed song"};
    }

    private static final long serialVersionID = 0L;

}
