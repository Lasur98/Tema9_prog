package dialogos;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DialogoDuplicado extends JDialog{
	
	private JRadioButton radiosByte,radioBloque;
	private JTextField txtNombreCopia;
	private VentanaPrincipal owner;
	
	public DialogoDuplicado(VentanaPrincipal owner)
	{
		this.owner=owner;
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		
		this.getContentPane().add(radiosByte=new JRadioButton("Byte a byte"));
		this.getContentPane().add(radioBloque=new JRadioButton("En bloque"));
		ButtonGroup bg=new ButtonGroup();
		bg.add(radiosByte);
		bg.add(radioBloque);
		
		this.getContentPane().add(new Label("Introduce nombre de imagen copia"));
		this.getContentPane().add(txtNombreCopia=new JTextField());
		
		
		txtNombreCopia.addActionListener(new CopiaListener());
		setModal(false);
		setSize(300,300);
		setVisible(false);
	}

	class CopiaListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!radioBloque.isSelected() && !radiosByte.isSelected()|| (txtNombreCopia.getText().equals("")))
			{
				JOptionPane.showMessageDialog(null, "Selecciona 1 radio y escribe el nombre del archivo");
			}
			
			String nomFich=(String) owner.getComboRutas().getSelectedItem();
			String nomCopia=txtNombreCopia.getText();
			
			if(radioBloque.isSelected())
			{
				
				try {
					FileInputStream fis=new FileInputStream(nomFich);
					int tam=fis.available();
					byte[] buffer=new byte[tam];
					fis.read(buffer);
					fis.close();
					
					FileOutputStream fos=new FileOutputStream(nomCopia);
					fos.write(buffer);
					fos.close();
				} 
				catch (FileNotFoundException e1) 
				{
					System.out.println("Error copiando fichero en bloque");
				} catch (IOException e1) {
					System.out.println("Error copiando fichero en bloque");
				}
				finally
				{
					setVisible(false);
				}
			}
			
			if(radiosByte.isSelected())
			{
				try {
					FileInputStream fis=new FileInputStream(nomFich);
					FileOutputStream fos=new FileOutputStream(nomCopia);
					
					while(fis.available()>0)
					{
						int byteleido=fis.read();
						fos.write(byteleido);
					}
					
					fis.close();
					fos.close();
				} 
				catch (FileNotFoundException e1) 
				{
					System.out.println("Error copiando fichero en bloque");
				} catch (IOException e1) {
					System.out.println("Error copiando fichero en bloque");
				}
				finally
				{
					setVisible(false);
				}
			}
			
		}
		
	}
	
}
