/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public abstract class AAction implements IAction {
	private final String description;
	private final boolean required;
	
	protected AAction(String descr, boolean required) {
		this.description = descr;
		this.required = required;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public int movement() {
		return 0;
	}
	
	public boolean isGetOutOfJail() {
		return false;
	}
}
