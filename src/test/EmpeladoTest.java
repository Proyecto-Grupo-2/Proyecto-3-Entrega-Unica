package test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import java.util.*;
import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.Espectaculo;
import org.junit.jupiter.api.BeforeEach;
import parqueDeAtracciones.ExcLevel;
import Empleados.Empelado;
import Empleados.LugarServicio;
import Empleados.Turno;

public class EmpeladoTest {

	private Atraccion atraccion;
	private Empelado empelado;
	private Turno turno;
	private LocalDateTime fecha;
	private Espectaculo espectaculo;
	
	@BeforeEach
	void setUp() {
		ArrayList<String> habilidades = new ArrayList<>();
		habilidades.add("Atender atracciones");
		habilidades.add("Cocinero");
		
		ArrayList<Turno> turnos = new ArrayList<>();
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		ArrayList<Espectaculo> espectaculos = new ArrayList<>();
		ArrayList<Atraccion> atraccionesPermitidas = new ArrayList<>();
		
		empelado = new Empelado(true, habilidades, "EMP001", turnos, atracciones, espectaculos, atraccionesPermitidas);
		LocalDateTime dateMin = LocalDateTime.of(2025, 6, 1, 10, 0);
		LocalDateTime dateMax = LocalDateTime.of(2025, 6, 30, 18, 0);
		atraccion = new Atraccion("Montaña Rusa", "Zona Extrema", 30, 2, dateMax, dateMin, ExcLevel.DIAMANTE );
		espectaculo = new Espectaculo("Show de luces", dateMax, dateMin, 2.0, 1.0);
		fecha = LocalDateTime.of(2025, 6, 19, 7, 0);
		LugarServicio restaurante = new LugarServicio("RESTAURANTE");
		turno = new Turno(true, fecha, restaurante, "EMP001", null, false);
		
	}
	
	
	

	@Test
	void testIsEsAutorizado() {
		assertTrue(empelado.isEsAutorizado());
		empelado.setEsAutorizado(false);
		assertFalse(empelado.isEsAutorizado());
	}

	@Test
	void testAñadirAtraccion() {
		empelado.añadirAtraccion(atraccion);
		assertTrue(empelado.getListaAtracciones().contains(atraccion));
	}

	
	@Test
	void testAñadirEspectaculo() {
		empelado.añadirEspectaculo(espectaculo);
		assertTrue(empelado.getListaEspectaculos().contains(espectaculo));
	}

	
	@Test
	void testAñadirTurno() {
		empelado.añadirTurno(turno);
		assertTrue(empelado.getListaTurnos().contains(turno));
	}
	

	@Test
	void testConsultarTurno() {
		empelado.añadirTurno(turno);
		String consultado = empelado.consultarTurno(empelado.getListaTurnos(), "EMP001", true, fecha) ;
		String asser= "dirijase a "+turno.getLugarTurno()+ " para ejercer su turno";
		assertNotNull(consultado);
		assertEquals(asser, consultado);
		
	}
	
	@Test
	void testConsultarTurnoNoEncontrado() {
		String consultado = empelado.consultarTurno(empelado.getListaTurnos(), "EMP002", false, fecha);
		String esperado=  "No tiene ese turno ocupado en la fecha indicada";
		assertNotNull(consultado);
		assertEquals(esperado, consultado);
		
	}

}
