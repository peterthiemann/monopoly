package monopoly;

import        org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests class TwoD6.
 */
public class TwoD6Test {

  /**
   * Checks if roll() is always greater than or equal to 2. This test is
   * (of course) non-deterministic.
   */
  @Test
  public void testRoll1() {
    TwoD6 d = new TwoD6();
    for(int i = 0; i < 10000; i++)  {
      d.roll();
      int result = d.getValue();
      assertTrue("Rolled value less than 2: " + result, result >= 2);
    }
  }

  /**
   * Checks if roll() is always less than or equal to 12. This test is
   * (of course) non-deterministic.
   */
  @Test
  public void testRoll2() {
    TwoD6 d = new TwoD6();
    for(int i = 0; i < 10000; i++)  {
      d.roll();
      int result = d.getValue();
      assertTrue("Rolled value greater than 12: " + result, result <= 12);
    }
  }

  @Test
  public void testIsDoubles() {
    TwoD6 d = new TwoD6();
    for(int i = 0; i < 10000; i++) {
      d.roll();
      if(d.isDoubles())
        assertTrue("isDoubles() is true, but dice values must be different",
            d.getValue() % 2 == 0);
    }
  }

}
