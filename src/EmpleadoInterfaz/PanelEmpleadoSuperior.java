package EmpleadoInterfaz;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEmpleadoSuperior extends JPanel{
    private JLabel img;
	
	
	public PanelEmpleadoSuperior() 
	{
		img = new JLabel( );
        add(img);
        
        ImageIcon icon= new ImageIcon("./data/imagenes/empleado.png" );
        img.setIcon( icon );
	}
}