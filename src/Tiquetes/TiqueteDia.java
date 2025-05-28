 package Tiquetes;
import java.time.LocalDateTime;



public class TiqueteDia extends Tiquete {
	private LocalDateTime fechatiquete;

	public TiqueteDia(Boolean used, Double precio, String idticket, String loginUsuario, LocalDateTime fechatiquete,String excLevel) {
		super(used, precio, idticket,loginUsuario, excLevel);
		this.fechatiquete = fechatiquete;
	}

	public LocalDateTime getFechatiquete() {
		return fechatiquete;
	}

	public void setFechatiquete(LocalDateTime fechatiquete) {
		this.fechatiquete = fechatiquete;
	} 
	
	
}
