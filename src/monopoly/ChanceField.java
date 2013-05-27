package monopoly;

import java.util.Collection;

import monopoly.actioncard.AdvanceTo;

public class ChanceField extends AActionCardField {
	
	private ChanceField(IActionCard[] cards) {
		super("Chance", cards);
	}
	private static ChanceField instance;
	public static ChanceField getInstance() {
		if (instance == null) {
			instance = init();
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


	private static ChanceField init() {
		IActionCard[] cards = new IActionCard[Constants.NR_CHANCE_CARDS];
		
		cards[ 0] = new AdvanceTo("Advance to Go (Collect $200)", Constants.START_POSITION);
		cards[ 1] = new AdvanceTo("Advance to Illinois Ave.", Constants.ILLINOIS_POSITION);
		
		cards[ 2] = new AActionCard("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.") {

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
		cards[ 4] = new AdvanceTo("Advance to St. Charles Place - if you pass Go, collect $200", Constants.ST_CHARLES_POSITION);
		// shuffle cards
		return new ChanceField(cards);
	}
}
