package monopoly;

import java.awt.Color;

public enum Group {
	SADDLEBROWN(2,  50),
	SKYBLUE    (3,  50),
	DARKORCHID (3, 100),
	ORANGE     (3, 100),
	RED        (3, 150),
	YELLOW     (3, 150),
	GREEN      (3, 200),
	BLUE       (2, 200);
	
	private final int nrInGroup;
	private final int houseCost;
	private Group (int nrInGroup, int houseCost) {
		this.nrInGroup = nrInGroup;
		this.houseCost = houseCost;
	}
	public int getNrInGroup() {
		return nrInGroup;
	}
	public int getHouseCost() {
		return houseCost;
	}
}
