/**
 * 
 */
package monopoly;

/**
 * @author thiemann
 *
 */
public class BuyAction implements IAction {
	private final String description;
	private final Player buyer;
	private final Street street;

	public BuyAction(String description, Player current, Street street) {
		this.description = description;
		this.buyer = current;
		this.street = street;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean execute() {
		return street.buy(buyer);
	}

	@Override
	public boolean alternative() {
		// rejection to buy leads to an auction in the real game
		return true;
	}

	@Override
	public boolean isImmediate() {
		return false;
	}
}
