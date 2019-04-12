package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class miComboListener implements ActionListener{

	private final static String NOMFICH="fichfact.txt";
	
	public void actionPerformed(ActionEvent e) 
	{
		//Viene aqui cuando se selecciona  algo en el combo de numeros
		
		JComboBox combo=(JComboBox) e.getSource();
		int num=(int) combo.getSelectedItem();
		anyadeLineaAFich(num);
		JOptionPane.showMessageDialog(null, "Factorial añadido a fichero");
		
	}
	
	private long factorial(int num)
	{
		long f=1;
		for(int cont=1;cont<=num;cont++)
		{
			f=f*cont;
		}
		
		return f;
	}

	private void anyadeLineaAFich(int num)
	{
		try
		{
			PrintWriter pw=new PrintWriter(new FileWriter(NOMFICH,true));
			pw.println(num+"!= "+factorial(num));
			pw.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
