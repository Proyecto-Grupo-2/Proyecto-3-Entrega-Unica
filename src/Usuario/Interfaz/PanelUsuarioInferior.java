package Usuario.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import empleado.interfaz.VentanaEmpleado;

public class PanelUsuarioInferior extends JPanel implements ActionListener{
    private JButton btnCerrar;
	
	private VentanaUsuario ventanaUs;
	
	public PanelUsuarioInferior(VentanaUsuario ventanaUs) 
	{
		this.ventanaUs = ventanaUs;
		
		btnCerrar = new JButton("Cerrar sesion");
		add(btnCerrar);
		btnCerrar.addActionListener( this );
		btnCerrar.setActionCommand( "CERRAR" );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == ("CERRAR")) 
		{
			ventanaUs.cerrarSesion();
		}
	}
}