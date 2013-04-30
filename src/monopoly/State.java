package monopoly;

public enum State {
	UNOWNED(0), MORTGAGED(0), OWNED(1),
	ONEHOUSE(2), TWOHOUSES(3), THREEHOUSES(4), FOURHOUSES(5), HOTEL(6); 
	
	private final int rentIndex;
	private State (int rentIndex) {
		this.rentIndex = rentIndex;
	}
	public int getRentIndex() {
		return rentIndex;
	}
}
