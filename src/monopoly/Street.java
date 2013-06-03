/**
 * 
 */
package monopoly;


/**
 * @author thiemann
 *
 */
public class Street extends AProperty {
	private final int[] rent;
	private final Group colorGroup;
	
	private State state;
	
	public int[] getRent() {
		return rent.clone();		// do not return the plain array!
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
	public boolean isMortgaged() {
		return this.state == State.MORTGAGED;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	private Street(String name, int price, int[] rent, Group colorGroup) {
		super(name, price);
		this.rent = rent;
		this.colorGroup = colorGroup;
		
		this.state = State.UNOWNED;
	}
	
	public static Street makeMediterranian() {
		return new Street("Mediterranian Avenue", 60, new int[] {0, 2, 10, 30, 90, 160, 250}, Group.SADDLEBROWN);
	}
	
	public static Street makeBaltic() {
		return new Street("Baltic Avenue", 60, new int[] {0, 4, 20, 60, 180, 320, 450},	Group.SADDLEBROWN);
	}
	
	public static AProperty makeOriental() {
		return new Street("Oriental Avenue", 100, new int [] {0, 6, 30, 90, 270, 400, 550}, Group.SKYBLUE);
	}
	
	public static AProperty makeVermont() {
		return new Street("Vermont Avenue", 100, new int[] {0, 6, 30, 90, 270, 400, 550}, Group.SKYBLUE);
	}
	
	public static AProperty makeConnecticut() {
		return new Street("Connecticut Avenue", 120, new int[] {0, 8, 40, 100, 300, 450, 600}, Group.SKYBLUE);
	}
	
	public static AProperty makeStCharles() {
		return new Street("St. Charles Place", 140, new int[] {0, 10, 50, 150, 450, 625, 750}, Group.DARKORCHID);
	}
	
	public static AProperty makeStates() {
		return new Street("States Avenue", 140, new int[] {0, 10, 50, 150, 450, 625, 750}, Group.DARKORCHID);
	}
	
	public static AProperty makeVirginia() {
		return new Street("Virginia Avenue", 160, new int[] {0, 12, 60, 180, 500, 700, 900}, Group.DARKORCHID);
	}

	public static AProperty makeStJames() {
		return new Street("St. James Place", 180, new int[] {0, 14, 70, 200, 550, 750, 950}, Group.ORANGE);
	}

	public static AProperty makeTennessee() {
		return new Street("Tennessee Avenue", 180, new int[] {0, 14, 70, 200, 550, 750, 950}, Group.ORANGE);
	}

	public static AProperty makeNewYork() {
		return new Street("New York Avenue", 200, new int[] {0, 16, 80, 220, 600, 800, 1000}, Group.ORANGE);
	}

	public static AProperty makeKentucky() {
		return new Street("Kentucky Avenue", 220, new int[] {0, 18, 90, 250, 700, 875, 1050}, Group.RED);
	}

	public static AProperty makeIndiana() {
		return new Street("Indiana Avenue", 220, new int[] {0, 18, 90, 250, 700, 875, 1050}, Group.RED);
	}

	public static AProperty makeIllinois() {
		return new Street("Illinois Avenue", 240, new int[] {0, 20, 100, 300, 750, 925, 1100}, Group.RED);
	}

	public static AProperty makeAtlantic() {
		return new Street("Atlantic Avenue", 260, new int[] {0, 22, 110, 330, 800, 975, 1150}, Group.YELLOW);
	}

	public static AProperty makeVentnor() {
		return new Street("Ventnor Avenue", 260, new int[] {0, 22, 110, 330, 800, 975, 1150}, Group.YELLOW);
	}

	public static AProperty makeMarvin() {
		return new Street("Marvin Gardens", 280, new int[] {0, 24, 120, 360, 860, 1025, 1200}, Group.YELLOW);
	}

	public static AProperty makePacific() {
		return new Street("Pacific Avenue", 300, new int[] {0, 26, 130, 390, 900, 1100, 1275}, Group.GREEN);
	}

	public static AProperty makeNorthCarolina() {
		return new Street("North Carolina Avenue", 300, new int[] {0, 26, 130, 390, 900, 1100, 1275}, Group.GREEN);
	}

	public static AProperty makePennsylvania() {
		return new Street("Pennsylvania Avenue", 320, new int[] {0, 28, 150, 450, 1000, 1200, 1400}, Group.GREEN);
	}
	
	public static AProperty makeParkPlace() {
		return new Street("Park Place", 350, new int[] {0, 35, 175, 500, 1100, 1300, 1500}, Group.BLUE);
	}
	
	public static AProperty makeBoardWalk() {
		return new Street("Board Walk", 400, new int[] {0, 50, 200, 600, 1400, 1700, 2000}, Group.BLUE);
	}
	
	public String toString() {
		return this.getName() + " " + this.colorGroup;
	}

	/**
	 * Try to mortgage this property.
	 * @return true if mortgage has been obtained on this street
	 */
	public boolean obtainMortgage() {
		if (this.state == State.OWNED) {
			this.getOwner().earn(this.getMortgageValue());
			this.state = State.MORTGAGED;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean releaseMortgage() {
		if (this.state == State.MORTGAGED && this.getOwner().pay(this.getMortgageReleaseAmount())) {
			this.state = State.OWNED;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Buy a house or a hotel for this street.
	 * Still lacks the check that houses must be build evenly.
	 * @return true if buying the house or hotel was successful.
	 */
	public boolean buyHouse() {
		if (this.state == State.UNOWNED || this.state == State.HOTEL) {
			return false;
		} else if (!this.getOwner().ownsAllInGroup(this.colorGroup) || this.getOwner().anyMortgaged(this.colorGroup)) {
			return false;
		} else {
			int i = this.state.ordinal();
			this.state = State.values()[i+1];
			return true;
		}
	}

	@Override
	public boolean inColorGroup(Group colorGroup) {
		return this.getColorGroup() == colorGroup;
	}

	@Override
	protected void setOwnedState(Player p) {
		if(this.state == State.UNOWNED) {
			this.state = State.OWNED;
			super.setOwnedState(p);
		}				
	}
	
	/**
	 * Calculate the rent that the owner can charge for this street.
	 * @return the amount of rent.
	 */
	@Override
	public int calculateRent(ReadDice dice) {
		int amount = rent[this.state.getRentIndex()];
		if (this.state == State.OWNED && getOwner().ownsAllInGroup(this.colorGroup)) {
			amount *= 2;
		}
		return amount;
	}
	
	public int numberOfHouses() {
		return this.state.numberOfHouses();
	}
	
	public int numberOfHotels() {
		return this.state.numberOfHotels();
	}
}
