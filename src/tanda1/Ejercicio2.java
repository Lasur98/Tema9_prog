package tanda1;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio2 extends JFrame implements ActionListener{
	
	private JComboBox imagenesCombo;
	private JLabel lblimagen;
	private JTextField comentario;
	private JRadioButton guardado;
	private JButton guardar;
	
	
	public Ejercicio2()
	{
		String contrasenya="damocles";
		String respuesta=JOptionPane.showInputDialog("Introduzca contraseña");
		if(contrasenya.equals(respuesta))
		{
			this.setLayout(null);
			
			//Instanciado el comboBox y su posicion
			String[] img=cargar_combo();
			imagenesCombo=new JComboBox(img);
			imagenesCombo.setBounds(20, 20, 150,50);
			this.getContentPane().add(imagenesCombo);
			
			//Instanciado el JLabel y posicion de la imagen
			
			lblimagen=new JLabel();
			lblimagen.setIcon(redim("imagenes/"+img[0]));
			lblimagen.setBounds(20, 40, 150, 300);
			this.getContentPane().add(lblimagen);
			
			//Instanciar el JRadioButton y su posicion
			guardado=new JRadioButton("Guardar comentario");
			guardado.setSelected(true);
			guardado.setBounds(20,300,150,50);
			this.getContentPane().add(guardado);
			
			//Instanciar el cuadro de texto y poner la posicion
			comentario=new JTextField(50);
			comentario.setBounds(300, 300, 150, 30);
			this.getContentPane().add(comentario);
			
			//Intanciar el boton guardar y su posicion
			guardar=new JButton("GUARDAR");
			guardar.setBounds(200, 350, 100, 30);
			this.getContentPane().add(guardar);
			
			this.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					JOptionPane.showMessageDialog(null, "Adios");
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			tratarEventos();
			setSize(500,450);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	
	private String[] cargar_combo() {
		File imagen=new File("imagenes");
		String[] array=imagen.list();
		return array;
	}

	private void tratarEventos() {

		imagenesCombo.addActionListener(new EscuchadorCombo());
		guardar.addActionListener(this);
		
	}
	
	class EscuchadorCombo implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==imagenesCombo)
			{
				lblimagen.setIcon(redim("imagenes/"+imagenesCombo.getSelectedItem()));
			}
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try 
		{
			String nombre=imagenesCombo.getSelectedItem().toString();
			nombre=nombre.substring(0, nombre.indexOf("."));
			PrintWriter pw=new PrintWriter(new FileWriter(nombre+".txt"));
			pw.println(imagenesCombo.getSelectedItem()+" ");
			if(guardado.isSelected())
			{
				pw.println(comentario.getText());
			}
			pw.close();
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	private ImageIcon redim (String fichImag)
	{
	            ImageIcon imIcon=new ImageIcon(fichImag);

	            Image im=imIcon.getImage();

	            Image im2= im.getScaledInstance(500, 220, 0);

	            return new ImageIcon(im2);


	}
	
	
	public static void main(String[] args) {
		
		new Ejercicio2();
	}

	


}
