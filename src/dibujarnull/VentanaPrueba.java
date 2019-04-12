package dibujarnull;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrueba extends JFrame{
	
	public VentanaPrueba()
	{
		this.setLayout(null); //Dibujar con coordenadas absolutas
		this.setTitle("Mi ventana");
		this.setResizable(false);
		
		JButton bot1=new JButton("Boton 1");
		JLabel lbl1=new JLabel("Introduce tu nombre");
		JTextField txtNombre=new JTextField();
		
		bot1.setBounds(50,50, 100, 30);
		lbl1.setBounds(50, 100, 140, 30);
		txtNombre.setBounds(200, 100, 100, 30);
		txtNombre.setBackground(Color.cyan);
		txtNombre.setFont(new Font("Arial",Font.BOLD,16));
		
		this.getContentPane().add(bot1);
		this.getContentPane().add(lbl1);
		this.getContentPane().add(txtNombre);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(380, 300);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		
		new VentanaPrueba();
	}

}
