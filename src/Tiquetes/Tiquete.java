package Tiquetes;
import java.io.*;
import java.util.List;



import java.util.ArrayList;


public class Tiquete  {
	
	private Boolean used; 
	private Double precio; 
	private String idticket;
	private String loginUsuario;
	private String excLevel;
	private String tipo;
	
	public Tiquete(Boolean used, Double precio, String idticket, String loginUsuario, String excLevel) {
		super();
		this.used = used;
		this.precio = precio;
		this.idticket = idticket;
		this.loginUsuario=loginUsuario;
		this.excLevel=excLevel;
	}
	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getIdticket() {
		return idticket;
	}
	public void setIdticket(String idticket) {
		this.idticket = idticket;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getExcLevel() {
		return excLevel;
	}
	public void setExcLevel(String excLevel) {
		this.excLevel = excLevel;
	}
	public String getTipo() {
	    return tipo;
	}
		
		
	}
	

	