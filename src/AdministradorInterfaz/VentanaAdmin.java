package AdministradorInterfaz;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Empleados.Empelado;
import login.interfaz.VentanaLogin;
import parqueDeAtracciones.Parque;
import parqueDeAtracciones.consolaAdministrador;



public class VentanaAdmin<Atraccion> extends JFrame{
	private PanelInferiorAdmin panelIAd;
	private PanelSuperiorAdmin panelSAd;
	private PanelCentroAdmin panelCAd;
	private Parque miParque;
	private consolaAdministrador cAdmin;
	
	private VentanaLogin ventanaLo;
	
	public VentanaAdmin(Parque miParque, consolaAdministrador admin, VentanaLogin ventanaLo) 
	{
		this.miParque = miParque;
		this.cAdmin = admin;
		this.ventanaLo = ventanaLo;
		
		setTitle("Parque Atracciones");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		
		setLayout( new BorderLayout( ) );
		
		panelSAd = new PanelSuperiorAdmin();
		add(panelSAd, BorderLayout.NORTH);
		
		panelCAd = new PanelCentroAdmin(this);
		add(panelCAd, BorderLayout.CENTER);

		panelIAd = new PanelInferiorAdmin(this);
		add(panelIAd, BorderLayout.SOUTH);
	}
	
	public void cerrarSesion() {
        this.dispose();
        ventanaLo.setVisible(true);
    }
	
	public void asignarTurno() {
		
	}
	private void mostrarMensaje(String string) {
				
	}
	public void consultarTiquetesVendidos() {
		
	}
	public void consultarEspectaculoEspec() {
		
	}
	public void consultarAtraccionEspec() {
		
	}
	public void consultarAtracciones() {
		
	}
	public void consultarEspectaculo() {
		
	}
	private String pedirInput(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }
}
