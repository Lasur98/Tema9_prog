package tanda1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EcuGrafica extends JFrame implements ActionListener{


	private JTextField grado2,grado1,terIndependiente;
	private JLabel x2,x,cero;
	private JButton resolver;
	private JLabel sol1,sol2;
	
	public EcuGrafica()
	{
		setTitle("Ecuacion de segundo grado");
		
		//Panel Norte
		JPanel panelNorte=new JPanel();
		grado2=new JTextField(8);
		grado1=new JTextField(8);
		terIndependiente=new JTextField(8);
		x2=new JLabel("x2 + ");
		x=new JLabel("x + ");
		cero=new JLabel("=0");
		panelNorte.add(grado2);
		panelNorte.add(x2);
		panelNorte.add(grado1);
		panelNorte.add(x);
		panelNorte.add(terIndependiente);
		panelNorte.add(cero);
		
		//Panel Centro
		JPanel panelCentro=new JPanel();
		resolver=new JButton("RESOLVER");
		panelCentro.add(resolver);
		
		//Panel Sur
		JPanel panelSur=new JPanel();
		sol1=new JLabel("Solucion 1: ");
		sol2=new JLabel("Solucion 2: ");
		panelSur.add(sol1);
		panelSur.add(sol2);
		
		
		//Adicion de los paneles a la ventana principal
		this.getContentPane().add(panelNorte,"North");
		this.getContentPane().add(panelCentro,"Center");
		this.getContentPane().add(panelSur,"South");
		
		tratarEventos();
		
		setSize(400,180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void tratarEventos() 
	{
		
		resolver.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			int a=Integer.parseInt(grado2.getText());
			int b=Integer.parseInt(grado1.getText());
			int c=Integer.parseInt(terIndependiente.getText());
			
			double sol1,sol2;
			double raiz;
			raiz=((b*b)-(4*a*c));
			if(raiz<0)
			{
				JOptionPane.showMessageDialog(null, new RaizException("Raiz negativa"));
				grado2.setText("");
				grado1.setText("");
				terIndependiente.setText("");
			}
			else
			{
				raiz=Math.sqrt(raiz);
				sol1=(-b+raiz)/(2*a);
				sol2=(-b-raiz)/(2*a);
				
				this.sol1.setText("Solucion 1: "+sol1);
				this.sol2.setText("Solucion 2: "+sol2);
			}
			
			
		} 
		catch (NumberFormatException e1) 
		{
			JOptionPane.showMessageDialog(null, "Debes rellenar con 3 enteros");
			grado2.setText("");
			grado1.setText("");
			terIndependiente.setText("");
		}
		
		
	}

	public static void main(String[] args) {
		
		new EcuGrafica();
	}



}
