import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


public class Interfaz extends JFrame{
private static final long serialVersionUID = 1L;
	
	Botones panel;
	
	public Interfaz() {
		panel = new Botones();
		setTitle("Ejercicio Interceptor");
		add(panel);
	
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	public EstadoInterfaz getEstado(){
		return panel.getEstado();
	}
	
	public void ejecutar(double unaPeticion){
		pack();
		setVisible(true);	
		System.out.println("Revoluciones actuales " + unaPeticion + " rev/min");
	}

}
