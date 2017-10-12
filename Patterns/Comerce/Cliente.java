import java.util.ArrayList;

public class Cliente extends Thread{
	private TipoCliente tipo;
	ArrayList<Conjunto> equiposConsultar = new ArrayList<Conjunto>();
	private static int numeroConsultas = 0;
	private static int maxConsultas = 0;
	
	public Cliente (TipoCliente tipo, ArrayList<Conjunto> equipos){
		this.tipo = tipo;
		this.equiposConsultar = equipos ;
		//this.maxConsultas = max;
	}
	
	public static void setMaximo (int max){
		maxConsultas = max;
	}
	
	private synchronized void aumentarNumeroConsultas(){
		numeroConsultas++;
	}
	
	@Override
	public void run(){
		VisitanteNombre visitanteNombre = new VisitanteNombre();
		VisitantePotencia visitantePotencia = new VisitantePotencia();
		VisitantePrecio visitantePrecio = new VisitantePrecio();
		VisitantePrecioDescuento visitantePrecioDescuento = new VisitantePrecioDescuento(tipo);
		while(numeroConsultas <= maxConsultas){
			aumentarNumeroConsultas();
			for(int i = 0; i < equiposConsultar.size(); i++){
				System.out.println("\nEl cliente de tipo " + tipo + " consulta el equipo " + equiposConsultar.get(i).getNombre());
				equiposConsultar.get(i).getDisco().aceptarVisitante(visitanteNombre);;
				equiposConsultar.get(i).getDisco().aceptarVisitante(visitantePotencia);
				equiposConsultar.get(i).getDisco().aceptarVisitante(visitantePrecio);
				equiposConsultar.get(i).getDisco().aceptarVisitante(visitantePrecioDescuento);
				System.out.println("\tDisco: "+visitanteNombre.getNombreDisco());
				System.out.println("\t\tCapacidad: "+visitantePotencia.getPotenciaDisco());
				System.out.println("\t\tPrecio: "+visitantePrecio.getPrecioDisco()+"€");
				System.out.println("\t\tPrecio con descuento: "+visitantePrecioDescuento.getPrecioDiscoDescuento()+"€");
				equiposConsultar.get(i).getTarjeta().aceptarVisitante(visitanteNombre);
				equiposConsultar.get(i).getTarjeta().aceptarVisitante(visitantePotencia);
				equiposConsultar.get(i).getTarjeta().aceptarVisitante(visitantePrecio);
				equiposConsultar.get(i).getTarjeta().aceptarVisitante(visitantePrecioDescuento);
				System.out.println("\tTarjeta: "+visitanteNombre.getNombreTarjeta());
				System.out.println("\t\tCapacidad: "+visitantePotencia.getPotenciaTarjeta());
				System.out.println("\t\tPrecio: "+visitantePrecio.getPrecioTarjeta()+"€");
				System.out.println("\t\tPrecio con descuento: "+visitantePrecioDescuento.getPrecioTarjetaDescuento()+"€");
				equiposConsultar.get(i).getBus().aceptarVisitante(visitanteNombre);
				equiposConsultar.get(i).getBus().aceptarVisitante(visitantePotencia);
				equiposConsultar.get(i).getBus().aceptarVisitante(visitantePrecio);
				equiposConsultar.get(i).getBus().aceptarVisitante(visitantePrecioDescuento);
				System.out.println("\tBus: "+visitanteNombre.getNombreBus());
				System.out.println("\t\tVelocidad: "+visitantePotencia.getPotenciaBus());
				System.out.println("\t\tPrecio: "+visitantePrecio.getPrecioBus()+"€");
				System.out.println("\t\tPrecio con descuento: "+visitantePrecioDescuento.getPrecioBusDescuento()+"€");
				System.out.println("\tPrecio total: " + visitantePrecio.getPrecioTotal() + "€");
				System.out.println("\tPrecio total con descuento: " + visitantePrecioDescuento.getPrecioTotalDescuento() + "€");
			}
		}

		System.exit(0);
	}
}
