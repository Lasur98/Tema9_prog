package dibujar_layouts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaMix2 extends JFrame{
	
	private JCheckBox check;
	
	public VentanaMix2()
	{
		//Zona norte
		JPanel panelNorte=new JPanel();
		panelNorte.setLayout(new GridLayout(2,0));
	//	String[] abecedario={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","U","V","W","X","Y","Z"};
		for(char i='A';i<='Z';i++)
		{
			
			panelNorte.add(new JButton(""+i));
		}
		
		//Zona Oeste
		JPanel panelOeste=new JPanel();
		panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
		File f=new File("img");
		String[] nombres=f.list();
		for(int cont=0;cont<=nombres.length-1;cont++)
		{
			
			String ruta="img/"+nombres[cont];
			JLabel lblImagen=new JLabel((redim(ruta)));
			panelOeste.add(lblImagen);
		}

		
		//Zona Centro
		JTextArea texto=new JTextArea();
		JScrollPane scroll=new JScrollPane(texto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//Zona Sur
		JPanel panelSur=new JPanel();
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		String[] array={"1","2","3","4"};
		
		for(int i=0;i<array.length;i++)
		{
			check=new JCheckBox(array[i]);
			panelSur.add(check);
		}
		
		//Situar paneles en contenedor pricipal
		this.getContentPane().add(panelNorte,BorderLayout.NORTH);
		this.getContentPane().add(panelOeste,BorderLayout.WEST);
		this.getContentPane().add(scroll,BorderLayout.CENTER);
		this.getContentPane().add(panelSur,BorderLayout.SOUTH);
		
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private ImageIcon redim (String fichImag)
	{
	            ImageIcon imIcon=new ImageIcon(fichImag);

	            Image im=imIcon.getImage();

	            Image im2= im.getScaledInstance(40, 40, 0);

	            return new ImageIcon(im2);
	}
	
	public static void main(String[] args) {
		
		new VentanaMix2();
	}

}
