package ejercicios;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VentanaPrincipal extends JFrame{
	
	private JLabel lblnombre;
	private JButton[] tablasmulti;
	private ArrayList<JLabel> iconos;
	
	public VentanaPrincipal()
	{
		setTitle("Multiplying tables");
		
		//Zona norte
		JPanel panelNorte=new JPanel();
		lblnombre=new JLabel("Practise multiplying tables");
		lblnombre.setFont(new Font("Arial",Font.BOLD, 18));
		panelNorte.add(lblnombre);
		
		//Zona Centro
		JPanel panelCentro=new JPanel(new GridLayout(0,2));
		tablasmulti=new JButton[8];
		
		iconos=new ArrayList<JLabel>();
		for(int i=2,cont=0;i<=9;i++,cont++)
		{
			JButton multi=new JButton();
			multi.setText(String.valueOf(i));
			iconos.add(new JLabel((redim("aspa_roja.png"))));
			tablasmulti[cont]=multi;
			tablasmulti[cont].addActionListener(new EscuchadorOperMultiplicar(cont));
	
			
			panelCentro.add(tablasmulti[cont]);
			panelCentro.add(iconos.get(cont));
		}
		
		
		
		//Añadir los contenedores a la ventana principal
		this.getContentPane().add(panelNorte, "North");
		this.getContentPane().add(panelCentro,"Center");
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class EscuchadorOperMultiplicar implements ActionListener
	{
		private int numero;
		
		public EscuchadorOperMultiplicar(int cont) {
			
			this.numero=cont;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			int aleatorio=(1+(int)(Math.random()*10));
			int num1=Integer.parseInt(tablasmulti[numero].getText());
			int resul=Integer.parseInt(JOptionPane.showInputDialog(null,num1+" X "+aleatorio));
			if(aleatorio*num1==resul)
			{
				tablasmulti[numero].setEnabled(false);
				JLabel img=new JLabel((redim("ticks2.png")));
				iconos.get(numero).setIcon((redim("ticks2.png")));
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Has fallado");
			}
		}
		
	}
	
	private static ImageIcon redim (String fichImag)
	{
	            ImageIcon imIcon=new ImageIcon(fichImag);

	            Image im=imIcon.getImage();

	            Image im2= im.getScaledInstance(40, 40, 0);

	            return new ImageIcon(im2);


	}
	
	public static void main(String[] args) {
		
		new VentanaPrincipal();
	}

}
