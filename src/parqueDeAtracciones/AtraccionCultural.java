package parqueDeAtracciones;

import java.time.LocalDateTime;

public class AtraccionCultural extends Atraccion {

	private int maxAge;
	private int minAge;
	private String restriccionClima;
	
	public AtraccionCultural(String nomAtraccion, String ubicacion, int capMax, int numMinEmp, LocalDateTime dateMax,
			LocalDateTime dateMin, ExcLevel excLevel,int maxAge, int minAge, String restriccionClima) {
		super(nomAtraccion, ubicacion, capMax, numMinEmp, dateMax, dateMin, excLevel);
		this.maxAge = maxAge;
		this.minAge = minAge;
		this.restriccionClima = restriccionClima;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public String getRestriccionClima() {
		return restriccionClima;
	}
	public void setRestriccionClima(String restriccionClima) {
		this.restriccionClima = restriccionClima;
	}

		
	
	
}

