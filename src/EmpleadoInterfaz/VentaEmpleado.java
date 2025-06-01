package EmpleadoInterfaz;

import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import login.interfaz.VentanaLogin;

public class VentanaEmpleado extends JFrame{
	private PanelEmpleadoInferior panelI;
	private PanelEmpleadoSuperior panelS;
	private PanelEmpleadoCentro panelC;
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