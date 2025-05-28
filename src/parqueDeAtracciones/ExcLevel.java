package parqueDeAtracciones;

public enum ExcLevel {
	 
	FAMILIAR(1),
    ORO(2),
    DIAMANTE(3);
	
    private final int risk;

    ExcLevel(int risk) {
        this.risk = risk;
    }

    public int getNivel() {
        return risk;
    }

}