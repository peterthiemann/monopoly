/**
 * 
 */
package monopoly;


/**
 * @author thiemann
 *
 */
public class Street implements IProperty, IField {
	private final String name;
	private final int price;
	private final int[] rent;
	private final Group colorGroup;
	
	private State state;
	
	/**
	 * null as long as state == UNOWNED
	 * not null otherwise
	 */
	private Player owner;

	////////
	
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
		return price / 2;
	}

	public int getHouseCost() {
		return this.colorGroup.getHouseCost();
	}

	public Group getColorGroup() {
		return colorGroup;
	}

	/**
	 * @return the mortgage
	 */
	public boolean getMortgage() {
		return this.state == State.MORTGAGED;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	private Street(String name, int price, int[] rent, Group colorGroup) {
		this.name = name; this.price = price; this.rent = rent;
		this.colorGroup = colorGroup;
		
		this.state = State.UNOWNED;
	}
	
	public static Street makeBaltic() {
		return new Street("Baltic Avenue", 60, new int[] {0, 4, 20, 60, 180, 320, 450},
				Group.SADDLEBROWN);
	}
	
	public String toString() {
		return this.name + " " + this.colorGroup;
	}

	/**
	 * Buy this street.
	 * @return true if buying the street was successful.
	 */
	public boolean buy(Player p) {
		if (State.UNOWNED.equals(this.state) && p.pay(this.price)) {
			this.state = State.OWNED;
			this.owner = p;
			p.addProperty(this);
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
		int amount = rent[this.state.getRentIndex()];
		if (owner != null && owner.ownsAllInGroup(this.colorGroup)) {
			amount *= 2;
		}
		return amount;
	}

	@Override
	public boolean inColorGroup(Group colorGroup) {
		return this.getColorGroup() == colorGroup;
	}

	@Override
	public IAction action(Game game) {
		Player current = game.getCurrent();
		if (this.state == State.UNOWNED) {
			// offer to buy the street
			return new BuyAction("Buy " + this.name + " for $" + this.price , current, this);
		} else {
			// pay rent
			if (current == this.owner) {
				return null;
			} else {
				int amount = this.calculateRent();
				return new PayToAction("Pay $" + amount + " rent for " + this.name + " to " + owner.getName(),
						current, this.owner, amount);
			}
		}
	}
}
