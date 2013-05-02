package monopoly;

public class BackThreeSpaces implements IAction {
	private final String description;
	private final Game game;
	
	public BackThreeSpaces(String description, Game game) {
		this.description = description; this.game = game;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public boolean execute() {
		Player current = game.getCurrent();
		current.advance(-3);
		return true;
	}

	@Override
	public boolean alternative() {
		return false;
	}

	@Override
	public boolean isImmediate() {
		return true;
	}

}
