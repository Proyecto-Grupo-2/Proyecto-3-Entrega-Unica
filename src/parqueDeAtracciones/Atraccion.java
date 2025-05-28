package parqueDeAtracciones;

import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Atraccion implements Serializable {

	private String nomAtraccion;
	private String ubicacion;
	private int capMax;
	private int numMinEmp;
	private LocalDateTime dateMax;
	private LocalDateTime dateMin;
	private ExcLevel excLevel;
	public Atraccion(String nomAtraccion, String ubicacion, int capMax, int numMinEmp, LocalDateTime dateMax,
			LocalDateTime dateMin, ExcLevel excLevel) {
		super();
		this.nomAtraccion = nomAtraccion;
		this.ubicacion = ubicacion;
		this.capMax = capMax;
		this.numMinEmp = numMinEmp;
		this.dateMax = dateMax;
		this.dateMin = dateMin;
		this.excLevel = excLevel;
	}
	public String getNomAtraccion() {
		return nomAtraccion;
	}
	public void setNomAtraccion(String nomAtraccion) {
		this.nomAtraccion = nomAtraccion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getCapMax() {
		return capMax;
	}
	public void setCapMax(int capMax) {
		this.capMax = capMax;
	}
	public int getNumMinEmp() {
		return numMinEmp;
	}
	public void setNumMinEmp(int numMinEmp) {
		this.numMinEmp = numMinEmp;
	}
	public LocalDateTime getDateMax() {
		return dateMax;
	}
	public void setDateMax(LocalDateTime dateMax) {
		this.dateMax = dateMax;
	}
	public LocalDateTime getDateMin() {
		return dateMin;
	}
	public void setDateMin(LocalDateTime dateMin) {
		this.dateMin = dateMin;
	}
	public ExcLevel getExcLevel() {
		return excLevel;
	}
	public void setExcLevel(ExcLevel excLevel) {
		this.excLevel = excLevel;
	}
	


	    private static final long serialVersionUID = 1L;


	    // Escribir Documento
	    public static void escribirAtraccionesTxt(List<Atraccion> atracciones) {
	        try {
	            File carpeta = new File("./data/");
	            if (!carpeta.exists()) carpeta.mkdirs();

	            PrintWriter escritor = new PrintWriter(new File("./data/atracciones.txt"));
	            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	            for (Atraccion a : atracciones) {
	                escritor.println(a.getNomAtraccion() + "--" +
	                        a.getUbicacion() + "--" +
	                        a.getCapMax() + "--" +
	                        a.getNumMinEmp() + "--" +
	                        a.getDateMin().format(formato) + "--" +
	                        a.getDateMax().format(formato) + "--" +
	                        a.getExcLevel());
	            }

	            escritor.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("Error al escribir atracciones: " + e.getMessage());
	        }
	    }

	    // Leer Documento
	    public static ArrayList<Atraccion> leerAtraccionesTxt() {
	        ArrayList<Atraccion> atracciones = new ArrayList<>();
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	        try (BufferedReader lector = new BufferedReader(new FileReader("./data/atracciones.txt"))) {
	            String linea = lector.readLine();
	            while (linea != null) {
	                String[] datos = linea.split("--");

	                String nombre = datos[0];
	                String ubicacion = datos[1];
	                int capMax = Integer.parseInt(datos[2]);
	                int numMinEmp = Integer.parseInt(datos[3]);
	                LocalDateTime dateMin = LocalDateTime.parse(datos[4], formato);
	                LocalDateTime dateMax = LocalDateTime.parse(datos[5], formato);
	                ExcLevel nivel = ExcLevel.valueOf(datos[6]);

	                atracciones.add(new Atraccion(nombre, ubicacion, capMax, numMinEmp, dateMin, dateMax, nivel));

	                linea = lector.readLine();
	            } 
	        } catch (IOException e) {
	            System.err.println("Error al leer atracciones: " + e.getMessage());
	        }

	        return atracciones;}
	    }
	
	

