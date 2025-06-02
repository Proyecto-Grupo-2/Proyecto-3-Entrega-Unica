package AdministradorInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperiorAdmin extends JPanel {
    private JLabel img;
	
	
	public PanelSuperiorAdmin() {
		img = new JLabel( );
        add(img);
        
        ImageIcon icon= new ImageIcon("./data/imagenes/admin.jpg" );
        img.setIcon( icon );
	}
	
}
