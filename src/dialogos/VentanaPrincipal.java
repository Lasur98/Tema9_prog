package dialogos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private JComboBox<String> comboRutas;
	private DefaultComboBoxModel<String> modeloCombo;
	private JLabel lblimagen;
	private JButton botDuplicar;
	private DialogoDuplicado dialDupli;
	
	public VentanaPrincipal()
	{
		dialDupli=new DialogoDuplicado(this);
		
		setTitle("IMAGENES");
		//Layout por defecto: BorderLayout
		
		iniciarModelo();
		comboRutas=new JComboBox<String>(modeloCombo);
		
		lblimagen=new JLabel();
		lblimagen.setBackground(Color.blue);
		lblimagen.setOpaque(true);
		
		botDuplicar=new JButton("Duplicar");
		
		//Listener
		comboRutas.addActionListener(this);
		botDuplicar.addActionListener(this);
		
		this.getContentPane().add(comboRutas, "North");
		this.getContentPane().add(lblimagen,"Center");
		this.getContentPane().add(botDuplicar,"South");
		
		setSize(200,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void iniciarModelo() {
		
		modeloCombo=new DefaultComboBoxModel<String>();
		modeloCombo.addElement("img/1.jpg");
		modeloCombo.addElement("img/2.jpg");
		modeloCombo.addElement("img/3.jpg");
		modeloCombo.addElement("img/4.jpg");
		modeloCombo.addElement("img/5.jpg");
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==comboRutas)
		{
			DialogoPass dp=new DialogoPass(this); //Modal! Toma el control
			
			//Llega si se ha acertado la contraseña(se ha hecho invisible la ventana de dialogo)
			ImageIcon ii=new ImageIcon((String) comboRutas.getSelectedItem());
			lblimagen.setIcon(ii);
		}
		if(arg0.getSource()==botDuplicar)
		{
			dialDupli.setVisible(true);
		}
		
	}
	
	
	public JComboBox<String> getComboRutas() {
		return comboRutas;
	}

	public static void main(String[] args) {
		
		new VentanaPrincipal();

	}

	

}
