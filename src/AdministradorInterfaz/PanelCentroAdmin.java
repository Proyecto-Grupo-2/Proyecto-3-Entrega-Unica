package AdministradoInterfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelCentroAdmin extends JPanel implements ActionListener{
	private JButton butAsignarTurno;
	private JButton butConsultarTiquetes;
	private JButton butConsultarEspectaculoEspec;
	private JButton butConsultarAtraccionEspec;
	private JButton butConsultarEspectaculos;
	private JButton butConsultarAtracciones;
	private VentanaAdmin ventanaAd;
	
	public PanelCentroAdmin(VentanaAdmin ventanaAd) {
		this.ventanaAd=ventanaAd;
		
		setLayout(new BorderLayout());
		JLabel titulo = new JLabel("Seleccione una acción administrativa:", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(6, 1, 10, 10));

        butAsignarTurno = new JButton("Asignar Turno:");
        butAsignarTurno.setActionCommand("ASIG_TUR");
        butAsignarTurno.addActionListener(this);
        grid.add(butAsignarTurno);
        
        butConsultarTiquetes = new JButton("Consultar Tiquetes Vendidos:");
        butConsultarTiquetes.setActionCommand("CONS_TIQ");
        butConsultarTiquetes.addActionListener(this);
        grid.add(butConsultarTiquetes);
        
        butConsultarEspectaculoEspec = new JButton("Consultar Espectáculo en específico:");
        butConsultarEspectaculoEspec.setActionCommand("CONS_ESPECESPEC");
        butConsultarEspectaculoEspec.addActionListener(this);
        grid.add(butConsultarEspectaculoEspec);
        
        butConsultarAtraccionEspec = new JButton("Consultar Atracción en específico:");
        butConsultarAtraccionEspec.setActionCommand("CONS_ATRACCESPEC");
        butConsultarAtraccionEspec.addActionListener(this);
        grid.add(butConsultarAtraccionEspec);
        
        butConsultarEspectaculos = new JButton("Consultar Espectáculos:");
        butConsultarEspectaculos.setActionCommand("CONS_ESPEC");
        butConsultarEspectaculos.addActionListener(this);
        grid.add(butConsultarEspectaculos);
        
        butConsultarAtracciones = new JButton("Consultar Atracciones:");
        butConsultarAtracciones.setActionCommand("CONS_ATRACC");
        butConsultarAtracciones.addActionListener(this);
        grid.add(butConsultarAtracciones);
        
        add(grid, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();

        if (accion.equals("ASIG_TUR")) {
            ventanaAd.asignarTurno();
        } else if (accion.equals("CONS_TIQ")) {
            ventanaAd.consultarTiquetesVendidos();
        } else if (accion.equals("CONS_ESPECESPEC")) {
            ventanaAd.consultarEspectaculoEspec();
        } else if (accion.equals("CONS_ATRACCESPEC")) {
            ventanaAd.consultarAtraccionEspec();
        } else if (accion.equals("CONS_ESPEC")) {
            ventanaAd.consultarEspectaculoEspec();
        } else if (accion.equals("CONS_ATRACC")) {
            ventanaAd.consultarAtracciones();
        }
	}
}
