package AdministradorInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import empleado.interfaz.VentanaEmpleado;

public class PanelInferiorAdmin extends JPanel implements ActionListener{
	
	private JButton btnCerrar;
	private VentanaAdmin ventanaAd;

	public PanelInferiorAdmin(VentanaAdmin ventanaAd) 
	{
		this.ventanaAd = ventanaAd;
		
		btnCerrar = new JButton("Cerrar sesion");
		add(btnCerrar);
		btnCerrar.addActionListener( this );
		btnCerrar.setActionCommand( "CERRAR" );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == ("CERRAR")) 
		{
			ventanaAd.cerrarSesion();
		}
	}

}