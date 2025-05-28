package parqueDeAtracciones;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Empleados.Empelado;
import Empleados.LugarServicio;
import Empleados.Turno;
import parqueDeAtracciones.Parque;
import persistencias.Persistencia;
import Tiquetes.Tiquete;



public class consolaAdministrador {

	
	private Parque miParque;

	public consolaAdministrador(Parque miParque) {
		super();
		this.miParque = miParque;
	}

	public Parque getMiParque() {
		return miParque;
	}

	public void setMiParque(Parque miParque) {
		this.miParque = miParque;
	}
	
	public ArrayList<Atraccion> consultarAtracciones(Parque parque){
		return parque.getListaAtracciones();
	}
	
	public ArrayList<Espectaculo> consultarEspectaculos(Parque parque){
		return parque.getListaEspectaculos();
	}
	
	public Atraccion consultarAtraccionEspec(Atraccion atraccion) {
        for (Atraccion a : consultarAtracciones(miParque)) {
            if (a.getNomAtraccion().equalsIgnoreCase(atraccion.getNomAtraccion())) {
                return a;
            }
        }
        return null;
    }

    public Espectaculo consultarEspectaculoEspec(Espectaculo espectaculo) {
        for (Espectaculo e : consultarEspectaculos(miParque)) {
            if (e.getNomEspectaculo().equalsIgnoreCase(espectaculo.getNomEspectaculo())) {
                return e;
            }
        }
        return null;
    }


    public ArrayList<Tiquete> consultarTiquetesVendidos() {
        return Persistencia.leerTiquetesTxt(); 
    }

    
    public void asignarTurno(String idEmp, Boolean mananero, LocalDateTime fecha, String servicioLugar, String nomLugarServicio) {
        Empelado emp = miParque.buscarEmpeladoPorId(idEmp);

        if (emp == null) {
            System.out.println("Empleado no encontrado con ID: " + idEmp);
            return;
        }

        Turno nuevoTurno;

        if (servicioLugar.equalsIgnoreCase("Atraccion")) {
            Atraccion atr = miParque.buscarAtraccionPorNombre(nomLugarServicio);
            if (atr == null) {
                System.out.println("Atracción no encontrada: " + nomLugarServicio);
                return;
            }

            nuevoTurno = new Turno(mananero, fecha, null, idEmp, atr, true);
        } else {
            LugarServicio lugar = miParque.buscarLugarServicioPorNombre(nomLugarServicio);
            if (lugar == null) {
                System.out.println("Lugar de servicio no encontrado: " + nomLugarServicio);
                return;
            }

            nuevoTurno = new Turno(mananero, fecha, lugar, idEmp, null, false);
        }

        emp.añadirTurno(nuevoTurno);
        System.out.println("Turno asignado correctamente al empleado " + idEmp);
        }
}