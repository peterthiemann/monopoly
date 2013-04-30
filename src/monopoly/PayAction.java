package monopoly;

public class PayAction implements IAction {
	public final Player current;
	public final int amount;
	public PayAction(Player current, int amount) {
		this.current = current; this.amount = amount;
	}
}
