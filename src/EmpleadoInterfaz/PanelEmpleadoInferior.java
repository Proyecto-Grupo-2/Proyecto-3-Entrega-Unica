package EmpleadoInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelEmpleadoInferior extends JPanel implements ActionListener{
    private JButton btnCerrar;
	
	private VentanaEmpleado ventanaEm;
	
	public PanelEmpleadoInferior(VentanaEmpleado ventanaEm) 
	{
		this.ventanaEm = ventanaEm;
		
		btnCerrar = new JButton("Cerrar sesion");
		add(btnCerrar);
		btnCerrar.addActionListener( this );
		btnCerrar.setActionCommand( "CERRAR" );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == ("CERRAR")) 
		{
			ventanaEm.cerrarSesion();
		}
	}

}