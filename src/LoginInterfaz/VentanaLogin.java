package LoginInterfaz;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import Empleados.*;
import parqueDeAtracciones.*;
import parqueDeAtracciones.Usuario;
import persistencias.Persistencia;

public class VentanaLogin extends JFrame {

    private PanelSuperior panelS;
    private PanelCentro panelC;
    private PanelInferior panelI;
    private Parque miParque;
    static ArrayList<Atraccion> atracciones;
    static ArrayList<Espectaculo> espectaculos;
    static ArrayList<Usuario> usuarios;
    static ArrayList<Empelado> empleados;
    static ArrayList<LugarServicio> lugarServicio;
    static ArrayList<Turno> turnos;
    static ArrayList<consolaAdministrador> administradores;
   
    public VentanaLogin() {
        setSize(400, 500);
        setTitle("Parque de Atracciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout(0, 0));
        
        panelS = new PanelSuperior();
        add(panelS, BorderLayout.NORTH);

        panelC = new PanelCentro(this);
        add(panelC, BorderLayout.CENTER);

        panelI = new PanelInferior(this);
        add(panelI, BorderLayout.SOUTH);

        administradores = new ArrayList<>();
        empleados = new ArrayList<>();
        usuarios = new ArrayList<>();

        try {
        miParque = cargarDatos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el parque.");
        }
    }

    private static Parque cargarDatos() throws IOException {
        turnos = new ArrayList<>();
        empleados = new ArrayList<>();
        atracciones = new ArrayList<>();
        espectaculos = new ArrayList<>();
        lugarServicio = new ArrayList<>();
        usuarios = new ArrayList<>();
        Parque parque = new Parque(empleados, atracciones, espectaculos, lugarServicio, usuarios, turnos);
        Persistencia.leerAtraccionesTxt();
        Persistencia.leerEspectaculosTxt();
        Persistencia.leerTiquetesTxt();

        return parque;
    }

    public void guardarAplicacion() {
        Persistencia.escribirAtraccionesTxt(atracciones);
        Persistencia.escribirEspectaculosTxt(espectaculos);
        Persistencia.escribirTiquetestxt(Usuario.listaTiquetes());}

    public void IniciarSesion(String usuario, String contraseña, String tipoUsuario) {
    	if (tipo.equals("Administrador")) {
            for (consolaAdministrador admin : administradores) {
                if (admin.getNombre().equals(usuario) && admin.getPassword().equals(contraseña)) {
                    new AdministradorInterfaz.VentanaAdmin();
                    dispose();
                    return;
                }
            }
        } else if (tipoUsuario.equals("Empleado")) {
            for (Empelado empleado : empleados) {
                if (empleado.getLogin().equals(usuario) && empleado.getPassword().equals(contraseña)) {
                    new EmpleadoInterfaz.VentaEmpleado();
                    dispose();
                    return;
                }
            }
        } else if (tipoUsuario.equals("Usuario")) {
            for (Usuario u : usuarios) {
                if (u.getLogin().equals(username) && u.getPassword().equals(contraseña)) {
                    new Usuario.Interfaz.VentaUsuario();
                    dispose();
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Usuario o contraseña invalidos.");
    }

    public void RegistroEmpleados(String tipoUsuario, String usuario, String contraseña) {
    	if (tipo.equals("Administrador")) {
            consolaAdministrador nuevoAdmin = new consolaAdministrador(usuario, contraseña);
            administradores.add(nuevoAdmin);
            JOptionPane.showMessageDialog(this, "Administrador registrado correctamente.");
        } else if (tipoUsuario.equals("Empleado")) {
            Empelado nuevoEmpleado = new Empelado(usuario, contraseña);
            empleados.add(nuevoEmpleado);
            JOptionPane.showMessageDialog(this, "Empleado registrado correctamente.");
        }
    }

    public static void main(String[] args) {
        new VentanaLogin();
    }
}
