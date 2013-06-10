package monopoly.actioncard;

import java.util.Collection;

import monopoly.AAction;
import monopoly.AActionCard;
import monopoly.AActionCardField;
import monopoly.ChanceField;
import monopoly.IAction;
import monopoly.IDice;
import monopoly.Player;

public final class GetOutOfJailFree extends AActionCard {

	public GetOutOfJailFree(String description, AActionCardField field) {
		super(description);
		this.origin = field;
	}

	@Override
	public IAction action(Player current, Collection<Player> others, IDice dice) {
		current.addCard(this);
		return new AAction(this.description, false) {

			@Override
			public boolean execute() {
				return true;
			}
			
			public boolean isGetOutOfJail() {
				return true;
			}

		};
	}
}