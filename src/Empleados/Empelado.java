package Empleados;
import parqueDeAtracciones.Usuario;

import java.lang.reflect.Array;
import java.util.*;

import Tiquetes.TiqueteTemporada;
import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.Espectaculo;
import parqueDeAtracciones.Usuario;

import java.time.LocalDateTime;

public class Empelado {

	private boolean esAutorizado;
	
	private ArrayList<String> listaHabilidades= new ArrayList<String>();
	
	private String IdUnicoEmp;
	
	private ArrayList<Turno> listaTurnos= new ArrayList<Turno>(); 
	
	private ArrayList<Atraccion> listaAtracciones= new ArrayList<Atraccion>(); 

	private ArrayList<Espectaculo> listaEspectaculos= new ArrayList<Espectaculo>(); 

	private ArrayList<Atraccion> listaAtraccionesPermitidas= new ArrayList<Atraccion>(); 
	

	public Empelado(boolean esAutorizado, ArrayList<String> listaHabilidades, String idUnicoEmp,
			ArrayList<Turno> listaTurnos, ArrayList<Atraccion> listaAtracciones,
			ArrayList<Espectaculo> listaEspectaculos, ArrayList<Atraccion> listaAtraccionesPermitidas) {
		super();
		this.esAutorizado = esAutorizado;
		this.listaHabilidades = listaHabilidades;
		IdUnicoEmp = idUnicoEmp;
		this.listaTurnos = listaTurnos;
		this.listaAtracciones = listaAtracciones;
		this.listaEspectaculos = listaEspectaculos;
		this.listaAtraccionesPermitidas = listaAtraccionesPermitidas;
	}

	public boolean isEsAutorizado() {
		return esAutorizado;
	}

	public void setEsAutorizado(boolean esAutorizado) {
		this.esAutorizado = esAutorizado;
	}

	public ArrayList<String> getListaHabilidades() {
		return listaHabilidades;
	}

	public void setListaHabilidades(ArrayList<String> listaHabilidades) {
		this.listaHabilidades = listaHabilidades;
	}

	public String getIdUnicoEmp() {
		return IdUnicoEmp;
	}

	public void setIdUnicoEmp(String idUnicoEmp) {
		IdUnicoEmp = idUnicoEmp;
	}

	//
	public ArrayList<Turno> getListaTurnos() {
		return listaTurnos;
	}

	public void setListaTurnos(ArrayList<Turno> listaTurnos) {
		this.listaTurnos = listaTurnos;
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

	
	public ArrayList<Atraccion> getListaAtraccionesPermitidas() {
		return listaAtraccionesPermitidas;
	}
	public void setListaAtraccionesPermitidas(ArrayList<Atraccion> listaAtraccionesPermitidas) {
		this.listaAtraccionesPermitidas = listaAtraccionesPermitidas;
	}
	
	//aca empiezan los add 

	public void añadirAtraccion(Atraccion atraccion) {
		this.listaAtracciones.add(atraccion);
	}
	
	public void añadirEspectaculo(Espectaculo espectaculo) {
		this.listaEspectaculos.add(espectaculo);
	}
	
	public void añadirTurno(Turno turno) {
		this.listaTurnos.add(turno);
	}
	
	public String consultarTurno(ArrayList<Turno> Turnos, String idEmp, Boolean mananero, LocalDateTime fecha) {
		for (Turno turno : Turnos) {
			if (turno.getIdEmpAsig().equals(idEmp) & turno.isEsMañanero()== mananero & turno.getFechaTurno()==fecha) {
				if (turno.getEsEnAtraccion()) {
					return "dirijase a " + turno.getAtraccionTurno() + " para ejercer su turno";
				}
				else {
					return "dirijase a " + turno.getLugarTurno() + " para ejercer su turno";
				}
			}
		}
		return "No tiene ese turno ocupado en la fecha indicada";
	}
	
	public void venderTiquete(String loginU, String tipoTiquete, Integer prioridadTiquete) {
		
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
}
	
	
	

// y falta lo de la lista de habilidades que nose como putas lo voy a hacer 

