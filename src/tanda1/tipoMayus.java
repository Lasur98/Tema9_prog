package tanda1;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class tipoMayus extends JDialog{
	
	private JRadioButton[] botones;
	private JLabel lbltexto;
	
	public tipoMayus()
	{
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
		
		botones[1]=new JRadioButton("Mayuscula al comienzo de cada frase");
		bg.add(botones[1]);
		panelNorte.add(botones[1]);
		
		botones[2]=new JRadioButton("Mayusculas Al Comienzo De Cada Palabra");
		bg.add(botones[2]);
		panelNorte.add(botones[2]);
		
		
		
		this.getContentPane().add(panelNorte, "North");
		
		setModal(true);
		setSize(300,200);
		setVisible(false);
	}

}
