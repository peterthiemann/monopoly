package monopoly;

public enum State {
	UNOWNED(0, 0, 0),
	MORTGAGED(0, 0, 0),
	OWNED(1, 0, 0),
	ONEHOUSE(2, 1, 0),
	TWOHOUSES(3, 2, 0),
	THREEHOUSES(4, 3, 0),
	FOURHOUSES(5, 4, 0),
	HOTEL(6, 0, 1); 
	
	private final int rentIndex;
	private final int numberOfHouses;
	private final int numberOfHotels;
	
	private State (int rentIndex, int numberOfHouses, int numberOfHotels) {
		this.rentIndex = rentIndex;
		this.numberOfHouses = numberOfHouses;
		this.numberOfHotels = numberOfHotels;
	}
	public int getRentIndex() {
		return rentIndex;
	}
	public int numberOfHouses() {
		return numberOfHouses;
	}
	
	public int numberOfHotels() {
		return numberOfHotels;
	}
}
