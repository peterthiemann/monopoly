package monopoly;

import java.util.Collection;

import monopoly.actioncard.AdvanceTo;
import monopoly.actioncard.EarnMoney;
import monopoly.actioncard.GetOutOfJailFree;
import monopoly.actioncard.PayMoney;
import monopoly.actioncard.PayToEachPlayer;

public class ChanceField extends AActionCardField {
	
	private ChanceField() {
		super("Chance");
	}
	private static ChanceField instance;
	public static ChanceField getInstance() {
		if (instance == null) {
			instance = new ChanceField();
			IActionCard[] cards = init(instance);
			instance.initCards(cards);
		}
		return instance;
	}
	private static final String[] CHANCE_CARDS = {
	"Advance to Go (Collect $200)",
	"Advance to Illinois Ave.", 
	"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", 
	"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)", 
	"Advance to St. Charles Place - if you pass Go, collect $200", 
	"Bank pays you dividend of $50", 
	"Get out of Jail free - this card may be kept until needed, or traded/sold", 
	"Go back 3 spaces", 
	"Go directly to Jail - do not pass Go, do not collect $200", 
	"Make general repairs on all your property - for each house pay $25 - for each hotel $100", 
	"Pay poor tax of $15", 
	"Take a trip to Reading Railroad - if you pass Go collect $200", 
	"Take a walk on the Boardwalk - advance token to Boardwalk", 
	"You have been elected chairman of the board - pay each player $50", 
	"Your building loan matures - collect $150", 
	"You have won a crossword competition - collect $100"
	};


	private static IActionCard[] init(ChanceField instance) {
		IActionCard[] cards = new IActionCard[Constants.NR_CHANCE_CARDS];
		
		cards[ 0] = new AdvanceTo("Advance to Go (Collect $200)", Constants.START_POSITION);
		cards[ 1] = new AdvanceTo("Advance to Illinois Ave.", Constants.ILLINOIS_POSITION);
		cards[ 2] = new AActionCard("Advance token to nearest Utility. If unowned, you may buy it from the Bank." +
				" If owned, throw dice and pay owner a total ten times the amount thrown.") {

					@Override
					public IAction action(final Player current,
							Collection<Player> others, IDice dice) {
						return new AAction(this.description, true) {

							@Override
							public boolean execute() {
								// TODO need to install a rent adjustment
								return true;
							}
							
							public int movement() {
								int dist_water = Constants.WATER_POSITION - current.getPosition();
								int dist_electric = Constants.ELECTRIC_POSITION - current.getPosition();
								if (dist_water < 0) {
									dist_water += Constants.BOARD_SIZE;
								}
								if (dist_electric < 0) {
									dist_electric += Constants.BOARD_SIZE;
								}
								int min_dist = Math.min(dist_electric, dist_water);
								return min_dist;
							}
							
						};
					}
			
		};
		cards[ 3] = new AActionCard("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. " +
				"If Railroad is unowned, you may buy it from the Bank. (There are two of these.)") {

					@Override
					public IAction action(final Player current,
							Collection<Player> others, IDice dice) {
						// TODO Auto-generated method stub
						return new AAction(this.description, true) {

							@Override
							public boolean execute() {
								// TODO need to install rent adjustment
								return true;
							}
							
							public int movement() {
								int position[] = new int[] {
										Constants.READING_POSITION, 
										Constants.PENNSYLVANIA_POSITION,
										Constants.BO_POSITION,
										Constants.SHORTLINE_POSITION};
								int minimumDistance = Constants.BOARD_SIZE;
								for (int i = 0; i < position.length; i++) {
									int distance = position[i] - current.getPosition();
									if (distance < 0) distance += Constants.BOARD_SIZE;
									if (distance < minimumDistance) minimumDistance = distance;
								}
								return minimumDistance;
							}
							
						};
					}
			
		};
		cards[ 4] = new AdvanceTo("Advance to St. Charles Place - if you pass Go, collect $200", Constants.ST_CHARLES_POSITION);
		cards[ 5] = new EarnMoney("Bank pays you dividend of $50", 50);
		cards[ 6] = new GetOutOfJailFree("Get out of Jail free - this card may be kept until needed, or traded/sold", instance);
		cards[ 7] = new AActionCard("Go back 3 spaces") {

			@Override
			public IAction action(Player current, Collection<Player> others,
					IDice dice) {
				return new AAction(this.description, true) {

					@Override
					public boolean execute() {
						return true;
					}
					
					public int movement() {
						return -3;
					}
				};
			}
		};
		cards[ 8] = new AActionCard("Go directly to Jail - do not pass Go, do not collect $200") {

			@Override
			public IAction action(final Player current, Collection<Player> others,
					IDice dice) {
				return new AAction(this.description, true) {

					@Override
					public boolean execute() {
						current.gotoJail();
						return true;
					}
					
					public int movement() {
						return Constants.JAIL_POSITION - current.getPosition();
					}
					
				};
			}
			
		};
		cards[ 9] = new AActionCard("Make general repairs on all your property - for each house pay $25 - for each hotel $100") {

			@Override
			public IAction action(Player current, Collection<Player> others, IDice dice) {
				int amount = 25 * current.numberOfHouses() + 100 * current.numberOfHotels();
				return new PayAction(this.description, current, amount);
			}
			
		}; 
		cards[10] = new PayMoney("Pay poor tax of $15", 15); 
		cards[11] = new AdvanceTo("Take a trip to Reading Railroad - if you pass Go collect $200", Constants.READING_POSITION); 
		cards[12] = new AdvanceTo("Take a walk on the Boardwalk - advance token to Boardwalk", Constants.BOARDWALK_POSITION); 
		cards[13] = new PayToEachPlayer("You have been elected chairman of the board - pay each player $50", 50); 
		cards[14] = new EarnMoney("Your building loan matures - collect $150", 150);
		cards[15] = new EarnMoney("You have won a crossword competition - collect $100", 100);
		cards[16] = cards[ 3];
		// shuffle cards
		return cards;
	}
}
