package modelos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaciarPedidoListener implements ActionListener {

	private VentanaPedido owner;
	
	public VaciarPedidoListener(VentanaPedido vp)
	{
		this.owner=vp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		owner.vaciarPedido();
	}

}
