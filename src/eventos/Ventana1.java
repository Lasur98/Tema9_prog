package eventos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Ventana1 extends JFrame implements ActionListener{
	
	private JButton bot;
	private JComboBox combonums;
	private JRadioButton[] radios;
	private JLabel lblSaludo;
	private JButton botonCerrar;

	public Ventana1(String titulo)
	{
		//Dibujar
		this.setLayout(new FlowLayout());
		bot=new JButton("Dar color");
		this.getContentPane().add(bot);
		
		combonums=new JComboBox(new Integer[]{4,5,6,7});
		this.getContentPane().add(combonums);
		
		ButtonGroup bg=new ButtonGroup();
		int num=10;
		radios=new JRadioButton[5];
		for(int i=0;i<radios.length;i++)
		{
			radios[i]=new JRadioButton(num+"");
			num+=2;
			this.getContentPane().add(radios[i]);
			bg.add(radios[i]);
			radios[i].addActionListener(new MiRadioListener());
		}
		
		lblSaludo=new JLabel("Buenos Dias");
		this.getContentPane().add(lblSaludo);
		
		botonCerrar=new JButton("Cerrar");
		this.getContentPane().add(botonCerrar);
		
		tratarEventos();
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	private void tratarEventos()
	{
		//Al pinchar el boton cambiar el color de fondo
		
		bot.addActionListener(this);
		combonums.addActionListener(new miComboListener());
		botonCerrar.addActionListener
				(
				
					new ActionListener() 
					{
						
						public void actionPerformed(ActionEvent e) 
						{
							JOptionPane.showMessageDialog(null, "Hasta luego");
							dispose();
							
						}
					}
				
				);
		
		this.addMouseListener(
				new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(e.getClickCount()==2)
						{
							JOptionPane.showMessageDialog(null, "Hasta luego");
							dispose();
						}
						
					}
				}
				);
		
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		/*String color=JOptionPane.showInputDialog("Color a asignar:");
		if(color!=null)
		{
			this.setBackground(Color.CYAN);
		}*/
		this.getContentPane().setBackground(Color.CYAN);
		
	}
	
	class MiRadioListener implements ActionListener
	{


		public void actionPerformed(ActionEvent e) 
		{
			for(int i=0;i<radios.length;i++)
			{
				if(radios[i].isSelected())
				{
					int tamLetra=Integer.parseInt(radios[i].getText());
					lblSaludo.setFont(new Font("Arial",Font.BOLD, tamLetra));
					break;
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Ventana1("Prueba Eventos");
	}


	
}
