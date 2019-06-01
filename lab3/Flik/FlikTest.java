import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void sameNumberTest() {
        int a1 = 128; int b1 = 128;
        int a2 = 127; int b2 = 127;
        int a3 = 129; int b3 = 129;
        assertTrue(Flik.isSameNumber(a1, b1));
        assertTrue(Flik.isSameNumber(a2, b2));
        assertTrue(Flik.isSameNumber(a3, b3));
    }

}
