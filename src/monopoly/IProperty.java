package monopoly;

public interface IProperty {
	
	public int calculateRent(ReadDice dice);

	public boolean inColorGroup(Group colorGroup);

	public boolean isMortgaged();
	
	public boolean isRailroad();

	public boolean isUtility();

}
