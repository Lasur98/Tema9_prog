package dibujarnull;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import org.w3c.dom.ls.LSLoadEvent;

public class VentanaPato extends JFrame{

	private JList lstPatos;
	private JCheckBox[] checkComidas;
	private JRadioButton[] radioTipos;
	
	public VentanaPato()
	{
		
		this.dibujar();
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void dibujar()
	{
		this.setLayout(null);
		
		//Scroll con lista de patos
		final Pato[] patos={new Pato("Donald",80),new Pato("Roger",180),new Pato("Daisy",78),
				new Pato("Donald",80),new Pato("Roger",180),new Pato("Daisy",78)};
		
		lstPatos=new JList(patos);
		JScrollPane scroll=new JScrollPane(lstPatos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(20, 20, 120, 80);
		//lstPatos.setBounds(20, 20, 120, 150);
		this.getContentPane().add(scroll);
		
		/*Conjunto de checboxes en vertical*/
		
		ArrayList<String> comidas=this.comidasFich("comidas.txt");
		this.checkComidas=new JCheckBox[comidas.size()];
		int i=0; 
		int y=20;
		for(String comida:comidas)
		{
			checkComidas[i]=new JCheckBox(comida);
			checkComidas[i].setBounds(200,y,100,20);
			this.getContentPane().add(checkComidas[i]);
			y+=25;
			i++;
		}
		
		/*Conjunto de radios con tipos de comida: desayuno,comida,cena...*/
		ButtonGroup bg=new ButtonGroup();
		JPanel panRadios=new JPanel();
		panRadios.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		final String[] tipos={"Desayuno","Comida","Cena","Aperitivo"};
		radioTipos=new JRadioButton[tipos.length];
		for(int i2=0;i2<tipos.length;i2++)
		{
			radioTipos[i2]=new JRadioButton(tipos[i2]);
			bg.add(radioTipos[i2]);
			panRadios.add(radioTipos[i2]);
		}
		
		this.getContentPane().add(panRadios);
		panRadios.setBounds(20, 350, 450, 80);
	}
	
	private ArrayList<String> comidasFich(String nomfich)
	{
		ArrayList<String> comidas=new ArrayList<String>();
		try 
		{
			BufferedReader br=new BufferedReader(new FileReader(nomfich));
			String linea=br.readLine();
			while(linea!=null)
			{
				comidas.add(linea);
				linea=br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error acceso fichero");
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			return comidas;
		}
	}
	
	public static void main(String[] args) {
		
		new VentanaPato();
	}
	
}
