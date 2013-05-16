/**
 * 
 */
package monopoly;

import java.util.List;
import java.util.Queue;

/**
 * @author adpult
 *
 */
public class Game {
	private Queue<Player> players;
	private Player current; // not contained in players
	private IField[] board;
	private IDice dice;
	
	private Queue<IActionCard> chanceCards;
	private Queue<IActionCard> communityChestCards;
	
	private static IField[] initBoard() {
		IField[] b = new IField[Constants.BOARD_SIZE];
		// b[ 0] = new GoField(); // GO!
		b[ 1] = Street.makeMediterranian();
		//b[ 2] = CommunityChestField.getInstance();
		b[ 3] = Street.makeBaltic();
		//b[ 4] = new IncomeTaxField();
		b[ 5] = Railroad.makeReading();
		b[ 6] = Street.makeOriental();
		//b[ 7] = ChanceField.getInstance();
		b[ 8] = Street.makeVermont();
		b[ 9] = Street.makeConnecticut();
		//b[10] = JailField.getInstance();
		b[11] = Street.makeStCharles();
		b[12] = Utility.makeElectric();
		b[13] = Street.makeStates();
		b[14] = Street.makeVirginia();
		b[15] = Railroad.makePennsylvania();
		b[16] = Street.makeStJames();
		//b[17] = CommunityChestField.getInstance();
		b[18] = Street.makeTennessee();
		b[19] = Street.makeNewYork();
		//b[20] =	FreeParkingField.getInstance();
		b[21] = Street.makeKentucky();
		//b[22] = ChanceField.getInstance();
		b[23] = Street.makeIndiana();
		b[24] = Street.makeIllinois();
		b[25] = Railroad.makeBO();
		b[26] = Street.makeAtlantic();
		b[27] = Street.makeVentnor();
		b[28] = Utility.makeWater();
		b[29] = Street.makeMarvin();
		//b[30] = GotoJailField.getInstance();
		b[31] = Street.makePacific();
		b[32] = Street.makeNorthCarolina();
		//b[33] = CommunityChestField.getInstance();
		b[34] = Street.makePennsylvania();
		b[35] = Railroad.makeShortLine();
		//b[36] = ChanceField.getInstance();
		b[37] = Street.makeParkPlace();
		//b[38] = LuxuryTaxField.getInstance();
		b[39] = Street.makeBoardWalk();
		return b;
	}

}
