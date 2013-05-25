package monopoly;

public class Railroad extends AProperty {

	public static Railroad makePennsylvania() {
		return new Railroad("Pennsylvania Railroad");
	}

	public static Railroad makeReading() {
		return new Railroad("Reading Railroad");
	}

	public static Railroad makeBO() {
		return new Railroad("B&O Railroad");
	}
	
	public static Railroad makeShortLine() {
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
			for (int i = 1; i < owner.countRailroads(); i++) {
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
