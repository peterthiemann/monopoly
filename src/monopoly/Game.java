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
	
	public IField getField(int position) {
		return board[position];
	}
	
	private static IField[] initBoard() {
		IField[] b = new IField[Constants.BOARD_SIZE];
		b[ 0] = new GoField(); // GO!
		b[ 1] = Street.makeMediterranian();
		//b[ 2] = CommunityChestField.getInstance();
		b[ 3] = Street.makeBaltic();
		b[ 4] = new IncomeTaxField();
		b[ 5] = Railroad.makeReading();
		b[ 6] = Street.makeOriental();
		//b[ 7] = ChanceField.getInstance();
		b[ 8] = Street.makeVermont();
		b[ 9] = Street.makeConnecticut();
		b[10] = new JailField();
		b[11] = Street.makeStCharles();
		b[12] = Utility.makeElectric();
		b[13] = Street.makeStates();
		b[14] = Street.makeVirginia();
		b[15] = Railroad.makePennsylvania();
		b[16] = Street.makeStJames();
		//b[17] = CommunityChestField.getInstance();
		b[18] = Street.makeTennessee();
		b[19] = Street.makeNewYork();
		b[20] =	new FreeParkingField();
		b[21] = Street.makeKentucky();
		//b[22] = ChanceField.getInstance();
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
		//b[33] = CommunityChestField.getInstance();
		b[34] = Street.makePennsylvania();
		b[35] = Railroad.makeShortLine();
		//b[36] = ChanceField.getInstance();
		b[37] = Street.makeParkPlace();
		b[38] = new LuxuryTaxField();
		b[39] = Street.makeBoardWalk();
		return b;
	}
	
	public void turn(IDialog dialog) {
		// get next player
		current = players.poll();
		dialog.message("Your turn, " + current.getName() + "!");

		dice.roll();
		dialog.message("You rolled " + dice.getValue() + "." + (dice.isDoubles() ? " Doubles!" : ""));
		// missing: must check if in jail
		// missing: count doubles, repeat on double
		IAction action = advance(dialog, dice.getValue());
		boolean doit, done = false;
		do {
			dialog.message("Do you want to do: " + action.getDescription());
			doit = dialog.askYesOrNo();
			if (doit) {
				done = action.execute();
				dialog.message(done ? "Success" : "Failed");
			} else {
				done = !action.isRequired();
			}
		} while (!done);
		// back to end of line
		players.add(current);
	}

	private IAction advance(IDialog dialog, int amount) {
		int position = current.getPosition();
		position += amount;
		if (position >= Constants.BOARD_SIZE) {
			// passing GO
			position %= Constants.BOARD_SIZE;
			current.earn(Constants.GO_CASH);
			dialog.message("Passing GO, earning $" + Constants.GO_CASH);
		}
		current.setPosition(position);
		
		IField field = this.getField(current.getPosition());
		IAction action = field.action(current, players, dice);
		dialog.message("Arriving on " + field.getName());
		int new_amount = action.movement();
		if (new_amount != 0) {
			dialog.message("Executing: " + action.getDescription());
			action.execute();
			return advance(dialog, new_amount);
		} else {
			return action;
		}

	}

}
