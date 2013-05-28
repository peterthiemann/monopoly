package monopoly;

public interface IProperty {
	
	public int askRent(ReadDice dice);
	
	// public int calculateRent(ReadDice dice);
	
	public boolean obtainMortgage();
	
	public boolean releaseMortgage();

	public boolean inColorGroup(Group colorGroup);

	public boolean isMortgaged();
	
	public boolean isRailroad();

	public boolean isUtility();

}
