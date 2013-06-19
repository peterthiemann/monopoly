/**
 * 
 */
package monopoly;

/**
 * Read-only Properties
 */
public interface ReadProperty {

	public boolean inColorGroup(Group colorGroup);
	
	public boolean isMortgaged();
	
	public boolean isRailroad();
	
	public boolean isUtility();
	
	public String getName();
	
}
