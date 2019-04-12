package modelos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class VentanaModelo extends JFrame{
	
	private JTextField txtNombre;
	private JList lstNombres;
	private DefaultListModel modeloLista;
	
	public VentanaModelo()
	{
		this.setLayout(new FlowLayout());
		
		txtNombre=new JTextField();
		txtNombre.setPreferredSize(new Dimension(100,40));
		crearModeloLista();
		lstNombres=new JList(modeloLista);
		lstNombres.setPreferredSize(new Dimension(200,300));
		
		
		txtNombre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt=txtNombre.getText();
				modeloLista.addElement(txt);
				
			}
		});
		
		lstNombres.addMouseListener(new ListaDCListener());
		
		this.getContentPane().add(txtNombre);
		this.getContentPane().add(lstNombres);
		
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	private void crearModeloLista() {
		modeloLista=new DefaultListModel();
		modeloLista.addElement("Juan");
		modeloLista.addElement("Marta");
		modeloLista.addElement("Jose");
		modeloLista.addElement("Maria");
		
	}

	class ListaDCListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getClickCount()==2)
			{
				modeloLista.removeElement(lstNombres.getSelectedValue());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		new VentanaModelo();
	}

}
