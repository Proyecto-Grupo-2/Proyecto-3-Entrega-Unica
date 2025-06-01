package administrador.interfaz;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import login.interfaz.VentanaLogin;

public class VentanaAdmin extends JFrame{
	private PanelInferiorAdmin panelIAd;
	private PanelSuperiorAdmin panelSAd;
	private PanelCentroAdmin panelCAd;
	private VentanaLogin ventanaLo;
	
	public void cerrarSesion()
	{
		try 
		{
			ventanaLo.guardarAplicacion();
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog( this, "Error al guardar los datos" );
		}
		this.dispose();
		ventanaLo.setVisible(true);
		
	}
}