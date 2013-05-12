/**
 * 
 */
package monopoly;

/**
 * @author thiemann
 *
 */
public class BuyAction extends AAction {
	private final Player buyer;
	private final Street street;

	public BuyAction(String description, Player current, Street street) {
		super(description);
		this.buyer = current;
		this.street = street;
	}

	@Override
	public boolean execute() {
		return street.buy(buyer);
	}
}
