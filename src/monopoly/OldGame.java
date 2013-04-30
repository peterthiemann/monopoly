/**
 * 
 */
package monopoly;

/**
 * @author thiemann
 *
 */
public class OldGame {
	
	private static final int NR_OF_FIELDS = 40;
	private static final int NR_OF_CHANCE_CARDS = 16;
	private static final int NR_OF_COMMUNITY_CHEST_CARDS = 16;

	private static final String[] CHANCE_CARDS = {
	"Advance to Go (Collect $200)",
	"Advance to Illinois Ave.", 
	"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", 
	"Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)", 
	"Advance to St. Charles Place Ð if you pass Go, collect $200", 
	"Bank pays you dividend of $50", 
	"Get out of Jail free Ð this card may be kept until needed, or traded/sold", 
	"Go back 3 spaces", 
	"Go directly to Jail Ð do not pass Go, do not collect $200", 
	"Make general repairs on all your property Ð for each house pay $25 Ð for each hotel $100", 
	"Pay poor tax of $15", 
	"Take a trip to Reading Railroad Ð if you pass Go collect $200", 
	"Take a walk on the Boardwalk Ð advance token to Boardwalk", 
	"You have been elected chairman of the board Ð pay each player $50", 
	"Your building loan matures Ð collect $150", 
	"You have won a crossword competition - collect $100"
	};


	private void initBoard(IField[] b) {
		/*
		b[00] = new GoField();
		b[01] = Street.makeMediterranian();
		b[02] = new CommunityChestField();
		b[03] = Street.makeBaltic();
		b[04] = new IncomeTaxField();
		b[05] = Railroad.makeReading();
		b[06] = Street.makeOriental();
		b[07] = ChanceField.getInstance();
		b[08] = Street.makeVermont();
		b[09] = Street.makeConnecticut();
		b[10] = new JailField();
		b[11] = Street.makeStCharles();
		b[12] = Utility.makeElectric();
		b[13] = Street.makeStates();
		b[14] = Street.makeVirginia();
		b[15] = Railroad.makePennsylvania();
		b[16] = Street.makeStJames();
		b[17] = new CommunityChestField();
		b[18] = Street.makeTennessee();
		b[19] = Street.makeNewYork();
		b[20] = new FreeParkingField();
		b[21] = Street.makeKentucky();
		b[22] = new ChanceField();
		b[23] = Street.makeIndiana();
		b[24] = Street.makeIllinois();
		b[25] = Railroad.makeBO();
		b[26] = Street.makeAtlantic();
		b[27] = Street.makeVentnor();
		b[28] = Utility.makeWater();
		b[29] = Street.makeMarvin();
		b[30] = new GotoJailField();
		b[31] = Street.makePacific();
		b[32] = Street.makeNorthCarolina();
		b[33] = new CommunityChestField();
		b[34] = Street.makePennsylvania();
		b[35] = Railroad.makeShortLine();
		b[36] = new ChanceField();
		b[37] = Street.makePark();
		b[38] = new LuxuryTaxField();
		b[39] = Street.makeBoardwalk();
		*/
	}

}
