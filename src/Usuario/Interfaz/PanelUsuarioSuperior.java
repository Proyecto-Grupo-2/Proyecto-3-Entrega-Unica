package Usuario.Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuarioSuperior extends JPanel{
    private JLabel img;
	
	
	public PanelUsuarioSuperior() 
	{
		img = new JLabel( );
        add(img);
        
        ImageIcon icon= new ImageIcon("./data/imagenes/usuario.jpg" );
        img.setIcon( icon );
	}
}
