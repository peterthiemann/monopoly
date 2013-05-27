package monopoly.actioncard;

import java.util.Collection;

import monopoly.AAction;
import monopoly.AActionCard;
import monopoly.Constants;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.Player;

public final class AdvanceTo extends AActionCard {
	private final int targetPosition;
	public AdvanceTo(String description, int targetPosition) {
		super(description);
		this.targetPosition = targetPosition;
	}

	@Override
	public IAction action(final Player current, Collection<Player> others,
			IDice dice) {
		final int targetPosition = this.targetPosition;
		return new AAction(this.description, true) {

			@Override
			public boolean execute() {
				return true;
			}
			
			public int movement() {
				return targetPosition - current.getPosition() + Constants.BOARD_SIZE;
			}
			
		};
	}
}