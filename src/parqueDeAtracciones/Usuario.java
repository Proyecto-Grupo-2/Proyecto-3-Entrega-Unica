package parqueDeAtracciones;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;


import Tiquetes.FastPass;
import Tiquetes.Tiquete;
import Tiquetes.TiqueteDia;
import Tiquetes.TiqueteTemporada;

public class Usuario {
	private String login; 
	private String password; 
	private Boolean esEmpleado;
	private Boolean esAdministrador;
	private ArrayList<Atraccion> listaAtracciones= new ArrayList<Atraccion>(); 

	private ArrayList<Espectaculo> listaEspectaculos= new ArrayList<Espectaculo>(); 
	private ArrayList<Tiquete> listaTiquetes= new ArrayList<Tiquete>(); 
	private ArrayList<FastPass> listaFastPass= new ArrayList<FastPass>(); 
	
	
	
	public Usuario(String login, String password, Boolean esEmpleado, Boolean esAdministrador, ArrayList<Atraccion> listaAtracciones
			, ArrayList<Espectaculo> listaEspectaculos,  ArrayList<FastPass> listaFastPass,  ArrayList<Tiquete> listaTiquetes) {
		super();
		this.login = login;
		this.password = password;
		this.esEmpleado = esEmpleado;
		this.esAdministrador = esAdministrador;
		this.listaAtracciones = listaAtracciones;
		this.listaEspectaculos = listaEspectaculos;
		this.listaFastPass= listaFastPass; 
		this.listaTiquetes= listaTiquetes;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEsEmpleado() {
		return esEmpleado;
	}
	public void setEsEmpleado(Boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	public Boolean getEsAdministrador() {
		return esAdministrador;
	}
	public void setEsAdministrador(Boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}
	public ArrayList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}
	public void setListaAtracciones(ArrayList<Atraccion> listaAtracciones) {
		this.listaAtracciones = listaAtracciones;
	}
	
	public ArrayList<Espectaculo> getListaEspectaculos() {
		return listaEspectaculos;
	}
	public void setListaEspectaculos(ArrayList<Espectaculo> listaEspectaculos) {
		this.listaEspectaculos = listaEspectaculos;
	} 
	
	public void añadirAtraccion(Atraccion atraccion) {
		this.listaAtracciones.add(atraccion);
	}
	
	public void añadirEspectaculo(Espectaculo espectaculo) {
		this.listaEspectaculos.add(espectaculo);
	}
	
	
	public void añadirTiquete(Tiquete tiquete) {
		if (login==tiquete.getLoginUsuario()) {
			this.listaTiquetes.add(tiquete);
			}
	}

	public void añadirFastPass(FastPass fastPass) {
		if (login==fastPass.getLoginUsuario()) {
			this.listaFastPass.add(fastPass);
			}
	}
	public ArrayList<Atraccion> consultarCatalogoAtracciones() {
		ArrayList<Atraccion> atracciones = getListaAtracciones();
		return atracciones;
	}
	
	public ArrayList<Tiquete> consultarCatalogoTiquetes(){
		ArrayList<Tiquete> tiquetes = this.listaTiquetes;
		return tiquetes;
	}
	
	public ArrayList<FastPass> getListaFastPass() {
	    return listaFastPass;
	}

	public Atraccion consultarInfoAtraccionEspec(String nomA)
	{
		Atraccion actual=null;
		for (int i = 0; i < listaAtracciones.size(); i++) 
		{
			actual = listaAtracciones.get( i );
            if(actual.getNomAtraccion().equals(nomA))
            {
                    return actual;
            }
		}
		return null; 
}

	
	public Espectaculo consultarInfoEspectaculoEspec(String nomE)
	{
		Espectaculo actual=null;
		for (int i = 0; i < listaEspectaculos.size(); i++) 
		{
			actual = listaEspectaculos.get( i );
            if(actual.getNomEspectaculo().equals(nomE))
            {
                    return actual;
            } 
	}
		return null;
}
	public void compraTiquetesOnline(String loginU, String tipoTiquete, String excLevel, double precio, 
            LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		if(login.equals(loginU)) {
			String idUnico = UUID.randomUUID().toString().substring(0, 8);
			if(tipoTiquete.toUpperCase().equals("normal".toUpperCase())) {
				Tiquete nuevoTiquete = new Tiquete(false, precio, loginU, idUnico, excLevel);
		        this.listaTiquetes.add(nuevoTiquete);
			}
			else if(tipoTiquete.toUpperCase().equalsIgnoreCase("fastpass".toUpperCase())) {
		        FastPass nuevoFastPass = new FastPass(LocalDateTime.now(), loginU, idUnico);
		        this.listaFastPass.add(nuevoFastPass);
		    }
			else if(tipoTiquete.toUpperCase().equalsIgnoreCase("tiquetedia".toUpperCase())) {
				TiqueteDia tiqueteDia = new TiqueteDia(false, precio, idUnico, loginU , LocalDateTime.now(),excLevel);
				this.listaTiquetes.add(tiqueteDia);
			}
			else if(tipoTiquete.toUpperCase().equalsIgnoreCase("tiquetetemporada".toUpperCase())){
				TiqueteTemporada tiqueteTemp = new TiqueteTemporada(false, precio, idUnico, loginU,excLevel, fechaInicio, fechaFin);
	            this.listaTiquetes.add(tiqueteTemp);
			}
		}
		
	}
}









