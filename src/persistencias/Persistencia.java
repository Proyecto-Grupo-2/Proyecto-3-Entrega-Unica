package persistencias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import Tiquetes.Tiquete;
import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.Espectaculo;
import parqueDeAtracciones.ExcLevel;
import parqueDeAtracciones.Parque;

public class Persistencia {
	
	private static final String PARQUE_ARCHIVO = "./data/parque.ser";
	public static void guardarParque (Parque parque) { //Este metodo guarda parque como objeto por medio de serializacion.
		try {
			File folder = new File("./data/");
			if(!folder.exists()) {
				folder.mkdirs();
				
			}
		ObjectOutputStream objetoAEscribir = new ObjectOutputStream(new FileOutputStream(PARQUE_ARCHIVO));
		objetoAEscribir.writeObject(parque);
		objetoAEscribir.close();
		
		System.out.println("La ultima version del parque ha sido guardada correctamente");
		}
		catch (IOException e) {
			System.err.println("Ocurrio un error al intentar guardar el parque: " + e.getMessage());
		}
			
		
	}
	
	public static Parque cargarParque() {
		try {
			ObjectInputStream objetoALeer = new ObjectInputStream(new FileInputStream(PARQUE_ARCHIVO));
			Parque parque = (Parque) objetoALeer.readObject();
			objetoALeer.close();
			System.out.println("El parque se ha cargado correctamente.");
			return parque; }
		catch (IOException e) {
			System.err.println("El parque no se ha podido leer debido a un error, se creara una nueva version.");
			return new Parque();
		}
		catch (ClassNotFoundException e) {
			System.err.println("La clase Parque no se encontro, se creara otra.");
			return new Parque();
		}
	}

    public static void escribirAtraccionesTxt(List<Atraccion> atracciones) 
    {
        try {
            File carpeta = new File("./data/");
            if (!carpeta.exists()) carpeta.mkdirs();

            PrintWriter escritor = new PrintWriter(new File("./data/atracciones.txt"));
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (Atraccion a : atracciones) 
            {
                escritor.println(a.getNomAtraccion() + "--" +
                        a.getUbicacion() + "--" +
                        a.getCapMax() + "--" +
                        a.getNumMinEmp() + "--" +
                        a.getDateMin().format(formato) + "--" +
                        a.getDateMax().format(formato) + "--" +
                        a.getExcLevel());
            }

            escritor.close();
        } 
        catch (FileNotFoundException e)
        {
            System.err.println("Error al escribir atracciones: " + e.getMessage());
        }
    }


    public static ArrayList<Atraccion> leerAtraccionesTxt() 
    {
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (BufferedReader lector = new BufferedReader(new FileReader("./data/atracciones.txt"))) 
        {
            String linea = lector.readLine();
            while (linea != null) 
            {
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
        } 
        catch (IOException e) 
        {
            System.err.println("Error al leer atracciones: " + e.getMessage());
        }

        return atracciones;
        }


    public static void escribirEspectaculosTxt(List<Espectaculo> espectaculos) 
    {
        try 
        {
            File carpeta = new File("./data/");
            if (!carpeta.exists()) carpeta.mkdirs();

            PrintWriter escritor = new PrintWriter(new File("./data/espectaculos.txt"));
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (Espectaculo e : espectaculos) 
            {
                escritor.println(e.getNomEspectaculo() + "--" +
                        e.getDateMin().format(formato) + "--" +
                        e.getDateMax().format(formato) + "--" +
                        e.getAlturaMin() + "--" +
                        e.getAlturaMax());
            }

            escritor.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Error al escribir espectáculos: " + e.getMessage());
        }
    }


    public static ArrayList<Espectaculo> leerEspectaculosTxt() 
    {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try (BufferedReader lector = new BufferedReader(new FileReader("./data/espectaculos.txt"))) 
        {
            String linea = lector.readLine();
            while (linea != null) 
            {
                String[] datos = linea.split("--");

                String nombre = datos[0];
                LocalDateTime dateMin = LocalDateTime.parse(datos[1], formato);
                LocalDateTime dateMax = LocalDateTime.parse(datos[2], formato);
                double alturaMin = Double.parseDouble(datos[3]);
                double alturaMax = Double.parseDouble(datos[4]);

                espectaculos.add(new Espectaculo(nombre, dateMin, dateMax, alturaMin, alturaMax));
                linea = lector.readLine();
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error al leer espectáculos: " + e.getMessage());
        }

        return espectaculos;
    }

  
  		public static void escribirTiquetestxt(List<Tiquete> tiquetes) 
  		{
  			try 
  			{
  				File carpeta = new File("./data/");
  				if(!carpeta.exists()) carpeta.mkdirs();
  				
  				PrintWriter escritor = new PrintWriter(new File("./data/tiquetes.txt"));
  				
  				for (Tiquete t : tiquetes) 
  				{
  					escritor.println(t.getIdticket() + "--" +
  				    t.getPrecio() + "--" + 
  					t.getUsed() + "--" +
  				    t.getLoginUsuario()+ "--" +
  					t.getExcLevel());
  				}
  				
  				escritor.close();
  			} 
  			catch (FileNotFoundException e) 
  			{
  				System.err.println("Error al escribir tiquetes: " + e.getMessage());
  			}
  		}
  		
  		public static ArrayList<Tiquete> leerTiquetesTxt(){ 
  			ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
  			
  			try (BufferedReader lector = new BufferedReader(new FileReader("./data/tiquetes.txt"))) 
  			{
  				String linea = lector.readLine();
  				while (linea != null) 
  				{
  					String[] datos = linea.split("--");
  					
  					String idticket = datos[0];
  					double precio = Double.parseDouble(datos[1]);
  					boolean used = Boolean.parseBoolean(datos[2]);
  					String loginUsuario = datos[3];
  					String excLevel =datos[4];
  					Tiquete t = new Tiquete(used, precio, idticket,loginUsuario, excLevel);
  					
  					t.setLoginUsuario(loginUsuario);
  					tiquetes.add(t);
  					
  					linea = lector.readLine();
  				}
  			} 
  			catch (IOException e) 
  			{
  				System.err.println("Error al leer tiquetes: " + e.getMessage());
  			}
  			return tiquetes ; 
  		}}
  		
  	
