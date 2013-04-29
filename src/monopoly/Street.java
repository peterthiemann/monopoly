/**
 * 
 */
package monopoly;

/**
 * @author thiemann
 *
 */
public class Street {
	private final String name;
	private final int price;
	private final int[] rent;
	private final int mortgageValue;
	private final int houseCost;
	private final Group colorGroup;
	
	private boolean mortgage;
	private State state;

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int[] getRent() {
		return rent.clone();		// do not return the plain array!
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public int getHouseCost() {
		return houseCost;
	}

	public Group getColorGroup() {
		return colorGroup;
	}

	/**
	 * @return the mortgage
	 */
	public boolean getMortgage() {
		return mortgage;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	private Street(String name, int price, int[] rent, 
			int mortgageValue, int houseCost,
			Group colorGroup) {
		this.name = name; this.price = price; this.rent = rent;
		this.mortgageValue = mortgageValue; this.houseCost = houseCost;
		this.colorGroup = colorGroup;
		
		this.mortgage = false;
		this.state = State.UNOWNED;
	}
	
	public static Street makeBaltic() {
		return new Street("Baltic Avenue", 60, new int[] {0, 4, 20, 60, 180, 320, 450},
				30, 50, Group.SADDLEBROWN);
	}
	
	public String toString() {
		return this.name + " " + this.colorGroup;
	}

	/**
	 * Buy this street.
	 * @return true if buying the street was successful.
	 */
	public boolean buy() {
		if (State.UNOWNED.equals(this.state)) {
			this.state = State.OWNED;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Buy a house or a hotel for this street.
	 * @return true if buying the house or hotel was successful.
	 */
	public boolean buyHouse() {
		if (this.state == State.UNOWNED || this.state == State.HOTEL) {
			return false;
		} else {
			int i = this.state.ordinal();
			this.state = State.values()[i+1];
			return true;
		}
	}

	/**
	 * Calculate the rent that the owner can charge for this street.
	 * @return the amount of rent.
	 */
	public int calculateRent() {
		if (this.mortgage) {
			return 0;
		} else {
			return rent[this.state.ordinal()];
		}
	}
}
