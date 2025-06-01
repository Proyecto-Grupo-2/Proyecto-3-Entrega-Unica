package Usuario.Interfaz;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import login.interfaz.VentanaLogin;


public class VentanaUsuario extends JPanel{
	private PanelUsuarioInferior panelI;
	private PanelUsuarioSuperior panelS;
	private PanelUsuarioCentro panelC;
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
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
}