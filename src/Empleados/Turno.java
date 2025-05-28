	package Empleados;

import java.time.LocalDateTime;
import java.util.*;

import parqueDeAtracciones.Atraccion;

public class Turno {

	private boolean esMañanero;
	private LocalDateTime fechaTurno;
	private LugarServicio lugarTurno; 
	private String idEmpAsig; 
	private Atraccion atraccionTurno;
	private Boolean esEnAtraccion; 
	public Turno(boolean esMañanero, LocalDateTime fechaTurno, LugarServicio lugarTurno, String idEmpAsig,
			Atraccion atraccionTurno, boolean esEnAtraccion) {
		super();
		this.esMañanero = esMañanero;
		this.fechaTurno = fechaTurno;
		this.lugarTurno = lugarTurno;
		this.idEmpAsig = idEmpAsig;
		this.atraccionTurno = atraccionTurno;
		this.esEnAtraccion = esEnAtraccion;
	}
	public boolean isEsMañanero() {
		return esMañanero;
	}
	public void setEsMañanero(boolean esMañanero) {
		this.esMañanero = esMañanero;
	}
	public LocalDateTime getFechaTurno() {
		return fechaTurno;
	}
	public void setFechaTurno(LocalDateTime fechaTurno) {
		this.fechaTurno = fechaTurno;
	}
	
	
	
	public Boolean getEsEnAtraccion() {
		return esEnAtraccion;
	}
	public void setEsEnAtraccion(Boolean esEnAtraccion) {
		this.esEnAtraccion = esEnAtraccion;
	}
	public LugarServicio getLugarTurno() {
		return lugarTurno;
	}
	
	
	public String getIdEmpAsig() {
		return idEmpAsig;
	}
	public void setIdEmpAsig(String idEmpAsig) {
		this.idEmpAsig = idEmpAsig;
	}

	
	public Atraccion getAtraccionTurno() {
		return atraccionTurno;
	}

	public void setAtraccionTurno(Atraccion atraccionTurno) {
		if (esEnAtraccion) {
			this.atraccionTurno = atraccionTurno;
		}
		else {
			this.atraccionTurno = null;
		}
		
	}
	
	public void setLugarTurno(LugarServicio lugarTurno) {
		if (esEnAtraccion) {
			this.lugarTurno = null;
		}
		else {
			this.lugarTurno = lugarTurno;
		}
		
	}
	
	
}
