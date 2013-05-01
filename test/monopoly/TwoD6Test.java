package monopoly;

import        org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests class TwoD6.
 */
public class TwoD6Test {

  /**
   * Checks if roll() is always greater than or equal to 1. This test is
   * (of course) non-deterministic.
   */
  @Test
  public void testRoll1() {
    TwoD6 d = new TwoD6();
    for(int i = 0; i < 10000; i++)  {
      d.roll();
      int result = d.getValue();
      assertTrue("Rolled value less than 1: " + result, result >= 1);
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

}
