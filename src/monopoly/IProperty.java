package monopoly;

public interface IProperty extends ReadProperty {
	
	public int askRent(ReadDice dice);
	
	public boolean obtainMortgage();
	
	public boolean releaseMortgage();


	public int numberOfHouses();

	public int numberOfHotels();

}
