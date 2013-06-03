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
	 * 
	 * @return true if execute() must run successfully before finishing turn
	 */
	public boolean isRequired();
	/**
	 * 
	 * @return 0 if no movement; otherwise difference to target, positive differences may pass GO, negative ones do not
	 */
	public int movement();
	public boolean isGetOutOfJail();
}
