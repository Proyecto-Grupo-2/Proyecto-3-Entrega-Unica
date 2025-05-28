package test;

import parqueDeAtracciones.*;
import Empleados.*;
import Tiquetes.Tiquete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestConsolaAdministrador {

    private Parque parque;
    private consolaAdministrador admin;
    private Empelado emp;

    @BeforeEach
    public void setUp() {
        ArrayList<Empelado> empelados = new ArrayList<>();
        ArrayList<Atraccion> atracciones = new ArrayList<>();
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        ArrayList<LugarServicio> lugares = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Turno> turnos = new ArrayList<>();

        Atraccion atr1 = new Atraccion("Montaña Rusa", "Zona A", 30, 2, null, null, null);
        Atraccion atr2 = new Atraccion("Casa del Terror", "Zona B", 20, 2, null, null, null);
        atracciones.add(atr1);
        atracciones.add(atr2);

        Espectaculo esp1 = new Espectaculo("Show Mágico", null, null, 1.0, 2.0);
        Espectaculo esp2 = new Espectaculo("Circo Extremo", null, null, 1.2, 2.5);
        espectaculos.add(esp1);
        espectaculos.add(esp2);

        LugarServicio lugar = new LugarServicio("Tienda Norte");
        lugares.add(lugar);

        emp = new Empelado(true, new ArrayList<>(), "EMP001", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        empelados.add(emp);

        parque = new Parque(empelados, atracciones, espectaculos, lugares, usuarios, turnos);
        admin = new consolaAdministrador(parque);
    }

    @Test
    public void testConsultarAtracciones() {
        ArrayList<Atraccion> atracciones = admin.consultarAtracciones(parque);
        assertEquals(2, atracciones.size());
        assertEquals("Montaña Rusa", atracciones.get(0).getNomAtraccion());
    }

    @Test
    public void testConsultarEspectaculos() {
        ArrayList<Espectaculo> espectaculos = admin.consultarEspectaculos(parque);
        assertEquals(2, espectaculos.size());
        assertEquals("Show Mágico", espectaculos.get(0).getNomEspectaculo());
    }

    @Test
    public void testConsultarAtraccionEspec() {
        Atraccion buscada = admin.consultarAtraccionEspec(new Atraccion("Casa del Terror", "", 0, 0, null, null, null));
        assertNotNull(buscada);
        assertEquals("Casa del Terror", buscada.getNomAtraccion());
    }

    @Test
    public void testConsultarEspectaculoEspec() {
        Espectaculo buscado = admin.consultarEspectaculoEspec(new Espectaculo("Circo Extremo", null, null, 0, 0));
        assertNotNull(buscado);
        assertEquals("Circo Extremo", buscado.getNomEspectaculo());
    }

    @Test
    public void testConsultarTiquetesVendidos() {
        ArrayList<Tiquete> tiquetes = admin.consultarTiquetesVendidos();
        assertTrue(tiquetes == null || tiquetes.isEmpty()); // Asume archivo vacío inicialmente
    }

    @Test
    public void testAsignarTurno() {
        admin.asignarTurno("EMP001", true, LocalDateTime.of(2025, 6, 10, 10, 0), "Atraccion", "Montaña Rusa");

        ArrayList<Turno> turnos = emp.getListaTurnos();
        assertEquals(1, turnos.size());
        assertEquals("Montaña Rusa", turnos.get(0).getAtraccionTurno().getNomAtraccion());
        assertEquals(LocalDateTime.of(2025, 6, 10, 10, 0), turnos.get(0).getFechaTurno());
    }
}
