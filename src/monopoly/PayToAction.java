package monopoly;

public class PayToAction implements IAction {
	public final Player current;
	public final Player target;
	public final int amount;
	public PayToAction(Player current, Player target, int amount) {
		this.current = current; this.target = target; this.amount = amount;
	}
	
	public String getDescription() {
		return "Pay " + amount + " to " + target.getName();
	}
	
	public boolean execute() {
		if (current.pay(amount)) {
			target.earn(amount);
			return true;
		}
		return false;
	}
}
