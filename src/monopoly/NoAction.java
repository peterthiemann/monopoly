package monopoly;

public class NoAction extends AAction {
	
	private NoAction() {
		super("no action", false);
	}
	
	private static NoAction theInstance = new NoAction();
	
	public static NoAction getInstance() {
		return theInstance;
	}

	@Override
	public boolean execute() {
		return true;
	}
	
	public boolean isRequired() {
		return true;
	}

}
