package monopoly;

public enum State {
	UNOWNED(0), MORTGAGED(0), OWNED(0),
	ONEHOUSE(1), TWOHOUSES(2), THREEHOUSES(3), FOURHOUSES(4), HOTEL(5); 
	
	private final int rentIndex;
	private State (int rentIndex) {
		this.rentIndex = rentIndex;
	}
	public int getRentIndex() {
		return rentIndex;
	}
}
