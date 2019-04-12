package repaso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class DialogoPregunta extends JDialog{
	
	private Pregunta p;
	private ArrayList<JRadioButton> radiosResp;
	private boolean acertado;
	
	public DialogoPregunta(Pregunta p)
	{
		this.p=p;
		setModal(true);
		
		//Dibujar en vertical
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		
		this.getContentPane().add(new JLabel(p.getPregunta()));
		
		ButtonGroup bg=new ButtonGroup();
		radiosResp=new ArrayList<JRadioButton>();
		for(int i=0;i<p.getRespuestas().length;i++)
		{
			String resp=p.getRespuestas()[i];
			JRadioButton bot=new JRadioButton(resp);
			bg.add(bot);
			this.getContentPane().add(bot);
			bot.addActionListener(new RadioRespListener(i));
			radiosResp.add(bot);
		}
		
		
		
		setSize(200,200);
		setVisible(true);
	}
	
	
	class RadioRespListener implements ActionListener
	{

		private int Ipulsada;
		
		public RadioRespListener(int iPulsada) 
		{
			this.Ipulsada=iPulsada;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(Ipulsada==p.getiCorrecta())
			{
				acertado=true;
			}
			else
			{
				acertado=false;
			}
			setVisible(false);
			
		}
		
	}


	public boolean isAcertado() {
		return acertado;
	}
	
	

}
