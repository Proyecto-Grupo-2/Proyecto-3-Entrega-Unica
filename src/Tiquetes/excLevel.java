package Tiquetes;


	public enum excLevel {
		FAMILIAR(1),
	    ORO(2),
	    DIAMANTE(3),
		BASICO(4);
		
	    private final int exc;

	    excLevel(int exc) {
	        this.exc = exc;
	    }

	    public int getNivel() {
	        return exc;
	    }
}
