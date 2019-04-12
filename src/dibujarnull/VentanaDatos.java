package dibujarnull;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaDatos extends JFrame{
	
	private JComboBox cmbEdades;
	private JTextField txtNombre;
	private JRadioButton radioH;
	private JRadioButton radioM;
	private JButton botGuardar;
	
	public VentanaDatos()
	{
		dibujarVentana();
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private Integer[] arrayEdades()
	{
		Integer[] edades=new Integer[130-18+1];
		for(int edad=18,i=0;edad<=130;i++,edad++)
		{
			edades[i]=edad;
		}
		return edades;
	}
	
	private void dibujarVentana()
	{
		this.setLayout(null);
		
		//Instanciar las propiedades principales
		cmbEdades=new JComboBox(arrayEdades());
		txtNombre=new JTextField();
		radioH=new JRadioButton("Hombre",true);
		radioM=new JRadioButton("Mujer",false);
		ButtonGroup bg=new ButtonGroup();
		bg.add(radioH);
		bg.add(radioM);
		
		
		botGuardar=new JButton("Guardar");
		
		//Situar componentes
		
		JLabel lblEdad=new JLabel("Introduce edad: ");
		lblEdad.setBounds(20, 20, 100, 20);
		cmbEdades.setBounds(140, 20, 100, 20);
		
		JLabel lblNombre=new JLabel("Nombre: ");
		lblNombre.setBounds(300, 20, 100, 20);
		txtNombre.setBounds(450, 20, 100, 20);
		
		JLabel lblSexo=new JLabel("Sexo: ");
		lblSexo.setBounds(20, 100, 100, 20);
		radioH.setBounds(140, 100, 100, 20);
		radioM.setBounds(140, 140, 100, 20);
		
		botGuardar.setBounds(250, 300, 100, 20);
		
		//Añadir componentes al panel principal
		this.getContentPane().add(lblEdad);
		this.getContentPane().add(txtNombre);
		this.getContentPane().add(cmbEdades);
		this.getContentPane().add(lblNombre);
		this.getContentPane().add(lblSexo);
		this.getContentPane().add(radioH);
		this.getContentPane().add(radioM);
		this.getContentPane().add(botGuardar);
		
		
	}
	
	public static void main(String[] args) {
		
		new VentanaDatos();
	}

}
