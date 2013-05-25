package monopoly;

public class NoAction implements IAction {
	
	private NoAction() {}
	
	private static NoAction theInstance = new NoAction();
	
	public static NoAction getInstance() {
		return theInstance;
	}

	@Override
	public String getDescription() {
		return "no action";
	}

	@Override
	public boolean execute() {
		return true;
	}

}
