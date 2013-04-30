package monopoly;

public interface IAction {
	/**
	 * 
	 * @return textual description of the action for menu
	 */
	public String getDescription();
	/**
	 * perform the action
	 * @return true if execution was successful
	 */
	public boolean execute();
}
