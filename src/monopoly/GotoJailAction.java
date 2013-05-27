package monopoly;

public class GotoJailAction extends AAction {

	private Player current;

	protected GotoJailAction(String descr, Player current) {
		super(descr, false);
		this.current = current;
	}

	@Override
	public boolean execute() {
		this.current.gotoJail();
		return true;
	}
	
	public boolean isRequired() {
		return true;
	}
	
	public int movement() {
		return Constants.JAIL_POSITION - current.getPosition();
	}

}
