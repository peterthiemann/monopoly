package monopoly;

public class PayAction implements IAction {
	private final String description;
	private final Player current;
	private final int amount;
	public PayAction(String description, Player current, int amount) {
		this.description = description; this.current = current; this.amount = amount;
	}
	@Override
	public String getDescription() {
		return this.description;
	}
	@Override
	public boolean execute() {
		return current.pay(amount);
	}
}
