package parqueDeAtracciones;

import java.time.LocalDateTime;

public class AtraccionMecanica extends Atraccion {

	private double alturaMax;
	private double alturaMin;
	private double pesoMin;
	private double pesoMax;
	private boolean opera;
	private String[] restriccionesSalud;
	private riskLevel riskLevel;
	private String restriccionClima;
	public AtraccionMecanica(String nomAtraccion, String ubicacion, int capMax, int numMinEmp, LocalDateTime dateMax,
			LocalDateTime dateMin, ExcLevel excLevel, double alturaMax, double alturaMin, double pesoMin, double pesoMax, boolean opera,
			String[] restriccionesSalud, parqueDeAtracciones.riskLevel riskLevel, String restriccionClima) {
		super(nomAtraccion, ubicacion, capMax, numMinEmp, dateMax, dateMin, excLevel);
		this.alturaMax = alturaMax;
		this.alturaMin = alturaMin;
		this.pesoMin = pesoMin;
		this.pesoMax = pesoMax;
		this.opera = opera;
		this.restriccionesSalud = restriccionesSalud;
		this.riskLevel = riskLevel;
		this.restriccionClima = restriccionClima;
	}
	public double getAlturaMax() {
		return alturaMax;
	}
	public void setAlturaMax(double alturaMax) {
		this.alturaMax = alturaMax;
	}
	public double getAlturaMin() {
		return alturaMin;
	}
	public void setAlturaMin(double alturaMin) {
		this.alturaMin = alturaMin;
	}
	public double getPesoMin() {
		return pesoMin;
	}
	public void setPesoMin(double pesoMin) {
		this.pesoMin = pesoMin;
	}
	public double getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	public boolean isOpera() {
		return opera;
	}
	public void setOpera(boolean opera) {
		this.opera = opera;
	}
	public String[] getRestriccionesSalud() {
		return restriccionesSalud;
	}
	public void setRestriccionesSalud(String[] restriccionesSalud) {
		this.restriccionesSalud = restriccionesSalud;
	}
	public riskLevel getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(riskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getRestriccionClima() {
		return restriccionClima;
	}
	public void setRestriccionClima(String restriccionClima) {
		this.restriccionClima = restriccionClima;
	}
	
	 
}
