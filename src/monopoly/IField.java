package monopoly;


public interface IField {
	/**
	 * determine action to be taken by player arriving on field
	 * @param game TODO
	 * @return the IAction that has to be taken or null if no action necessary
	 */
	public IAction action(Game game);
}
