package repaso;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Concurso extends JFrame{
	
	private JList lstPreguntas;
	private DefaultListModel modeloLista;
	private JLabel lblAciertos;
	private int aciertos;
	
	public Concurso()
	{
		aciertos=0;
		
		//Dibujar
		JPanel panelNorte=new JPanel();
		panelNorte.add(new JLabel("CONCURSO"));
		this.getContentPane().add(panelNorte,"North");
		
		JScrollPane panCentro=new JScrollPane();
		cargarPreguntas();
		lstPreguntas=new JList(modeloLista);
		panCentro.setViewportView(lstPreguntas);
		panCentro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panCentro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(panCentro, "Center");
		
		
		JPanel panelSur=new JPanel();
		panelSur.add(lblAciertos=new JLabel(aciertos+" aciertos"));
		this.getContentPane().add(panelSur, "South");
		
		//Escuchar Mouse en lista
		lstPreguntas.addMouseListener(new EscuchadorLista());
		
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void cargarPreguntas() {
		
		modeloLista=new DefaultListModel<Pregunta>();
		modeloLista.addElement(new Pregunta("2+2",new String[]{"22","5","4"},2));
		modeloLista.addElement(new Pregunta("Capital de Libano",new String[]{"Acra","Beirut"},1));
		modeloLista.addElement(new Pregunta("Director de psicosis",new String[]{"Hitchcock","Newman","Ford"},0));
		modeloLista.addElement(new Pregunta("Factorial de 1",new String[]{"1","2","-1","0"},0));
		
	}
	
	public void acertar()
	{
		aciertos++;
		lblAciertos.setText(aciertos+" aciertos");
		modeloLista.removeElement(lstPreguntas.getSelectedValue());
	}

	class EscuchadorLista extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getClickCount()==2)
			{
				DialogoPregunta dp=new DialogoPregunta((Pregunta) lstPreguntas.getSelectedValue());
				if(dp.isAcertado())
				{
					acertar();
				}
				dp.dispose();
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		new Concurso();
		
	}

}
