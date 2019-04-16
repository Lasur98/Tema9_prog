package tanda1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio1 extends JFrame implements ActionListener{
	
	private JLabel lbltexto;
	private JTextArea areatxt;
	private JButton vaciar,mayusculas,invertir;
	private tipoMayus mayus;
	
	public Ejercicio1()
	{
		mayus=new tipoMayus(this);
		setTitle("Probando....");
		
		//Zona Norte
		JPanel panelNorte=new JPanel();
		lbltexto=new JLabel("Escriba aqui el texto:");
		panelNorte.add(lbltexto);
		
		//Zona Centro
		JPanel panelCentro=new JPanel();
		JScrollPane scroll=new JScrollPane(areatxt=new JTextArea(10,15),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelCentro.add(scroll);
		
		//Zona Sur
		JPanel panelSur=new JPanel();
		vaciar=new JButton("VACIAR");
		mayusculas=new JButton("MAYUSCULAS");
		invertir=new JButton("INVERTIR");
		panelSur.add(vaciar);
		panelSur.add(mayusculas);
		panelSur.add(invertir);
		
		
		
		//Añadir las zonas a la ventana principal
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro, "Center");
		this.getContentPane().add(panelSur, "South");
		
		
		//Tratado de eventos
		tratarEventos();
		
		setSize(320,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void tratarEventos() {
		
		vaciar.addActionListener(this);
		invertir.addActionListener(this);
		mayusculas.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vaciar)
		{
			areatxt.setText("");
		}
		if(e.getSource()==invertir)
		{
			String texto=areatxt.getText();
			String texto2="";
			for(int i=texto.length()-1;i>=0;i--)
			{
				texto2+=texto.charAt(i);
			}
			areatxt.setText(texto2);
		}
		
		if(e.getSource()==mayusculas)
		{
			
			mayus.setVisible(true);
		}
		
	}

	
	
	public String getAreatxt() {
		return areatxt.getText();
	}

	

	public void setAreatxt(String texto) {
		areatxt.setText(texto);
	}


	public static void main(String[] args) {
		
		new Ejercicio1();
	}


	

}
