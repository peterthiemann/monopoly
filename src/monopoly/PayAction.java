package monopoly;

public class PayAction extends AAction {
	private final Player current;
	private final int amount;
	public PayAction(String description, Player current, int amount) {
		super(description, false);
		this.current = current; this.amount = amount;
	}
	@Override
	public boolean execute() {
		return current.pay(amount);
	}
}
