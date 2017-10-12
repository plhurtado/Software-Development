import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

public class Botones extends JPanel{

private static final long serialVersionUID = 1L;
	
	private EstadoInterfaz estado;
	private JButton botonAcelerar;
	private JToggleButton botonEncender;
	private JLabel eEstado;
	
	public Botones() {
		
		estado = EstadoInterfaz.APAGADO;

		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		JPanel subpanelEtiqueta = new JPanel();
		JPanel subpanelBotones = new JPanel();
		

		subpanelEtiqueta.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		add(subpanelEtiqueta, BorderLayout.NORTH);
		subpanelBotones.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		add(subpanelBotones, BorderLayout.SOUTH);

		eEstado = new JLabel();
		eEstado.setText("APAGADO");
		eEstado.setForeground(new Color(255, 0, 0));
		subpanelEtiqueta.add(eEstado);		
		
		botonEncender = new JToggleButton();
		botonEncender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				botonEncenderActionPerformed(event);
			}
		});
		botonEncender.setText("ENCENDER");
		botonEncender.setForeground(Color.RED);
		subpanelBotones.add(botonEncender);
		
		botonAcelerar = new JButton();
		botonAcelerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				botonAcelerarActionPerformed(event);
			}
		});
		botonAcelerar.setText("Acelerar");
		subpanelBotones.add(botonAcelerar);
		
	}
	

	public EstadoInterfaz getEstado(){
		return estado;
	}
	

	synchronized private void botonEncenderActionPerformed(ActionEvent event){		
		if(botonEncender.isSelected()){
			botonEncender.setText("APAGAR");
			botonEncender.setForeground(Color.BLUE);
			eEstado.setText("ENCENDIDO");
			estado = EstadoInterfaz.ENCENDIDO;
		}
		else{
			botonEncender.setText("ENCENDER");
			botonEncender.setForeground(Color.RED);
			botonAcelerar.setText("Acelerar");
			eEstado.setText("APAGADO");
			estado = EstadoInterfaz.APAGADO;
		}
	}

	synchronized private void botonAcelerarActionPerformed(ActionEvent event){
		if(botonEncender.isSelected()){
			botonAcelerar.setText("Acelerar");
			eEstado.setText("ACELERANDO");
			estado = EstadoInterfaz.ACELERANDO;
		}
	}
}
