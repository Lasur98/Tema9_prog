package tanda1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class tipoMayus extends JDialog implements ActionListener{
	
	private JRadioButton[] botones;
	private JLabel lbltexto;
	private Ejercicio1 ventanaPrincipal;
	
	public tipoMayus(Ejercicio1 ventanaPrincipal)
	{
		this.ventanaPrincipal=ventanaPrincipal;
		setTitle("Tipo de MAYUSC");
		
		//Zona Centro
		JPanel panelNorte=new JPanel();
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.Y_AXIS));
		panelNorte.setBorder(BorderFactory.createTitledBorder("Elija tipo de alineamiento"));
		ButtonGroup bg=new ButtonGroup();
		botones=new JRadioButton[3];
		
		botones[0]=new JRadioButton("TODO MAYUSCULAS");
		botones[0].setSelected(true);
		bg.add(botones[0]);
		panelNorte.add(botones[0]);
		botones[0].addActionListener(this);
		
		botones[1]=new JRadioButton("Mayuscula al comienzo de cada frase");
		bg.add(botones[1]);
		panelNorte.add(botones[1]);
		botones[1].addActionListener(this);
		
		botones[2]=new JRadioButton("Mayusculas Al Comienzo De Cada Palabra");
		bg.add(botones[2]);
		panelNorte.add(botones[2]);
		botones[2].addActionListener(this);
		
		
		
		this.getContentPane().add(panelNorte, "North");
		
		setModal(true);
		setSize(300,200);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==botones[0])
		{
			String mayusculas=ventanaPrincipal.getAreatxt().toUpperCase();
			ventanaPrincipal.setAreatxt(mayusculas);
		}
		if(arg0.getSource()==botones[1])
		{
			String frase=ventanaPrincipal.getAreatxt();
			String frase2="";
			for(int i=0;i<frase.length()-1;i++)
			{
				int punto=frase.indexOf(".");
				frase2+=frase.substring(0, 0).toUpperCase();
				frase2+=frase.substring(1,punto);
				frase=frase.substring(punto, frase.length());
			}
			ventanaPrincipal.setAreatxt(frase2);
		}
		if(arg0.getSource()==botones[2])
		{
			String frase=ventanaPrincipal.getAreatxt();
			String frase2="";
			for(int i=0;i<frase.length()-1;i++)
			{
				int espacio=frase.indexOf(" ");
				if(espacio>0)
				{
					String palabra=frase.substring(0,espacio);
					frase2+=palabra.substring(0,1).toUpperCase();
					palabra=palabra.substring(1,palabra.length());
					frase2+=palabra+" ";
					frase=frase.substring(espacio+1, frase.length());
				}
				else
				{
					frase2+=frase.substring(0, 1).toUpperCase();
					frase2+=frase.substring(1, frase.length());
				}
			}
			
			ventanaPrincipal.setAreatxt(frase2);
			
		}
		setVisible(false);
	}

}
