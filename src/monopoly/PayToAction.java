package monopoly;

public class PayToAction extends AAction {
	private final Player current;
	private final Player target;
	private final int amount;

	public PayToAction(String description, Player current, Player target,
			int amount) {
		super(description, false);
		this.current = current;
		this.target = target;
		this.amount = amount;
	}

	public boolean execute() {
		if (current.pay(amount)) {
			target.earn(amount);
			return true;
		}
		return false;
	}
}
