package parqueDeAtracciones;

public enum riskLevel {
 
	MEDIO(1),
    ALTO(2);
	
    private final int risk;

    riskLevel(int risk) {
        this.risk = risk;
    }

    public int getNivel() {
        return risk;
    }

}
