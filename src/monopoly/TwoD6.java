package monopoly;

/**
 * Simulation of two 6-sided dice.
 */
public class TwoD6 implements IDice {

  private int result1 = 0;
  private int result2 = 0;

  /**
   * Rolls both dice, generating a random number between 1 and 6 for each of
   * them.
   */
  public void roll() {
    result1 = (int)(Math.random() * 6) + 1;
    result2 = (int)(Math.random() * 6) + 1;
  }

  /**
   * Sum of the two dice's values from the last roll.
   *
   * @return Total amount rolled. Zero if the dice have not been rolled yet.
   */
  public int getValue() {
    return result1 + result2;
  }

  /**
   * Checks if the last roll was a double.
   *
   * @return true if the last roll was a double, false if it wasn't or if the
   *   dice haven't been rolled yet.
   */
  public boolean isDoubles() {
    return result1 == result2 && result1 + result2 != 0;
  }
}
