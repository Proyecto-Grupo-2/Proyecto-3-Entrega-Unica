package LoginInterfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel{
    private JLabel img;


    public PanelSuperior() {
        img = new JLabel( );
        add(img);

        ImageIcon icon= new ImageIcon("./data/imagenes/parqueAtracc.png" );
        img.setIcon( icon );
    }
}