package monopoly.mock;

import monopoly.IDice;

public class TwoD6Mock implements IDice {
	private int w1, w2;
	
	/**
	 * Create rolled pair of dice, projected into range 1-6
	 * @param w1 first dice, between 1-6
	 * @param w2 second dice, between 1-6
	 */
	public TwoD6Mock(int w1, int w2) {
		this.w1 = adjust(w1);
		this.w2 = adjust(w2);
	}

	private int adjust(int w0) {
		int w = w0 % 6;
		return (w <= 0) ? (w + 6) : w;
	}

	@Override
	public int getValue() {
		return this.w1 + this.w2;
	}

	@Override
	public boolean isDoubles() {
		return this.w1 == this.w2;
	}

	@Override
	public void roll() {
		// do nothing
		// a variation of the dice might prescribe a sequence of rolls
	}

}
