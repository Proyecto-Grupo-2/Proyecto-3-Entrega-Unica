package Tiquetes;
import java.time.LocalDateTime;

public class FastPass {
	private LocalDateTime fechaFastPass; 
	private String loginUsuario; 
	private String idFastPass;
	
	
	public FastPass(LocalDateTime fechaFastPass, String loginUsuario, String idFastPass) {
		super();
		this.fechaFastPass = fechaFastPass;
		this.loginUsuario = loginUsuario;
		this.idFastPass = idFastPass;
	}
	public LocalDateTime getFechaFastPass() {
		return fechaFastPass;
	}
	public void setFechaFastPass(LocalDateTime fechaFastPass) {
		this.fechaFastPass = fechaFastPass;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getIdFastPass() {
		return idFastPass;
	}
	public void setIdFastPass(String idFastPass) {
		this.idFastPass = idFastPass;
	} 
	
	
}
	