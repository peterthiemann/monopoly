package monopoly;

public abstract class AActionCard implements IActionCard {
	protected String description;
	protected AActionCardField origin;
	
	protected AActionCard(String description) {
		this.description = description;
		this.origin = null;
	}
	
	public void returnCard() {
		if (origin != null) origin.returnCard(this);
	}

}
