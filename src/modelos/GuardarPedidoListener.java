package modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

public class GuardarPedidoListener implements ActionListener {
	
	private DefaultListModel<PedidoProd> modelo;
	private String nomFich;

	public GuardarPedidoListener(DefaultListModel modelo,String nomFich) {
		this.modelo=modelo;
		this.nomFich=nomFich;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(nomFich));
			for(int i=0;i<modelo.size();i++)
			{
				pw.println(modelo.getElementAt(i).toString());
			}

			pw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
