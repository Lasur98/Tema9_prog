package dibujar_layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaMix extends JFrame{
	
	private JCheckBox check1,check2;
	private JRadioButton[] radios;
	
	public VentanaMix()
	{
		this.setLayout(new BorderLayout());//Como no poner nada porque es el layout por defecto
		
		//Zona norte
		JPanel panelNorte=new JPanel();
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER));
		check1=new JCheckBox("Fotografo 1");
		check2=new JCheckBox("Fotografo 2");
		panelNorte.add(check1);
		panelNorte.add(check2);
		
		//Zona centro
		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(3,3));
		
		for(int cont=1;cont<=9;cont++)
		{
			String ruta="img/"+cont+".jpg";
			JLabel lblImagen=new JLabel(new ImageIcon(ruta));
			panelCentro.add(lblImagen);
		}
		
		//Zona east
		JPanel panEste=new JPanel();
		panEste.setLayout(null);
		panEste.setPreferredSize(new Dimension(200,0));
		radios=new JRadioButton[5];
		for(int i=0,y=10;i<radios.length;i++,y+=20)
		{
			radios[i]=new JRadioButton("Radio "+(i+1));
			radios[i].setBounds(10, y,100, 15);
			panEste.add(radios[i]);
		}
		
		
		//Zona sur
		JPanel panelSur=new JPanel();
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));
		panelSur.add(new JButton("Boton 1"));
		panelSur.add(new JButton("Boton 2"));
		panelSur.add(new JButton("Boton 3"));
		panelSur.add(new JButton("Boton 4"));
		panelSur.add(new JButton("Boton 5"));
		
		
		//Situar paneles en contenedor pricipal
		this.getContentPane().add(panelNorte,BorderLayout.NORTH);
		this.getContentPane().add(panelCentro,BorderLayout.CENTER);
		this.getContentPane().add(panEste,BorderLayout.EAST);
		this.getContentPane().add(panelSur,BorderLayout.SOUTH );
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new VentanaMix();
	}

}
