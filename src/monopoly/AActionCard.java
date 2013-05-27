package monopoly;

public abstract class AActionCard implements IActionCard {
	protected String description;
	protected AActionCard(String description) {
		this.description = description;
	}

}
