package monopoly;

public class Railroad extends AProperty {

	public static AProperty makePennsylvania() {
		return new Railroad("Pennsylvania Railroad");
	}

	public static AProperty makeReading() {
		return new Railroad("Reading Railroad");
	}

	public static AProperty makeBO() {
		return new Railroad("B&O Railroad");
	}
	
	public static AProperty makeShortLine() {
		return new Railroad("Shortline Railroad");
	}
	
	protected Railroad(String name) {
		super(name, Constants.RAILROAD_PRICE);
	}

	@Override
	public boolean isMortgaged() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateRent(ReadDice dice) {
		int result = 0;
		if (this.isOwned()) {
			result = Constants.RAILROAD_BASE_RENT;
			for (int i = 1; i < getOwner().countRailroads(); i++) {
				result *= 2;
			}
		}
		return result;
	}

	@Override
	public boolean isRailroad() {
		return true;
	}

}
