package monopoly;

import java.util.Collection;

/** 
 * Read-only view on a player
 */
public interface ReadPlayer {

	public abstract JailState getJailState();

	public abstract Collection<ReadProperty> viewProperties();

	public abstract int getCash();

	public abstract int getPosition();

	public abstract String getName();

}
