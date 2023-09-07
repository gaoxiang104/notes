package pers.xgo.onjava.chapter16_validating;

import static com.google.common.base.Verify.*;

public class GuavaAssertions {
    public static void main(String[] args) {
        verify(2 + 2 == 4);

        try {
            verify(1 + 2 == 4);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            verify(1 + 2 == 4, "Bad math");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            verify(1 + 2 == 4, "Bad math: %s", "not 4");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;

        try {
            verifyNotNull(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            verifyNotNull(s, "Shouldn't be null : %s", "arg s");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
