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
	/**
	 * perform an alternative action
	 * @return true if alternative existed and was successful
	 */
	public boolean alternative();
	/**
	 * indicates actions that must be executed without (before) player interaction
	 * @return true if action has been executed automatically
	 */
	public boolean isImmediate();
}
