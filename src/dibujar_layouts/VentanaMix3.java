package dibujar_layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaMix3 extends JFrame{
	
	JButton[] boton_meses;
	
	public VentanaMix3()
	{
		//Zona Norte
		JPanel panelNorte=new JPanel();
		JLabel lblnumero=new JLabel();
		int[] array=new int[3];
		String suma="";
		for(int i=0;i<3;i++)
		{
			int aleatorio=(int)(Math.random()*101+1);
			for(int i2=i;i2<array.length;i2++)
			{
				if(array[i2]==aleatorio)
				{
					aleatorio=(int)(Math.random()*101+1);
					i2=i;
				}
			}
			suma+=(aleatorio+" + ");
		}
		suma=suma.substring(0, suma.length()-2);
		lblnumero.setText(suma);
		panelNorte.add(lblnumero);
		JButton sumar=new JButton("Sumar");
		panelNorte.add(sumar);
		JTextField resultado=new JTextField(5);
		panelNorte.add(resultado);
		
		
		//Zona Sur
		JPanel panelSur=new JPanel();
		String[] ciudades={"Madrid","Barcelona","Bilbao","Miranda","Vitoria"};
		JList lista=new JList(ciudades);
		panelSur.add(lista);
		JButton borrado=new JButton("Borrar");
		panelSur.add(borrado);
		
		//Zona Oeste
		JPanel panelOeste=new JPanel(new BorderLayout());
		String[] meses={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
		boton_meses=new JButton[meses.length];
		for(int i=0;i<meses.length;i++)
		{
			JButton mes=new JButton(meses[i]);
			boton_meses[i]=mes;
			panelOeste.add(boton_meses[i]);
		}
		
		//Zona Centro
		
		//Zona Este
		
		//Situar paneles en contenedor pricipal
		this.getContentPane().add(panelNorte,BorderLayout.NORTH);
		this.getContentPane().add(panelSur,BorderLayout.SOUTH);
		this.getContentPane().add(panelOeste,BorderLayout.WEST);
		
		
		
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {

		new VentanaMix3();

	}

}
