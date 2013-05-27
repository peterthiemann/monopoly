package monopoly;

import monopoly.actioncard.AdvanceTo;

public class CommunityChestField extends AActionCardField {

	private CommunityChestField(IActionCard[] cards) {
		super("Community Chest", cards);
	}
	private static CommunityChestField instance;
	public static CommunityChestField getInstance() {
		if (instance == null) {
			instance = init();
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
	private static CommunityChestField init() {
		IActionCard[] cards = new IActionCard[Constants.NR_COMMUNITY_CHEST_CARDS];
		// TODO create cards
		cards[ 0] = new AdvanceTo("Advance to Go (Collect $200)", Constants.START_POSITION);
		// TODO shuffle cards
		return new CommunityChestField(cards);
	}

}
