package LoginInterfaz;

import java.awt.*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelCentro extends JPanel implements ActionListener{
	
	private JComboBox<String> combo1;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton butIniciar;
	private VentanaLogin ventanaLo;
	
	
private JPanel crearPanelSuperior () {
	JPanel panel = new JPanel(new GridLayout(2,1));
	panel.add(new JLabel("Seleccione el tipo de usuario: "));
	combo1 = new JComboBox<>(new String[] {"Cliente", "Administrador", "Empleado"});
	panel.add(combo1);
	return panel;
}

private JPanel crearPanelCentro() {
	JPanel panel = new JPanel(new GridLayout(2,2,10,10));
	panel.add(new JLabel("Usuario: "));
	txtUsuario = new JTextField();
	panel.add(txtUsuario);
	panel.add(new JLabel("Contraseña: "));
	txtContraseña= new JPasswordField();
	panel.add(txtContraseña);
	return panel;
}

private crearPanelInferior() {
	JPanel panel = new JPanel();
	butIniciar = new JButton("Iniciar Sesion");
	butIniciar.setActionCommand("INICIAR");
	butIniciar.AddActionListener(this);
	panel.add(butIniciar);
	return panel;
}

public panelCentro(VentanaLogin ventanaLo) {
	this.ventanaLo = ventanaLo;
	setLayout(new BorderLayout(15,15));
	add(crearPanelSuperior(), BorderLayout.NORTH);
	add(crearPanelInferior(), BorderLayout.SOUTH);
	add(crearPanelCentro(), BorderLayout.CENTER);		
}

public String getLogin() {
	return txtUsuario.getText().trim();
}

public String getPassword() {
	return new String(txtPassword.getPassword());
}

public String getTipoUsuario() {
	return (String) combo1.getSelectedItem();
}

public void actionPerformed(ActionEvent e) {
	if("INICIAR".equals(e.getActionCommand())) {
		String usuario = getLogin();
		String contraseña = getPassword();
		StringtipoDeUsuario = getTipoUsuario();
		
		if(!(usuario.length() > 0 && contraseña.length() > 0)) {
		JOptionPane.showMessageDialog(this, "Debe ingresar el usuario y la contraseña:.");
		return;	
		}
		
		switch(tipoUsuario) {
		case "Administrador":
			new VentanaAdmin();
			break;
		case "Empleado":
			new VentanaEmpleado();
			break;
		case "Usuario":
			new VentanaUsuario();
			break;
		default:
			JOptionPane.showMessageDialog(this, "El tipo de usuario no fue reconocido.");
		return;
		}
		
		ventanaLo.dispose();
	}
}
}