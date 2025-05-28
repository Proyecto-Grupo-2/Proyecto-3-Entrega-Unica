package test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Tiquetes.FastPass;
import Tiquetes.Tiquete;
import Tiquetes.TiqueteDia;
import Tiquetes.TiqueteTemporada;
import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.Espectaculo;
import parqueDeAtracciones.ExcLevel;
import parqueDeAtracciones.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {

        ArrayList<Atraccion> listaAtracciones = new ArrayList<>();
        ArrayList<Espectaculo> listaEspectaculos = new ArrayList<>();
        ArrayList<Tiquete> listaTiquetes = new ArrayList<>();
        ArrayList<FastPass> listaFastPass = new ArrayList<>();


        usuario = new Usuario("juan123", "claveSegura", false, false,
                listaAtracciones, listaEspectaculos, listaFastPass, listaTiquetes);


        usuario.añadirAtraccion(new Atraccion(
                "Montaña Rusa",
                "Zona A",
                30,
                3,
                LocalDateTime.of(2025, 6, 1, 10, 0),
                LocalDateTime.of(2025, 6, 1, 18, 0),
                ExcLevel.DIAMANTE
        ));

        usuario.añadirEspectaculo(new Espectaculo(
                "Show de Magia",
                LocalDateTime.of(2025, 6, 1, 12, 0),
                LocalDateTime.of(2025, 6, 1, 14, 0),
                1.8,
                1.2
        ));
    }

    @Test
    public void testConsultarInfoAtraccionEspec_Existe() {
        Atraccion resultado = usuario.consultarInfoAtraccionEspec("Montaña Rusa");
        assertNotNull(resultado);
        assertEquals("Montaña Rusa", resultado.getNomAtraccion());
    }

    @Test
    public void testConsultarInfoAtraccionEspec_NoExiste() {
        Atraccion resultado = usuario.consultarInfoAtraccionEspec("Casa del Terror");
        assertNull(resultado);
    }

    @Test
    public void testConsultarInfoEspectaculoEspec_Existe() {
        Espectaculo resultado = usuario.consultarInfoEspectaculoEspec("Show de Magia");
        assertNotNull(resultado);
        assertEquals("Show de Magia", resultado.getNomEspectaculo());
    }

    @Test
    public void testConsultarInfoEspectaculoEspec_NoExiste() {
        Espectaculo resultado = usuario.consultarInfoEspectaculoEspec("Show Acrobático");
        assertNull(resultado);
    }
    
    
    @Test
    public void testCompraFastPass() {
        int prevSize = usuario.getListaFastPass().size();

        usuario.compraTiquetesOnline("juan123", "fastpass", "", 0.0, null, null);

        ArrayList<FastPass> fastPasses = usuario.getListaFastPass();
        assertEquals(prevSize + 1, fastPasses.size());

        FastPass fp = fastPasses.get(fastPasses.size() - 1);
        assertEquals("juan123", fp.getLoginUsuario());
        assertNotNull(fp.getFechaFastPass());
    }

    @Test
    public void testCompraTiqueteDia() {
        int prevSize = usuario.consultarCatalogoTiquetes().size();

        usuario.compraTiquetesOnline("juan123", "tiquetedia", "PLATA", 50.0, null, null);

        ArrayList<Tiquete> tiquetes = usuario.consultarCatalogoTiquetes();
        assertEquals(prevSize + 1, tiquetes.size());

        Tiquete t = tiquetes.get(tiquetes.size() - 1);
        assertTrue(t instanceof TiqueteDia);
        assertEquals("juan123", t.getLoginUsuario());
        assertEquals("PLATA", t.getExcLevel());
    }

    @Test
    public void testCompraTiqueteTemporada() {
        int prevSize = usuario.consultarCatalogoTiquetes().size();
        LocalDateTime inicio = LocalDateTime.of(2025, 6, 1, 10, 0);
        LocalDateTime fin = LocalDateTime.of(2025, 6, 30, 18, 0);

        usuario.compraTiquetesOnline("juan123", "tiquetetemporada", "ORO", 200.0, inicio, fin);

        ArrayList<Tiquete> tiquetes = usuario.consultarCatalogoTiquetes();
        assertEquals(prevSize + 1, tiquetes.size());

        Tiquete t = tiquetes.get(tiquetes.size() - 1);
        assertTrue(t instanceof TiqueteTemporada);
        TiqueteTemporada temp = (TiqueteTemporada) t;
        assertEquals("juan123", temp.getLoginUsuario());
        assertEquals(inicio, temp.getStarDate());
        assertEquals(fin, temp.getEndDate());
        assertEquals("ORO", temp.getExcLevel());
    }

    @Test
    public void testCompraConLoginIncorrecto_NoSeAgrega() {
        int prevSizeT = usuario.consultarCatalogoTiquetes().size();
        int prevSizeF = usuario.getListaFastPass().size();

        usuario.compraTiquetesOnline("otroLogin", "normal", "DIAMANTE", 100.0, null, null);
        usuario.compraTiquetesOnline("otroLogin", "fastpass", "", 0.0, null, null);

        assertEquals(prevSizeT, usuario.consultarCatalogoTiquetes().size());
        assertEquals(prevSizeF, usuario.getListaFastPass().size());
    }


}