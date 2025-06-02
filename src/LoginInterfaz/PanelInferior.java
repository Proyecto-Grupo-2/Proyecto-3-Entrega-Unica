package LoginInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferior extends JPanel implements ActionListener{
    private JButton butRegistrar;
	
	private VentanaLogin ventanaLo;
	
	public PanelInferior(VentanaLogin ventanaLo) 
	{
		this.ventanaLo = ventanaLo;
		
		butRegistrar = new JButton("Registrarse");
		add(butRegistrar);
		butRegistrar.addActionListener( this );
		butRegistrar.setActionCommand( "REGISTRAR" );
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand() == ("REGISTRAR")) 
		{
			ventanaLo.btnregistrarse();
		}
	}
}