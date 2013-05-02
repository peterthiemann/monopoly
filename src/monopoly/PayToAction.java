package monopoly;

public class PayToAction implements IAction {
	private final String description;
	private final Player current;
	private final Player target;
	private final int amount;
	
	public PayToAction(String description, Player current, Player target, int amount) {
		this.description = description; this.current = current; this.target = target; this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean execute() {
		if (current.pay(amount)) {
			target.earn(amount);
			return true;
		}
		return false;
	}

	@Override
	public boolean alternative() {
		return false;
	}

	@Override
	public boolean isImmediate() {
		return false;
	}
}
