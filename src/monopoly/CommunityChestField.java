package monopoly;

import java.util.Collection;

import monopoly.actioncard.AdvanceTo;
import monopoly.actioncard.EarnFromEachPlayer;
import monopoly.actioncard.EarnMoney;
import monopoly.actioncard.GetOutOfJailFree;
import monopoly.actioncard.PayMoney;

public class CommunityChestField extends AActionCardField {

	private CommunityChestField() {
		super("Community Chest");
	}
	private static CommunityChestField instance;
	public static CommunityChestField getInstance() {
		if (instance == null) {
			instance = new CommunityChestField();
			IActionCard[] cards = init(instance);
			instance.initCards(cards);
		}
		return instance;
	}
	private static final String [] COMMUNITY_CHEST_CARDS = {
		"Advance to Go (Collect $200)",
		"Bank error in your favor – collect $75",
		"Doctor's fees – Pay $50",
		"Get out of jail free – this card may be kept until needed, or sold",
		"Go to jail – go directly to jail – Do not pass Go, do not collect $200",
		"It is your birthday Collect $10 from each player",
		"Grand Opera Night – collect $50 from every player for opening night seats",
		"Income Tax refund – collect $20",
		"Life Insurance Matures – collect $100",
		"Pay Hospital Fees of $100",
		"Pay School Fees of $50",
		"Receive $25 Consultancy Fee",
		"You are assessed for street repairs – $40 per house, $115 per hotel",
		"You have won second prize in a beauty contest– collect $10",
		"You inherit $100",
		"From sale of stock you get $50",
		"Holiday Fund matures - Receive $100"
	};
	private static IActionCard[] init(CommunityChestField field) {
		IActionCard[] cards = new IActionCard[Constants.NR_COMMUNITY_CHEST_CARDS];
		// TODO create cards
		cards[ 0] = new AdvanceTo("Advance to Go (Collect $200)", Constants.START_POSITION);
		cards[ 1] = new EarnMoney("Bank error in your favor - collect $75", 75);
		cards[ 2] = new PayMoney("Doctor's fees - Pay $50", 50);
		cards[ 3] = new GetOutOfJailFree("Get out of jail free - this card may be kept until needed, or sold", field);
		cards[ 4] = new AActionCard("Go to jail - go directly to jail - Do not pass Go, do not collect $200") {

			@Override
			public IAction action(final Player current, Collection<Player> others, IDice dice) {
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
		cards[ 5] = new EarnFromEachPlayer("It is your birthday - collect $10 from each player", 10);
		cards[ 6] = new EarnFromEachPlayer("Grand Opera Night - collect $50 from every player for opening night seats", 50);
		cards[ 7] = new EarnMoney("Income Tax refund - collect $20", 20);
		cards[ 8] = new EarnMoney("Life Insurance Matures - collect $100", 100);
		cards[ 9] = new PayMoney("Pay Hospital Fees of $100", 100);
		cards[10] = new PayMoney("Pay School Fees of $50", 50);
		cards[11] = new EarnMoney("Receive $25 Consultancy Fee", 25);
		cards[12] = new AActionCard("You are assessed for street repairs - $40 per house, $115 per hotel") {

			@Override
			public IAction action(Player current, Collection<Player> others, IDice dice) {
				int amount = 40 * current.numberOfHouses() + 115 * current.numberOfHotels();
				return new PayAction(this.description, current, amount);
			}
			
		};
		cards[13] = new EarnMoney("You have won second prize in a beauty contest - collect $10", 10);
		cards[14] = new EarnMoney("You inherit $100", 100);
		cards[15] = new EarnMoney("From sale of stock you get $50", 50);
		cards[16] = new EarnMoney("Holiday Fund matures - Receive $100", 100);
		// TODO shuffle cards
		return cards;
	}

}
