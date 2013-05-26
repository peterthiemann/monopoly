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
	
	protected AAction(String descr) {
		this.description = descr;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
	
	public boolean isRequired() {
		return false;
	}
	
	public int movement() {
		return 0;
	}
}
