package monopoly;

public enum JailState {
	FREE, INJAIL, INJAIL1, INJAIL2, INJAIL3;
	
	public boolean hasNext() {
		return this != INJAIL3;
	}
	
	public JailState next() {
		return JailState.values()[this.ordinal()+1];
	}
}
