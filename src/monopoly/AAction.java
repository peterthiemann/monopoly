/**
 * 
 */
package monopoly;

/**
 * @author adpult
 *
 */
public abstract class AAction implements IAction {
	protected final String description;
	
	protected AAction(String descr) {
		this.description = descr;
	}

	public String myString() {
		return "Hello World!";
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
