package ejercicios;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio1 extends JFrame implements MouseListener{
	
	private JComboBox comboNomFich;
	private JList lstPuntos;
	private DefaultListModel<Punto> modeloPuntos;
	private JLabel lblTexto;
	private JTextField txtDistancia;
	
	public Ejercicio1()
	{
		dibujar();
		tratarEventos();
		
		//setSize(400,400);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void tratarEventos() 
	{
		comboNomFich.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					modeloPuntos.removeAllElements();
					BufferedReader br=new BufferedReader(new FileReader("puntos/"+comboNomFich.getSelectedItem()));
					String linea=br.readLine();
					while(linea!=null)
					{
						String[] array=linea.split(",");
						int x=Integer.parseInt(array[0].substring(1, array[0].length()));
						int y=Integer.parseInt(array[1].substring(0,array[1].length()-1));
						modeloPuntos.addElement(new Punto(x,y));
						linea=br.readLine();
					}
					br.close();
				} 
				catch (IOException e1) 
				{
					System.out.println(e1.getMessage());
				}
				
			}
		});
		
		
		
	}

	private void dibujar() 
	{
		//Zona Este
		JPanel panelEste=new JPanel(new GridLayout(0,1));
		comboNomFich=new JComboBox();
		File f=new File("puntos");
		String[] fichero=f.list();
		for(int i=0;i<fichero.length;i++)
		{
			String ruta="puntos/"+fichero[i];
			comboNomFich.addItem(fichero[i]);
		}
		modeloPuntos=new DefaultListModel<Punto>();
		lstPuntos=new JList(modeloPuntos);
		lstPuntos.setPreferredSize(new Dimension(50,50));
		panelEste.add(comboNomFich);
		panelEste.add(lstPuntos);
		
		
		
		//Zona Norte
		JPanel panelNorte=new JPanel();
		lblTexto=new JLabel("Enter distance ");
		txtDistancia=new JTextField(10);
		
		panelNorte.add(lblTexto);
		panelNorte.add(txtDistancia);
		
		//Añadir al panel 
		this.getContentPane().add(panelEste,"West");
		this.getContentPane().add(panelNorte, "North");
		
		//Escuchador de puntos
		lstPuntos.addMouseListener(this);
		txtDistancia.addActionListener(new DistanceListener());
		
	}
	
	class DistanceListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Punto punto1=(Punto) lstPuntos.getSelectedValue();
			Punto punto2=new Punto(0,0);
			String txt=txtDistancia.getText();
			double dist2=Integer.parseInt(txt);
			double dist=punto1.distanciaA(punto2);
			if(dist==dist2 || dist2-dist<0.2)
			{
				modeloPuntos.removeElement(punto1);
				txtDistancia.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bad distance! Try it again");
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(arg0.getClickCount()==2)
		{
			Punto punto1=(Punto) lstPuntos.getSelectedValue();
			lblTexto.setText("Enter distance from point "+punto1.toString()+" to (0,0)");	
			Punto punto2=new Punto(0,0);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
	
	public static void main(String[] args) {
		
		new Ejercicio1();
	}

	
}
