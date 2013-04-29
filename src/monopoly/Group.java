package monopoly;

public enum Group {
	SADDLEBROWN(2),
	SKYBLUE(3),
	DARKORCHID(3),
	ORANGE(3),
	RED(3),
	YELLOW(3),
	GREEN(3),
	BLUE(2);
	
	private final int nrInGroup;
	private Group (int nrInGroup) {
		this.nrInGroup = nrInGroup;
	}
	public int getNrInGroup() {
		return nrInGroup;
	}
}
