package eventos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana2 extends JFrame implements ActionListener{
	
	private JComboBox ficheros;
	private JLabel lblnomficheros;
	private JCheckBox[] numeros;
	private JButton suma,vacio;
	private JLabel sumatorio;
	private JTextArea texto;
	private JList puntos;
	
	public Ventana2()
	{
		
		//Zona Norte
		JPanel panelNorte=new JPanel();
		texto=new JTextArea(10,10);
		JScrollPane scroll=new JScrollPane(texto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		vacio=new JButton("Vaciar");
		File f=new File("ficheros");
		String[] fich=f.list();
		ficheros=new JComboBox();
		for(int i=0;i<fich.length;i++)
		{
			String ruta="ficheros/"+fich[i];
			ficheros.addItem(fich[i]);
		}
		panelNorte.add(ficheros);
		panelNorte.add(scroll);
		panelNorte.add(vacio);
		//Zona Sur
		JPanel panelSur=new JPanel();
		Punto[] points={new Punto(1,0),new Punto(2,4),new Punto(5,2),new Punto(8,3),new Punto(10,4),new Punto(27,13)};
		puntos=new JList(points);
		panelSur.add(puntos);
		
		
		
		
		//Zona Este
		JPanel panelEste=new JPanel();
		panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
		numeros=new JCheckBox[5];
		String[] nums={"10","20","30","40","50"};
		for(int i=10,cont=0;i<=50;i+=10,cont++)
		{
			JCheckBox numero=new JCheckBox(nums[cont]);
			numeros[cont]=numero;
			panelEste.add(numeros[cont]);
		}
		suma=new JButton("Sumar");
		sumatorio=new JLabel();
		suma.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int suma=0;
				for(int i=0;i<numeros.length;i++)
				{
					if(numeros[i].isSelected())
					{
						suma+=Integer.parseInt(numeros[i].getText());
					}
				}
				
				sumatorio.setText(String.valueOf(suma));
			}
		}
		);
		panelEste.add(suma);
		panelEste.add(sumatorio);

		//Situar paneles en contenedor pricipal
		this.getContentPane().add(panelNorte,BorderLayout.NORTH);
		this.getContentPane().add(panelEste,BorderLayout.WEST);
		this.getContentPane().add(panelSur,BorderLayout.SOUTH);
		
		tratarEventos();
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void tratarEventos()
	{
		ficheros.addActionListener(this);
		vacio.addActionListener(this);
		this.puntos.addMouseListener(new MouseListener() {
			
			private final static double MARGEN=0;
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {	}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount()==2)
				{
					//Llega aqui al hacer doble click en un elemento de la lista
					Punto p1=(Punto) puntos.getSelectedValue();
					Punto p2=Punto.puntoAlAzar();
					double distOk=p1.distanciaA(p2);
					String strdistanciaResp=JOptionPane.showInputDialog("Distancia entre "+p1.toString()+" y "+p2.toString());
					
					if(strdistanciaResp!=null)
					{
						int  distanciaResp=Integer.parseInt(strdistanciaResp);
						if(distanciaResp>=distOk && distanciaResp<=distOk+MARGEN)
						{
							JOptionPane.showMessageDialog(null,"Correcto!! La distancia exacta es "+distanciaResp);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error!! La distancia exacta es "+distOk);
						}
					}
					
				}
				
			}
		});
		
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		//Viene al elegir elemento del combo
		JComboBox combo=(JComboBox) arg0.getSource();
		String fich=(String) combo.getSelectedItem();
		try 
		{
			BufferedReader br=new BufferedReader(new FileReader("ficheros/"+fich));
			String linea=br.readLine();
			while(linea!=null)
			{
				texto.setText(texto.getSelectedText()+"\n"+linea);
				linea=br.readLine();
			}
			br.close();
		} 
		catch (IOException e) 
		{
			System.err.println(e.getMessage());
		}
		
		if(arg0.getSource()==vacio)
		{
			this.texto.setText("");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		new Ventana2();

	}



}
