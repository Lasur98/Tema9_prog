package modelos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class VentanaPedido extends JFrame{
	
	private JComboBox<String> comboTipos;
	private JList<String> lstPlatos;
	private JList<PedidoProd> lstPedido;
	private JButton botAnyadir,botGuardar;
	private LinkedHashMap<String, String[]> mapaPlatos;
	private DefaultListModel modeloPlatos,modeloPedidos;
	private JButton vaciar;
	
	public VentanaPedido()
	{
		crearMapa();
		dibujar();
		tratarEventos();
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void tratarEventos() 
	{
		comboTipos.addActionListener(new EscuchadorComboTipos());
		botAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Plato=lstPlatos.getSelectedValue();
				
				if(Plato==null)
				{
					JOptionPane.showMessageDialog(null,"Debes seleccionar plato!");
				}
				else
				{
					String unidades=JOptionPane.showInputDialog("Cuantas unidades de "+Plato+" quieres?");
					try
					{
						int uds=Integer.parseInt(unidades);
						PedidoProd pp=new PedidoProd(Plato, uds);
						
						if(!modeloPedidos.contains(pp))
							modeloPedidos.addElement(pp);
						else
						{
							//Coger en el modelo la referencia del PedidoProd con el  mismo nombre
							int iAnterior=modeloPedidos.indexOf(pp);
							PedidoProd ppAnterior=(PedidoProd) modeloPedidos.elementAt(iAnterior);
							//Sumar cantida anteior + nueva cantidad
							int totalUds=ppAnterior.getCantidad()+uds;
							//Sustituir PedidoProd por uno nuevo con la cantidad total
							modeloPedidos.set(iAnterior, new PedidoProd(Plato, totalUds));
						}
					}
					catch (Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Debes introducir un numero");
					}
				}
			}
		});
		
		botGuardar.addActionListener(new GuardarPedidoListener(modeloPedidos,"pedido.txt"));
		vaciar.addActionListener(new VaciarPedidoListener(this));
	}
	
	public void vaciarPedido()
	{
		modeloPedidos.removeAllElements();
	}
	
	class EscuchadorComboTipos implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			cargarPlatosTipo((String) comboTipos.getSelectedItem());
			
		}
		
	}

	private void crearMapa() 
	{
		mapaPlatos=new LinkedHashMap<String,String[]>();
		mapaPlatos.put("Primero", new String[]{"Alubias","Garbanzos","Sopa","Pasta"});
		mapaPlatos.put("Segundo", new String[]{"Lubina al horno","San Jacobo","Merluza"});
		mapaPlatos.put("Postre", new String[]{"Flan","Goxua","Tarta de manzana"});
		
	}

	private void dibujar() 
	{
		//layout por defecto:BorderLayout
		
		DefaultComboBoxModel<String> modeloCombo=new DefaultComboBoxModel<String>();
		Iterator<String> it=mapaPlatos.keySet().iterator();
		while(it.hasNext())
		{
			String clave=it.next();
			modeloCombo.addElement(clave);
		}
		
		comboTipos=new JComboBox(modeloCombo); //Podria basarse tambien en un array
		
		//Zona Centro
		JPanel panelCentro=new JPanel(new FlowLayout());
		
		//Zona Sur
		JPanel panelSur=new JPanel(new GridLayout(2,1));
		botGuardar=new JButton("Guardar pedido");
		vaciar=new JButton("Vaciar pedido");
		panelSur.add(botGuardar);
		panelSur.add(vaciar);
		
		//Instanciamos los modelos de lista
		modeloPlatos=new DefaultListModel();
		cargarPlatosTipo("Primero");
		
		modeloPedidos=new DefaultListModel();
		
		lstPlatos=new JList<String>(modeloPlatos);
		botAnyadir=new JButton(">>");
		lstPedido=new JList<PedidoProd>(modeloPedidos);
		
		lstPlatos.setPreferredSize(new Dimension(150, 200));
		lstPedido.setPreferredSize(new Dimension(150, 200));
		panelCentro.add(lstPlatos);
		panelCentro.add(botAnyadir);
		panelCentro.add(lstPedido);
		
		//Añadir al panel
		this.getContentPane().add(comboTipos,"North");
		this.getContentPane().add(panelCentro,"Center");
		this.getContentPane().add(panelSur, "South");
		
	}

	private void cargarPlatosTipo(String tipo) {
		
		modeloPlatos.removeAllElements();
		String[] platos=mapaPlatos.get(tipo);
		for(int i=0;i<platos.length;i++)
		{
			modeloPlatos.addElement(platos[i]);
		}
	}

	public static void main(String[] args) {
		
		new VentanaPedido();
	}

}
