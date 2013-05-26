package monopoly;

public interface IDialog {
	/**
	 * Display message
	 * @param msg
	 */
	public void message(String msg);
	/**
	 * 
	 * @return true if some equivalent to "yes" was entered
	 */
	public boolean askYesOrNo();
	/**
	 * Present choices from 1..nrChoices and return user's choice
	 * @param nrChoices
	 * @return
	 */
	public int choose(int nrChoices);
}
