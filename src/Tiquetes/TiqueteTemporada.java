
package Tiquetes;
import java.time.LocalDateTime;


public class TiqueteTemporada extends Tiquete {

	private LocalDateTime starDate;
	private LocalDateTime endDate;
	
	public TiqueteTemporada(Boolean used, Double precio, String idticket, String loginUsuario, String excLevel, LocalDateTime starDate,
			LocalDateTime endDate) {
		super(used, precio, idticket, loginUsuario, excLevel);
		this.starDate = starDate;
		this.endDate = endDate;
	}
	public LocalDateTime getStarDate() {
		return starDate;
	}
	public void setStarDate(LocalDateTime starDate) {
		this.starDate = starDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	
}
