package tanda1;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VisorFichTexto extends JFrame implements ActionListener{
	
	private JTextField txtDirectorio;
	private JComboBox comboFicheros;
	private TextArea areaTexto;
	private JButton botonReset;
	
	
	public VisorFichTexto()
	{
		setTitle("VISOR DE FICHEROS DE TEXTO");
		setLayout(null);
		
		//Adicion y creacion de txtDirectorio
		txtDirectorio=new JTextField(20);
		txtDirectorio.setBounds(20, 20, 150, 30);
		this.getContentPane().add(txtDirectorio);
		
		//Adicion y creacion de comboFicheros
		comboFicheros=new JComboBox();
		comboFicheros.setEnabled(false);
		comboFicheros.setBounds(20, 70, 120, 30);
		this.getContentPane().add(comboFicheros);
		
		//Adicion y creacion del area de texto
		areaTexto=new TextArea();
		JScrollPane scroll=new JScrollPane(areaTexto);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		areaTexto.setBounds(170, 70, 200, 250);
		areaTexto.setEditable(false);
		this.getContentPane().add(areaTexto);
		
		
		//Adicion y creacion del boton resetar
		botonReset=new JButton("RESETEAR");
		botonReset.setBounds(150, 350, 100, 50);
		this.getContentPane().add(botonReset);
		
		tratarEventos();
		
		setSize(400,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void tratarEventos() 
	{
		txtDirectorio.addActionListener(this);
		comboFicheros.addActionListener(this);
		botonReset.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==txtDirectorio)
		{
			File f=new File(txtDirectorio.getText());
			if(!f.exists())
			{
				JOptionPane.showMessageDialog(null, "Directorio invalido");
			}
			else
			{
				comboFicheros.setEnabled(true);
				String[] array=f.list();
				comboFicheros.removeAllItems();
				for(int i=0;i<array.length;i++)
				{
					comboFicheros.addItem(array[i]);
				}
			}
		}
		
		if(e.getSource()==comboFicheros)
		{
			String fichero=(String) comboFicheros.getSelectedItem();
			if(fichero!=null)
			{
				String pal1=fichero.substring(fichero.indexOf("."),fichero.length());
				if(pal1.equals(".txt") || pal1.equals(".doc"))
				{
					try 
					{
						String ruta=txtDirectorio.getText()+"\\"+fichero;
						areaTexto.setText("");
						BufferedReader br=new BufferedReader(new FileReader(ruta));
						String linea=br.readLine();
						while(linea!=null)
						{
							areaTexto.setText(linea);
							linea=br.readLine();
						}
						
						
						br.close();
					} 
					catch (IOException e1) 
					{
						System.err.println("Fichero invalido");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Solo se puede visualizar ficheros de texto");
				}
			}
		}
		
		if(e.getSource()==botonReset)
		{
			comboFicheros.removeAllItems();
			comboFicheros.setEnabled(false);
			txtDirectorio.setText("");
			areaTexto.setText("");
			
		}
		
	}

	public static void main(String[] args) {
		
		new VisorFichTexto();
	}

	

}
