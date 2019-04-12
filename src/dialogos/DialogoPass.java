package dialogos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogoPass extends JDialog{
	
	private VentanaPrincipal owner;
	private JPasswordField txtPassword;
	
	public DialogoPass(VentanaPrincipal owner)
	{
		this.owner=owner;
		setModal(true);
		
		//Dibujar
		this.setLayout(new FlowLayout());
		this.add(new JLabel("Introduce password para la imagen "+owner.getComboRutas().getSelectedItem()));
		this.add(txtPassword=new JPasswordField(20));
		
		//Evento al pulsar intro en la caja de texto
		txtPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(txtPassword.getText().equals("123"))
				{
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Password incorrecta");
					txtPassword.setText("");
				}
				
			}
		});
		
		
		setSize(400,200);
		setVisible(true);
	}

}
