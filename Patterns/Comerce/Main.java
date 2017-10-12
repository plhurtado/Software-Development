import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		Disco disco1 = new Disco("Disco1",512.0,29.95);
		Disco disco2 = new Disco("Disco2",256.0,12.0);
		Disco disco3 = new Disco("Disco3",2048.0,59.95);

		Tarjeta tarjeta1 = new Tarjeta("Tarjeta1",2.0,20.95);
		Tarjeta tarjeta2 = new Tarjeta("Tarjeta2",4.0,34.95);
		Tarjeta tarjeta3 = new Tarjeta("Tarjeta3",8.0,60.95);
		
		Bus bus1 = new Bus("Bus1",1.0,9.95);
		Bus bus2 = new Bus("Bus2",2.0,14.95);
		Bus bus3 = new Bus("Bus3",3.0,19.95);

		Conjunto equipo1 = new Conjunto("equipo1",disco1,tarjeta1,bus1);
		Conjunto equipo2 = new Conjunto("equipo2",disco2,tarjeta2,bus2);
		Conjunto equipo3 = new Conjunto("equipo3",disco3,tarjeta3,bus3);
		
		ArrayList<Conjunto> equipos = new ArrayList<Conjunto>();
		equipos.add(equipo1);
		equipos.add(equipo2);
		equipos.add(equipo3);
		
		Cliente regular = new Cliente(TipoCliente.REGULAR, equipos);
		Cliente vip = new Cliente(TipoCliente.VIP, equipos);
		Cliente mayorista = new Cliente(TipoCliente.MAYORISTA, equipos);
		Cliente.setMaximo(100);
		
		regular.start();
		vip.start();
		mayorista.start();
	}
}
